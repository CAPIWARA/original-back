package br.com.original.controller;

import br.com.original.entity.Child;
import br.com.original.service.CallbackService;
import br.com.original.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by @cardosomarcos on 02/12/17
 */
@RestController
public class UserController {

    @Autowired
    CallbackService callbackService;

    @Autowired
    ChildService childService;

    @RequestMapping(value = "/getBalance/{id}")
    public Object getBalance(@PathVariable("id") Integer id) throws IOException {
        return callbackService.getBalance(id);
    }

    @RequestMapping(value = "/child/{id}")
    public List<Child> getCard(@PathVariable("id") Integer id) {
        return childService.getChilds(id);
    }

    @RequestMapping(value = "/child/balance/{idchild}")
    public Child getChild(@PathVariable("idchild") Integer id) throws IOException {
        return childService.findById(id);
    }

    @RequestMapping(value = "/history/{id}")
    public Object historyTransaction(@PathVariable("id") Integer id) throws IOException {
        return callbackService.getHistory(id);
    }
}
