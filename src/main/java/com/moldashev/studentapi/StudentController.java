package com.moldashev.studentapi;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository repo;

    public StudentController(StudentRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Student> all() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Student> one(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student s) {
        s.setId(null);
        return repo.save(s);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student in) {
        return repo.findById(id).map(s -> {
            s.setName(in.getName());
            s.setEmail(in.getEmail());
            s.setGroupName(in.getGroupName());
            return ResponseEntity.ok(repo.save(s));
        }).orElse(ResponseEntity.notFound().build());
    }
}
