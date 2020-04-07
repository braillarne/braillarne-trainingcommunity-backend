/*
 * Copyright (c) 2020. Nelson Braillard.
 * All rights reserved.
 */

package braillarne.trainingcommunity.backend.data.repository;

import braillarne.trainingcommunity.backend.data.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
	Exercise findExerciseById(Long id);
	Exercise findByName(String name);
}
