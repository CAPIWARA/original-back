package br.com.original.repository;

import br.com.original.entity.Callback;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by @cardosomarcos on 02/12/17
 */
public interface CallbackRepository extends JpaRepository<Callback, Integer> {
}
