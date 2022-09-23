package com.isha.todo.list.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    public List<TasksEntity> getAllTasks() {
        return tasksRepository.findAll();
    }

    public void addTasks(TasksEntity tasks) {
        tasksRepository.save(tasks);
    }

    public void deleteTasks(Integer id) {
        tasksRepository.delete(tasksRepository.findById(id).get());
    }

    public void updateTask(Integer id) {
        TasksEntity task = tasksRepository.findById(id).get();
        task.setDone();

        tasksRepository.save(task);
    }
}
