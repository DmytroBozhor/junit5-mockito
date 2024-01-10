package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("User service tests")
public class UserServiceTests {

    private UserService userService;

    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {

        user = new User("Ban");

        userRepository = Mockito.mock(UserRepository.class);

        Mockito.doReturn(user).when(userRepository).save(Mockito.any());

        userService = new UserService(userRepository);

    }

    @Test
    @DisplayName("save user test using mockito")
    void saveUser() {

        var savedUser = userService.saveUser(user);

        assertAll(
                () -> assertThat(savedUser).isNotNull(),
                () -> assertThat(savedUser).isEqualTo(user)
        );

    }

}
