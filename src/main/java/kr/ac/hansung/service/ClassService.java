package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.ClassDAO;
import kr.ac.hansung.model.Course;

@Service
public class ClassService {

	@Autowired
	private ClassDAO classDao; 
	
	public List<Course> getCurrent() {
		return classDao.getClasses();
		
	}

	public void insert(Course cla) {
		classDao.insert(cla);
		
	}

	public List<Course> getsemesterClasses(int year, int semester) {
		return classDao.getsemesterClasses(year, semester);
	}

	public int scorecount(int year, int semester) {
		return classDao.getScoreCount(year, semester);
	}
	
	public int kindscore(String kind) {
		return classDao.getKindCount(kind);
	}



}
