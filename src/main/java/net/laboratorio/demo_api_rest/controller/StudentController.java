package net.laboratorio.demo_api_rest.controller;

import net.laboratorio.demo_api_rest.entity.Student;
import net.laboratorio.demo_api_rest.servicio.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/students")

public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public ResponseEntity<?> findAllStudent(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        Student student = studentService.findById(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.ok(student);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student studentToUpdate = studentService.studentUpdate(id, student);
        if (studentToUpdate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }else {
            return ResponseEntity.ok(studentToUpdate);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        studentService.studentDelete(id);
        return ResponseEntity.ok().build();
    }



}
