package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Model.Student;
import Service.Student_Service;
import exceptions.StudentNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
@Api(value="userAPI", description="Student management services ")
public class Controller {
	
	@Autowired
	private Student_Service studentservice;
	
	/*
	@ApiOperation(value = "Add a Student")
	@PostMapping("save-student")
	@ResponseBody
	public boolean saveStudent(@RequestBody Student student) {
		 return studentservice.saveStudent(student);
		
	}
	*/
	@ApiOperation(value = "Add a Student")
	@PostMapping("save-student")
	@ResponseBody
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        studentservice.saveStudent(student);
        return new ResponseEntity("Student saved successfully", HttpStatus.OK);
    }
	
	@ApiOperation(value = "list all Students")
	@GetMapping("students-list")
	public List<Student> allstudents() {
		 return studentservice.getStudents();
	}
	
	/*
	@DeleteMapping("delete-student/{student_id}")
	public boolean deleteStudent(@PathVariable("student_id") int student_id,Student student) {
		student.setStudent_id(student_id);
		return studentservice.deleteStudent(student);
	}
	*/
	@ApiOperation(value = "dlete a Student by using id")
	@DeleteMapping("delete-student/{student_id}")
	public ResponseEntity<?> deleteUser(@PathVariable int student_id, Student student){
		
		 if(student_id == 0) {
		 
				 new StudentNotFoundException(student_id);
		 }
		student.setStudent_id(student_id);
		studentservice.deleteStudent(student);
		
		return ResponseEntity.noContent().build();
	}
	@ApiOperation(value = "get a Student by using id")
	@GetMapping("student/{student_id}")
	public List<Student> allstudentByID(@PathVariable("student_id") int student_id,Student student) {
		 student.setStudent_id(student_id);
			
		 return studentservice.getStudentByID(student);
		
	}
	@ApiOperation(value = "update a Student by using id")
	@PostMapping("update-student/{student_id}")
	public boolean updateStudent(@RequestBody Student student,@PathVariable("student_id") int student_id) {
		student.setStudent_id(student_id);
		return studentservice.updateStudent(student);
	}
	
}
