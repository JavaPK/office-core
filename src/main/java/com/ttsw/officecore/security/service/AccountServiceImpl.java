package com.ttsw.officecore.security.service;

import com.ttsw.officecore.exception.ValidationException;
import com.ttsw.officecore.exception.dto.ErrorDTO;
import com.ttsw.officecore.exception.dto.ErrorsDTO;
import com.ttsw.officecore.security.dto.LoginDTO;
import com.ttsw.officecore.security.dto.RefreshTokenDTO;
import com.ttsw.officecore.security.dto.TokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {

        var user = userDetailsService.loadUserByUsername(loginDTO.getEmail());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()
                )
        );

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return TokenDTO.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public TokenDTO refreshToken(RefreshTokenDTO refreshTokenDTO) {

        var email = jwtService.extractEmail(refreshTokenDTO.getRefreshToken());

        if (email == null) {
            throw new ValidationException(ErrorsDTO.builder().erorrs(List.of(ErrorDTO.of(UUID.randomUUID(), "Email not present in token"))).build());
        }

        var account = userDetailsService.loadUserByUsername(email);

        if (!jwtService.isTokenValid(refreshTokenDTO.getRefreshToken(), account)) {
            throw new ValidationException(ErrorsDTO.builder().erorrs(List.of(ErrorDTO.of(UUID.randomUUID(), "Token valid"))).build());
        }

        var newAccessToken = jwtService.generateToken(account);
        var newRefreshToken = jwtService.generateRefreshToken(account);

        return TokenDTO.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .build();
    }
}
