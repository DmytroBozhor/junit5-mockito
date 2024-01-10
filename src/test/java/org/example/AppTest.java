package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({
        TestInstancePostProcessorIml.class
})
@DisplayName("Application tests")
class AppTest {

    @MyInjection
    private String value;

    @Test
    @DisplayName("injecting field value with post processor")
    void testValueInjection() {
        System.out.println(value);
        assertEquals("Injection completed", value);
    }

}