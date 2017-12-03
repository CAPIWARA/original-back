package br.com.original.controller;

import br.com.original.entity.Wish;
import br.com.original.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by @cardosomarcos on 03/12/17
 */
@RestController
public class WishController {

    @Autowired
    private WishService wishService;

    @RequestMapping(value="/wish/{idchild}")
    public List<Wish> getWish(@PathVariable("idchild") Integer idchild){
        System.out.println("ID WISH: " + idchild);
        return wishService.findByIdchild(idchild);
    }
}
