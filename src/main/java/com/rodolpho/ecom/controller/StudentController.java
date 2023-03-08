package com.rodolpho.ecom.controller;

import com.rodolpho.ecom.bean.Student;

import lombok.Delegate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1, "Thais", "Linda");

        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Thais", "Linda"));
        students.add(new Student(2, "Rodolpho", "Casado com Thais"));

        return ResponseEntity.ok(students);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId){

        Student student = new Student(studentId, "Thais", "linda");

        return ResponseEntity.ok(student);
    }

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student(id, "thais", "linda");
    }

    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("student/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstname());
        return student;
    }

    @DeleteMapping("student/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        return "Usuário deletado";
    }
}
