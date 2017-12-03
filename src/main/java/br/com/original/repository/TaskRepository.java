package br.com.original.repository;

import br.com.original.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @cardosomarcos on 02/12/17
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
}
