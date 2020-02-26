package com.tbz.jyrabackend.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationFacade implements IAuthenticationFacade {

   @Override
   public Authentication getAuthentication() {
      return org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
   }
}
