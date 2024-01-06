package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.CourseInformation;
import in.ashokit.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService couser;

	
	
	@PostMapping("/insert")
	public ResponseEntity<String> insertRecord(@RequestBody CourseInformation coInformation){
		
		String upsert = couser.upsert(coInformation);
		
		return new ResponseEntity<>(upsert, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<CourseInformation>> getAllData(){
		
		List<CourseInformation> viewAllCourses = couser.viewAllCourses();
		
		return new ResponseEntity<List<CourseInformation>>(viewAllCourses, HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updateRecord(@RequestBody CourseInformation coInformation){
		
		String upsert = couser.upsert(coInformation);
		
		return new ResponseEntity<>(upsert, HttpStatus.OK);
	
	}
	
	
    @GetMapping("/find/{cid}")
	public ResponseEntity<CourseInformation> findRecord(@PathVariable Integer cid){
		
	 CourseInformation course = couser.courseFindbyId(cid);
		
		return new ResponseEntity<CourseInformation>(course, HttpStatus.OK);
	
	}
    
    @DeleteMapping("/delete/{cid}")
	public ResponseEntity<String> deleteRecord(@PathVariable Integer cid){
		
		 String course = couser.deleteCourse(cid);
		
		return new ResponseEntity<>(course, HttpStatus.OK);
	
	}
    	

}
