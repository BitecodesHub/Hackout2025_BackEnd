package com.Hackout.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hackout.models.User;
import com.Hackout.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RegistrationService {

    private final UserRepository userRepository;

    @Autowired
    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validUser(User user) {
    	User existingEmail = userRepository.findByEmail(user.getEmail()).orElse(null);
    	User existingUserName = userRepository.findByUsername(user.getUsername()).orElse(null);
    	if(existingEmail==null && existingUserName==null) {
    		return true;
    	}
    	
    	if((existingEmail!=null && !existingEmail.isEnabled())||(existingUserName!=null && !existingUserName.isEnabled())) {
    		return true;
    	}

    	return false;
    }
   

}
