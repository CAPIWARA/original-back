package br.com.original.controller;

import br.com.original.service.CallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by @cardosomarcos on 02/12/17
 */
@RestController
public class UserController {

    @Autowired
    CallbackService callbackService;

    @RequestMapping(value = "/getBalance/{id}")
    public String getBalance(@PathVariable("id") Integer id) throws IOException {
        return callbackService.getBalance(id);
    }
}
