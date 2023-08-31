package main;

import main.model.Task;
import main.model.TaskRepository;
import main.model.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping(value = "/toDo/")
    public int addTask(@RequestBody Task task) {
        task.setCreationTime(LocalDateTime.now());
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    @GetMapping("/toDo/")
    public List<Task> showAllTasks() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @GetMapping("/toDo/{id}")
    public ResponseEntity getTask(@PathVariable Integer id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return new ResponseEntity(optionalTask.get(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/toDo/")
    public ResponseEntity deleteAllTasks() {
        taskRepository.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/toDo/{id}")
    public ResponseEntity deleteTask(@PathVariable Integer id) {
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            taskRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @PatchMapping("/toDo/{id}")
    public ResponseEntity changeTask(@PathVariable Integer id, @RequestBody TaskRequest taskRequest) {
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            Optional<Task> optional = taskRepository.findById(id);
            Task task = optional.get();
            if (taskRequest.isDone() != null){
                task.setDone(taskRequest.isDone());
            }
            if (taskRequest.getDescription() != null){
                task.setDescription(taskRequest.getDescription());
            }
            if (taskRequest.getTitle() != null){
                task.setTitle(taskRequest.getTitle());
            }
            taskRepository.save(task);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}