package com.isha.todo.list.tasks;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    TasksService tasksService;

    @GetMapping("")
    public ResponseEntity get() {
        return ResponseEntity.status(200).body(tasksService.getAllTasks());
    }

    @PostMapping("")
    public ResponseEntity add(@RequestBody ObjectNode objectNode){
        String task = objectNode.get("task").asText();

        try {
            tasksService.addTasks(new TasksEntity(task));
            return ResponseEntity.status(200).body("Saved!");
        }
        catch(Exception e){
            return ResponseEntity.status(404).body("Uh oh" + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id){
        try{
            tasksService.updateTask(id);
            return ResponseEntity.status(200).body("task done!");
        }
        catch (Exception e){
            return  ResponseEntity.status(404).body("Error" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity delete(@PathVariable Integer id){
        try{
            tasksService.deleteTasks(id);
            return ResponseEntity.status(200).body("task deleted!");
        }
        catch (Exception e){
            return ResponseEntity.status(404).body("uh oh!" + e.getMessage());
        }
    }
}
