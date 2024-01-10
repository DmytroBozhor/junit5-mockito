package org.example;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.util.Arrays;

public class TestInstancePostProcessorIml implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        var declaredFields = testInstance.getClass().getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> {
            if (field.isAnnotationPresent(MyInjection.class)) {
                field.setAccessible(true);
                try {
                    field.set(testInstance, "Injection completed");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                field.setAccessible(false);
            }
        });
    }
}
