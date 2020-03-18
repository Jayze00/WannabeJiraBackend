package com.tbz.jyrabackend.services;

import com.tbz.jyrabackend.entities.AppUser;
import com.tbz.jyrabackend.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    private AppUserRepository appUserRepository;

    @Autowired
    AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public void updateUser(AppUser appUser) {
        AppUser user = appUserRepository.findByUsername(appUser.getUsername());
        user.setAdmin(appUser.getAdmin());
        appUserRepository.save(user);
    }

}
