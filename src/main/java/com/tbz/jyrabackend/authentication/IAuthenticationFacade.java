package com.tbz.jyrabackend.authentication;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {

   Authentication getAuthentication();
}
