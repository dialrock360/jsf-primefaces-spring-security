package com.yemmback.primefaces.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {
/*
    private  UserService userService;

    private ConfirmationTokenService confirmationTokenService;



    @PostMapping("/sign-up")
    String signUp(@Valid @RequestBody User user) {
        UserService.signUpUser(user);
        return "sign-in";
    }

    @PostMapping("/sign-in")
    String signIn(User user) {

        UserService.signUpUser(user);

        return "redirect:/sign-in";
    }

    @GetMapping("/confirm")
    String confirmMail(@RequestParam("token") String token) {

        Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);

        optionalConfirmationToken.ifPresent(UserService::confirmUser);

        return "/sign-in";
    }
*/
}
