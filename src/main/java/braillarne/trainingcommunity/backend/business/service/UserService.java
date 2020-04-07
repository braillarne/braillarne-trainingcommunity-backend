/*
 * Copyright (c) 2020. Nelson Braillard.
 * All rights reserved.
 */

package braillarne.trainingcommunity.backend.business.service;

import braillarne.trainingcommunity.backend.data.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import braillarne.trainingcommunity.backend.data.repository.UserRepository;

@Service
@Validated
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) throws Exception {
        if (user.getId() == null) {
            if (userRepository.findByEmail(user.getEmail()) != null) {
                throw new Exception("Email address " + user.getEmail() + " already assigned another agent.");
            }
        }
        return userRepository.save(user);
    }

    public User getUser(Long id) throws Exception {
        if (id != null) {
            if (userRepository.findUserById(id) == null){
                throw new Exception("User does not exist.");
            }
        }
        return userRepository.findUserById(id);
    }

}
