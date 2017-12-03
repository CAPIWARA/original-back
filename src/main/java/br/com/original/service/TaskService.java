package br.com.original.service;

import br.com.original.entity.Task;
import br.com.original.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by @cardosomarcos on 02/12/17
 */
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    public Task changeTask(Task task) {
        taskRepository.save(task);
        System.out.println("SERVICE: " + task.toString());
        return task;
    }

    public List<Task> findByIdchild(Integer idchild) {
        return taskRepository.findByIdchild(idchild);
    }
}
