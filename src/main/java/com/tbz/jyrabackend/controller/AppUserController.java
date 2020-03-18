package com.tbz.jyrabackend.controller;

import com.tbz.jyrabackend.entities.AppUser;
import com.tbz.jyrabackend.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppUserController {

    private AppUserService appUserService;

    @Autowired
    AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }


    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<AppUser> getUsers() {
        return appUserService.getAllUsers();
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody AppUser appUser, @PathVariable("id") Long id) {
        appUserService.updateUser(appUser);
    }

}
