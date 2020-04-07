/*
 * Copyright (c) 2020. Nelson Braillard.
 * All rights reserved.
 */

package braillarne.trainingcommunity.backend.api;

import braillarne.trainingcommunity.backend.business.service.ExerciseService;
import braillarne.trainingcommunity.backend.data.domain.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api")
public class ExerciseEndpoint {
    @Autowired
    private ExerciseService exerciseService;

    @PostMapping(path = "/exercise", consumes = "application/json", produces = "application/json")
    public Exercise postExercise(@RequestBody Exercise exercise) {

        try {
            return exerciseService.saveExercise(exercise);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }

    @PostMapping(path = "/exercise/new", consumes = "application/json", produces = "application/json")
    public Exercise postExercise(@RequestParam String userID) {

        try {
            return exerciseService.newExercise(Long.parseLong(userID));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }

    @GetMapping(path = "/exercise", produces = "application/json")
    public Exercise getExercise(@RequestParam String id) {

        try {
            return exerciseService.getExercise(Long.parseLong(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}