package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import net.engineeringdigest.journalApp.repository.UserRepository;

// It connect Spring Security’s authentication system with your database.
@Component
public class UserDetailsServiceImp implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{//Spring Security calls this method during login.
       User user=  userRepository.findByUserName(username);
       if(user!=null){
          UserDetails userdetails=org.springframework.security.core.userdetails.User.builder()//it builds an object
          .username(user.getUserName())
          .password(user.getPassword())
          .roles((user.getRoles()).toArray(new String[0]))
          .build();
          return userdetails;
       }
        throw new UsernameNotFoundException("User not found with username: "+username);
    }
}
