package net.engineeringdigest.journalApp.service;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import net.engineeringdigest.journalApp.entity.User;

public class UserArgumentsProvider implements ArgumentsProvider {//an interface from JUnit Jupiter that tells JUnit how to integrate test arguments for parametrized tests
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext)throws Exception {//JUnit call this method to get the argument for the test
      
        return Stream.of(
            Arguments.of(User.builder().userName("shyam1").password("shyam1").build()),//wraps test input values into an Arguments
            Arguments.of(User.builder().userName("suraj").password("suraj1").build())
       );
    }
}
