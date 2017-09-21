package com.rajbir.core.controller;

import com.rajbir.config.BaseController;
import com.rajbir.config.RestResponse;
import com.rajbir.core.converter.UserDtoConverter;
import com.rajbir.core.dto.UserDto;
import com.rajbir.core.service.GoogleLoginService;
import com.rajbir.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Sony on 06-09-2017.
 */
@RestController
@RequestMapping("api/v1/googleLogin")
public class GoogleLoginController extends BaseController {

    private static final Logger controllerLogger = LoggerFactory.getLogger(GoogleLoginController.class);
    private static final Logger serviceLogger = LoggerFactory.getLogger(GoogleLoginService.class);

    @Autowired
    private GoogleLoginService googleLoginService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDtoConverter userDtoConverter;

    //TODO:change this to post and get the id in payload
    @RequestMapping(value="/login", method= RequestMethod.GET, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<RestResponse<UserDto>> googleLogin(@RequestParam  String googleIdToken) {
        serviceLogger.info(" ############################# serviceLogger #############################");
        controllerLogger.info(" ############################# controllerLogger #############################");
        return ok(newRestResponse(googleLoginService.authenticateGoogleUser(googleIdToken)));
    }


//    @RequestMapping(value = "/create", method = PUT, consumes = APPLICATION_JSON_VALUE)
//    @ResponseBody
//    private UserDto createUser() {
////        return userDtoConverter.convertToDto(userService.createUser(user));
//        return "yes";
//    }

}
