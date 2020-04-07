/*
 * Copyright (c) 2020. Nelson Braillard.
 * All rights reserved.
 */

package braillarne.trainingcommunity.backend.data.repository;

import braillarne.trainingcommunity.backend.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findUserById(Long id);
	User findByEmail(String email);
	User findByName(String name);
	User findByEmailAndIdNot(String email, Long agentId);
}
