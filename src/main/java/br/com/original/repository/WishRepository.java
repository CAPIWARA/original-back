package br.com.original.repository;

import br.com.original.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by @cardosomarcos on 03/12/17
 */
public interface WishRepository extends JpaRepository<Wish, Integer> {

    List<Wish> findByIdchild(Integer idchild);
}
