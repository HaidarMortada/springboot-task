package com.example.springbootTask.service;

import com.example.springbootTask.model.Task;
import com.example.springbootTask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task addTask(Task task)
    {
        task.setTaskID(UUID.randomUUID().toString().split("-")[0]);
       return repository.save(task);
    }

    public List<Task> findAll(){
        return repository.findAll();
    }

    public Task getTaskbyTaskID(String taskID)
    {
        return repository.findById(taskID).get();
    }
    public List<Task> getTaskBySeverity (int severity)
    {
        return repository.findBySeverity(severity);
    }

    public List<Task> getTaskByAssignee(String assignee)
    {
        return repository.getTasksByAssignee(assignee);
    }

    public Task updateTask(Task taskRequest)
    {
       Task existingTask= repository.findById(taskRequest.getTaskID()).get();
       existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
        return repository.save(existingTask);
    }

public String deleteTask(String taskID){
        repository.deleteById(taskID);

        return taskID+" task deleted from dashboard";
}





}
