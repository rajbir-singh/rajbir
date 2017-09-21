package com.rajbir.core.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.rajbir.core.converter.UserDtoConverter;
import com.rajbir.core.domain.User;
import com.rajbir.core.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Sony on 06-09-2017.
 */
@Service
public class GoogleLoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDtoConverter userDtoConverter;

    private static String CLIENT_ID = "769107420471-782b0i2f3dt9u05dhrb4j21g7ajglrg6.apps.googleusercontent.com";
    private static Logger log = LoggerFactory.getLogger(GoogleLoginService.class);
    //TODO: difference between one or more instances of GoogleIdTokenVerifier
    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new JacksonFactory())
            .setAudience(Collections.singletonList(CLIENT_ID))
            // Or, if multiple clients access the backend:
            //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
            .build();

    // (Receive idTokenString by HTTPS POST)
    public UserDto authenticateGoogleUser(String googleIdToken) {
        User user = null;
        if (googleIdToken != null) {
            GoogleIdToken idToken = null;
            try {
                Map<String, String> pair = new HashMap<String, String>();
                idToken = verifier.verify(googleIdToken);
                if (idToken != null) {
                    GoogleIdToken.Payload payload = idToken.getPayload();
                    String userId = payload.getSubject();
                    System.out.println("User ID: " + userId);

                    //find if user already exists
                    user = userService.findByUserId(userId);
                    if (Utils.isNotEmptyObject(user)) {
                        return userDtoConverter.convertToDto(user);
                    }

                    //else create new user
                    // Get profile information from payload
                    boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
                    String name = (String) payload.get("name");
                    String pictureUrl = (String) payload.get("picture");
                    String locale = (String) payload.get("locale");
                    String familyName = (String) payload.get("family_name");
                    String givenName = (String) payload.get("given_name");

                    User newUser = new User.Builder()
                            .withUserId(userId)
                            .withName(name)
                            .withEmail((String) payload.getEmail())
                            .withMobile(null)
                            .withPassword(null)
                            .withGroups(null)
                            .withAboutMe(null)
                            .build();
                    return userDtoConverter.convertToDto(userService.createUser(newUser));

                } else {
                    return null;
                }

            } catch (GeneralSecurityException e) {
                log.warn(e.getLocalizedMessage());
            } catch (IOException e) {
                log.warn(e.getLocalizedMessage());
            }

        }

        return null;
    }
}