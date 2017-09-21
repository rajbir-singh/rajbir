package com.rajbir.core.controller;

import com.rajbir.config.BaseController;
import com.rajbir.config.RestResponse;
import com.rajbir.core.converter.UserDtoConverter;
import com.rajbir.core.dto.UserDto;
import com.rajbir.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Sony on 12-09-2017.
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDtoConverter userDtoConverter;

    @RequestMapping(value = "list", method = GET, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RestResponse<List<UserDto>>> getUsers() {
        return ok(newRestResponse(userService.findAll()));
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.GET, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<RestResponse<UserDto>> getUserById(@PathVariable String userId) {
        return ok(newRestResponse(userDtoConverter.convertToDto(userService.findByUserId(userId))));
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<RestResponse<UserDto>> updateUser(@RequestBody UserDto userDto) {
        return ok(newRestResponse(userDtoConverter.convertToDto(userService.updateUser(userDto))));
    }

    @RequestMapping(value ="search", params = {"query"}, method = RequestMethod.GET, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<RestResponse<List<UserDto>>> searchUsers(@RequestParam("query") String query) {
        return ok(newRestResponse(userService.getUserDtosFromUsersList(userService.searchByNameOrMobileOrEmail(query))));
    }

}
