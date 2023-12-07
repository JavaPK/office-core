package com.ttsw.officecore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceProviderImpl implements UserServiceProviderStab {

    private final UserRepository userRepository;

    @Override
    public User getUserByUuid(UUID uuid){
       return userRepository.find;
    }

}
