package com.moldashev.studentapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final StudentRepository repo;

    public DataLoader(StudentRepository repo) { this.repo = repo; }

    @Override
    public void run(String... args) {
        if (repo.count() == 0) {
            Student s = new Student();
            s.setName("Moldashev Salamat");
            s.setEmail("moldashev.salamat@example.com");
            s.setGroupName("IT2-2308");
            repo.save(s);
        }
    }
}
