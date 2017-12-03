package br.com.original.controller;

import br.com.original.entity.Task;
import br.com.original.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by @cardosomarcos on 02/12/17
 */
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/task/{idchild}", method = RequestMethod.GET)
    public List<Task> taskList(@PathVariable("idchild") Integer idchild) {
        return taskService.findByIdchild(idchild);
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public Task addTask(@RequestBody Task task) {
        task.setId(0L);
        System.out.println("ADD TASK: " + task.toString());
        return taskService.addTask(task);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
    public Task changeTask(@PathVariable("id") Integer id, @RequestBody Task task) {
        System.out.println("CHANGE TASK: " + task.toString());
        if (id == null) return null;
        task.setId(Long.valueOf(id));
        return taskService.changeTask(task);
    }
}
