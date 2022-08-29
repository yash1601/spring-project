package com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {


    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
    @PostMapping
//    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid")
    public ResponseEntity<Student> registerNewStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.addNewStudent(student));

    }
    @DeleteMapping("/{Studentid}")
    void deleteEmployee(@PathVariable Long Studentid) {
        studentService.deleteStudent(Studentid);
    }


}
