package vn.dev.laptopshop.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.dev.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController

public class UserControllerApi {

    private UserService userService;

    public UserControllerApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return this.userService.handleHello();
    }

}