package br.com.original.repository;

import br.com.original.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by @cardosomarcos on 02/12/17
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
