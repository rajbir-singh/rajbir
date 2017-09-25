package com.rajbir.core.controller;

import com.rajbir.config.BaseController;
import com.rajbir.config.RestResponse;
import com.rajbir.core.domain.Group;
import com.rajbir.core.domain.Post;
import com.rajbir.core.dto.CreateGroupDto;
import com.rajbir.core.dto.GroupSummaryDto;
import com.rajbir.core.repository.PostRepository;
import com.rajbir.core.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created by Sony on 30-08-2017.
 */
@RestController
@RequestMapping(value = "api/v1/group")
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

//    TODO: create a exception handling controller to handle this, learn from ofb
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity
//    handleMethodArgumentNotValidException( MethodArgumentNotValidException error ) {
//        return parseErrors(error.getBindingResult());
//    }

    //create group
    @RequestMapping(value = "/create", method = PUT, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<RestResponse<GroupSummaryDto>> createGroup(@Valid @RequestBody CreateGroupDto createGroupDto, BindingResult result) {
        if (result.hasErrors()) {
            RestResponse<String> restResponse = errorResponse(result.getFieldErrors());
            return notAcceptable(restResponse);
        }
        return ok(newRestResponse(groupService.createGroup(createGroupDto)));
    }

    @RequestMapping(value = "{groupId}", method = GET, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<RestResponse<GroupSummaryDto>> getGroup(@PathVariable Long groupId) {
        return ok(newRestResponse(groupService.findByGroupId(groupId)));
    }

    @RequestMapping("/greet")
    public Post home() {
        return new Post.Builder()
                .withByUserId("e")
                .withByUserName("s")
                .withGroup(null)
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
