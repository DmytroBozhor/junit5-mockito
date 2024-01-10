package org.example;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.util.Arrays;

public class TestInstancePostProcessorIml implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        var declaredFields = testInstance.getClass().getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> {
            if (field.isAnnotationPresent(UserServiceInjection.class)) {
                field.setAccessible(true);
                try {
                    field.set(testInstance, new UserService());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                field.setAccessible(false);
            }
        });
    }
}
