package com.ttsw.officecore.security.service;

import com.ttsw.officecore.security.dto.LoginDTO;
import com.ttsw.officecore.security.dto.RefreshTokenDTO;
import com.ttsw.officecore.security.dto.TokenDTO;

public interface AccountService {

    TokenDTO login(LoginDTO loginDTO);

    TokenDTO refreshToken(RefreshTokenDTO refreshTokenDTO);
}
