package net.engineeringdigest.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import net.engineeringdigest.journalApp.repository.UserRepository;


@Disabled

public class UserDetailsServiceImplTests {
    @InjectMocks //Create an instance of UserDetailsServiceImp, and automatically inject the mocks into it
    private UserDetailsServiceImp userDetailsService;
    @Mock
    private UserRepository userRepository;

    @BeforeEach//means this method runs before every test case
    void setUp(){
        MockitoAnnotations.openMocks(this);// initializes all the @Mock and @InjectMocks annotations in this class
    }

    @Test
    void loadUserByUsernameTest(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn( User.builder().userName("ram").password("abcdef").roles(new ArrayList<>()).build());
        UserDetails user=userDetailsService.loadUserByUsername("ram");
        assertNotNull(user);
    }
}
