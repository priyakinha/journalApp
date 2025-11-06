package net.engineeringdigest.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;

import  net.engineeringdigest.journalApp.entity.User ;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import net.engineeringdigest.journalApp.repository.UserRepository;


@Disabled
@SpringBootTest
public class userServiceTests{
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private  UserService userService;
   
 
    @ParameterizedTest
    // @ValueSource(strings={
    //     "ram",
    //     "shyam",
    //     "vipul"
    // })
    @ArgumentsSource(UserArgumentsProvider.class)
    @Transactional
    //@Test
    public void testSaveNewUser(User user){
        // User user=userRepository.findByUserName("ram");
        // assertNotNull(!user.getJournalEntries().isEmpty());
        //assertNotNull(userRepository.findByUserName(name));
        // assertTrue(userService.saveNewUser(user));
    }
    @Disabled
    @ParameterizedTest
    @CsvSource({
        "1,1,2",
        "2,10,12",
        "3,3,9"
    })
    public void test(int a,int b,int expected){
        assertEquals(expected, a+b);
    }
}
