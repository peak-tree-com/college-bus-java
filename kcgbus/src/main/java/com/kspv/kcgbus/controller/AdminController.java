package com.kspv.busapp.controller;

import com.kspv.kcgbus.model.Student;
import com.kspv.kcgbus.service.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    private Admin adminService;
    public AdminController(Admin adminService) {
        super();
        this.adminService = adminService;
    }
    @PostMapping("save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(adminService.saveStudent(student), HttpStatus.CREATED);
    }
    @GetMapping("getAll")
    public List<Student> getAllStudent() {
        return adminService.getAllStudent();
    }
    @GetMapping("get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id)
    {
        return new ResponseEntity<Student>(adminService.getStudent(id), HttpStatus.OK);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        return new ResponseEntity<Student>(adminService.updateStudent(id,student), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        adminService.deleteStudent(id);
        return new ResponseEntity<String>("student delete successful", HttpStatus.OK);
    }
}