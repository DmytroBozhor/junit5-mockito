package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({
        TestInstancePostProcessorIml.class
})
@DisplayName("Application tests")
class AppTest {

    @UserServiceInjection
    private UserService userService;

    @Test
    @DisplayName("injecting field value with post processor")
    void testValueInjection() {
        assertThat(userService).isEqualTo(new UserService());
    }

}