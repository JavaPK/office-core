package com.ttsw.officecore.security.service;

import com.ttsw.officecore.exception.ValidationException;
import com.ttsw.officecore.exception.dto.ErrorDTO;
import com.ttsw.officecore.exception.dto.ErrorsDTO;
import com.ttsw.officecore.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    //TODO: Roles to add
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var account = accountRepository.findByEmail(username)
                .orElseThrow(() -> new ValidationException(ErrorsDTO.builder()
                        .erorrs(List.of(ErrorDTO.of(UUID.randomUUID(), "Account not found"))).build()));

        return User.builder()
                .username(account.getEmail())
                .password(account.getPassword())
                .authorities(List.of(new SimpleGrantedAuthority("USER")))
                .disabled(!account.isActive())
                .build();
    }
}
