package com.rajbir.core.controller;

import com.rajbir.config.BaseController;
import com.rajbir.core.domain.Group;
import com.rajbir.core.domain.Post;
import com.rajbir.core.repository.PostRepository;
import com.rajbir.core.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sony on 30-08-2017.
 */
@RestController(value = "ap1/v1/group")
public class GroupController extends BaseController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getPosts() {
        return postRepository.findAll();
//        return null;
    }

    @RequestMapping(value = "/list", params = {"page", "size"}, method = RequestMethod.GET)
    @ResponseBody
    private List<Group> getGroupsList(@RequestParam("page") int page, @RequestParam("size") int size) {
        return groupService.findGroupsPageable(new PageRequest(page, size)).getContent();
    }



    @RequestMapping("/greet")
    public Post home() {
        return new Post.Builder()
                .withByUserId("e")
                .withByUserName("s")
                .build();
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
