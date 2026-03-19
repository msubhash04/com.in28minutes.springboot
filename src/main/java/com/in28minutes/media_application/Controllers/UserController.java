package com.in28minutes.media_application.Controllers;

import com.in28minutes.media_application.Entity.User;
import com.in28minutes.media_application.Services.UserNotFoundException;
import com.in28minutes.media_application.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserController {

    private UserService userService;
    private MessageSource messageSource;

    public UserController(UserService userService,MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @GetMapping("/users")
    public List<User> retriveAllData(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retriveUser(@PathVariable int id)
    {
        User user = userService.findUserById(id);

        if(user == null)
            throw new UserNotFoundException("Id : "+id);

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addNewUser(@Valid @RequestBody User user){
        User savedUser = userService.addNewUser(user);

        //How Its working  /users/4  => means users is /users means path and 4 is appended id.
        // .fromCurrentRequest() this function will give /users means it will give path of current request.

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteById(id);
    }

    //Extra  Internationalization topic en:-Good Morning, nl:- Goedemorgen, fn:- Bonjour, de:- Guten Morgen
    @GetMapping(path="/hello-world-internationalized")
    public String helloWorldInternationalization()
    {
        Locale locale=LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message", locale);
    }



}
