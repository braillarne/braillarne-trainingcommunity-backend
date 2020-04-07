/*
 * Copyright (c) 2020. Nelson Braillard.
 * All rights reserved.
 */

package braillarne.trainingcommunity.backend.business.service;

import braillarne.trainingcommunity.backend.data.domain.Exercise;
import braillarne.trainingcommunity.backend.data.domain.User;
import braillarne.trainingcommunity.backend.data.repository.ExerciseRepository;
import braillarne.trainingcommunity.backend.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    UserRepository userRepository;

    public Exercise saveExercise(Exercise exercise) {

        return exerciseRepository.save(exercise);
    }

    public Exercise getExercise(Long id) throws Exception {
        if (id != null) {
            if (exerciseRepository.findExerciseById(id) == null){
                throw new Exception("Exercise does not exist.");
            }
        }
        return exerciseRepository.findExerciseById(id);
    }

    public Exercise newExercise(Long userID) {
        User owner = userRepository.findUserById(userID);

        Exercise newExercise = new Exercise();
        newExercise.setName("Exercise " + newExercise.getId());
        newExercise.setUser(owner);

        return exerciseRepository.save(newExercise);

    }

}
