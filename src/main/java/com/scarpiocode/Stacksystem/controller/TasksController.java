package com.scarpiocode.Stacksystem.controller;

import com.scarpiocode.Stacksystem.model.Tasks;
import com.scarpiocode.Stacksystem.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TasksController {
    @Autowired
    private TasksService tasksService;
    @PostMapping
    public ResponseEntity<Tasks> saveTasks(@RequestBody Tasks task){
        Tasks addedTasks = tasksService.createTasks(task);
        return new ResponseEntity<>(addedTasks, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks(){
        List<Tasks> tasksList= tasksService.getAll();
        return new ResponseEntity<>(tasksList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tasks> getTaskById(@PathVariable Long id){
        return new ResponseEntity<>(tasksService.getTaskById(id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Tasks> update(@PathVariable Long id, @RequestBody Tasks updateTask){
        return new ResponseEntity<>(tasksService.update(id, updateTask), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
           tasksService.deleteTasks(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/markComplete/{id}")
    public ResponseEntity<String> markComplete(@PathVariable Long id){
        return new ResponseEntity<>(tasksService.completeTasks(id),HttpStatus.OK);
    }




}
