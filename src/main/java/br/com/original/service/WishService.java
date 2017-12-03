package br.com.original.service;

import br.com.original.entity.Wish;
import br.com.original.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by @cardosomarcos on 03/12/17
 */
@Service
public class WishService {

    @Autowired
    WishRepository wishRepository;


    public List<Wish> findByIdchild(Integer idchild) {
        System.out.println("Find idchild: " + idchild);
        return wishRepository.findByIdchild(idchild);
    }
}
