package br.com.original.repository;

import br.com.original.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by @cardosomarcos on 03/12/17
 */
public interface ChildRepository extends JpaRepository<Child,Integer>{
    List<Child> findByIdpai(Integer id);
}
