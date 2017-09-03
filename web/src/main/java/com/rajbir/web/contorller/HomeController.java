package com.rajbir.web.contorller;

import com.rajbir.core.domain.Post;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sony on 30-08-2017.
 */
@RestController
public class HomeController {

//    @Autowired
//    private UserRepository userRepository;

    @RequestMapping("/greet")
    public Post home() {
        return new Post(1l, "message", null, 1.0, 2.0);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String getPosts() {
        return "posts";
    }

//    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
//    public User getUser(@PathVariable String userId) {
//        return userRepository.findById(userId);
//    }
//
//    //TODO: user UserDto instead of User
//    @RequestMapping(value = "/register", method = POST)
//    public String processRegistration(
//            @Valid User user,
//            Errors errors) {
//        if (errors.hasErrors()) {
//            return "registerForm";
//        }
//        userRepository.save(user);
//        return "redirect:/user/" + user.getId();
//    }
}
