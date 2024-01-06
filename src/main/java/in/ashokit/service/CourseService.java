package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ashokit.binding.CourseInformation;
import in.ashokit.repo.CourseRepo;

@Service
public class CourseService {
	
	private CourseRepo couRepo;

	public CourseService(CourseRepo couRepo) {
		this.couRepo = couRepo;
	}
	
	
	public String upsert(CourseInformation courseObj) {
		
		CourseInformation save = couRepo.save(courseObj);
		
		return "record is inserted";
	}
	
	
	public CourseInformation courseFindbyId(Integer id) {
		
		Optional<CourseInformation> findById = couRepo.findById(id);
		
		if(findById.isPresent()) {
			
		 return findById.get();	
			
		}else {
			
			return null;
		}
		
}
	
	public List<CourseInformation> viewAllCourses() {
		
		List<CourseInformation> findAll = couRepo.findAll();
		
		return findAll;
		
	}
	
	public String deleteCourse(Integer id) {
		
		boolean byId = couRepo.existsById(id);
		
		if(byId) {
			
			couRepo.deleteById(id);
			return "Successfully deleted";
		}
		
		return "Record Not Found";
		
	}
	
	
}
