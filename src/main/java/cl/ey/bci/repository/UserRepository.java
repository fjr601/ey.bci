package cl.ey.bci.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ey.bci.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findById(UUID id);

	User findByEmail(String email);
}