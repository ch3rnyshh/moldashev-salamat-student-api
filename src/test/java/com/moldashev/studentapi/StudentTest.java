package com.moldashev.studentapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StudentTest {
    @Test
    void studentKeepsName() {
        Student s = new Student();
        s.setName("Moldashev Salamat");
        assertEquals("Moldashev Salamat", s.getName());
    }
}
