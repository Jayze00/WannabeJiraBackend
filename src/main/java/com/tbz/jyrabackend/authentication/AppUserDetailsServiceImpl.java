package com.tbz.jyrabackend.authentication;

import static java.util.Collections.emptyList;

import com.tbz.jyrabackend.entities.AppUser;
import com.tbz.jyrabackend.repositories.AppUserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

   private AppUserRepository appUserRepository;

   public AppUserDetailsServiceImpl(AppUserRepository appUserRepository) {
      this.appUserRepository = appUserRepository;
   }

   @Override
   public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      AppUser user = appUserRepository.findByUsername(username);
      if (user == null) {
         throw new UsernameNotFoundException(username);
      }
      return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
   }
}
