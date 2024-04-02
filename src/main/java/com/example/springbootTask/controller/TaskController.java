package com.example.springbootTask.controller;

import com.example.springbootTask.model.Task;
import com.example.springbootTask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public Task createTask(@RequestBody Task task)
    {
        return service.addTask(task);
    }
    @GetMapping
public List<Task> getTasks(){
        return service.findAll();
}

    @GetMapping("/{taskId}")
public Task getTask(@PathVariable String taskId)
{
    return service.getTaskbyTaskID(taskId);
}

@GetMapping("/severity/{severity}")
    public List<Task> findTaskUsingSeverity(@PathVariable int severity)
{
    return service.getTaskBySeverity(severity);
}


    @GetMapping("/assignee/{assignee}")
    public List<Task> GetTaskByAssignee(@PathVariable String assignee)
    {
        return service.getTaskByAssignee(assignee);
    }

    @PutMapping
    public Task modifyTask(@RequestBody Task task)
    {
        return service.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTasks(@PathVariable String taskId)
    {
        return service.deleteTask(taskId);
    }

}
