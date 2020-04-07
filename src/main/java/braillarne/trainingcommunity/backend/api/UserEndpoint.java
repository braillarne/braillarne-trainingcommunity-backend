/*
 * Copyright (c) 2020. Nelson Braillard.
 * All rights reserved.
 */

package braillarne.trainingcommunity.backend.api;

import braillarne.trainingcommunity.backend.business.service.UserService;
import braillarne.trainingcommunity.backend.data.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api")
public class UserEndpoint {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public User postCustomer(@RequestBody User user) {

        try {
            return userService.saveUser(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }

    @GetMapping(path = "/user", produces = "application/json")
    public User getUser(@RequestParam String id) {

        try {
            return userService.getUser(Long.parseLong(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}