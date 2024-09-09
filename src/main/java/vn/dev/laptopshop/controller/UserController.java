package vn.dev.laptopshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import vn.dev.laptopshop.domain.User;
import vn.dev.laptopshop.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHello();
        model.addAttribute("user", test);
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getCreate(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
    // public String CreateUserPage(Model model , @ModelAttribute("newUser") User thanh) {
    //     System.out.println("haha vao day roi " + thanh );
    //     return "Tạo thành công";
    // }
    @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
public ResponseEntity<String> CreateUserPage(@ModelAttribute("newUser") User thanh) {
    System.out.println("haha vào đây rồi " + thanh);
    return new ResponseEntity<>("Tạo thành công", HttpStatus.OK);
}
}

// @RestController
// public class UserController {

// private UserService userService;

// public UserController(UserService userService) {
// this.userService = userService;
// }

// @GetMapping("")
// public String getHomePage() {
// return this.userService.handleHello();
// }
// }
