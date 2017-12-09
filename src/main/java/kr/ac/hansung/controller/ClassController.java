package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.ClassService;

@Controller
public class ClassController {

	@Autowired
	private ClassService classService;

	@RequestMapping("/courses")
	public String showClasses(Model model) {
		List<Course> courses = classService.getCurrent();
		model.addAttribute("courses", courses);

		return "courses";
	}


	// 3. 수강 신청하기
	@RequestMapping(value= "/createclass")
	public String createClass(Model model) {

		model.addAttribute("cla", new Course());

		return "createclass";
	}

	@RequestMapping(value= "/docreate")
	public String doCreate(Model model, @Valid Course cla, BindingResult result) {

		model.addAttribute("cla", cla);

		if(result.hasErrors()) {
			System.out.println("===Form data does not validated");
			List<ObjectError> errors=result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "createclass";
		}
		
		classService.insert(cla);
			
		return "classcreated";
	}

	
	// 1. 학기별 이수 학점 조회
	@RequestMapping("/semesterscore")
	public String semesterscore(Model model) {
		int year15=2015;
		int year16=2016;
		int year17=2017;
		int semester1=1;
		int semester2=2;
		
		model.addAttribute("year15", year15);
		model.addAttribute("year16", year16);
		model.addAttribute("year17", year17);
		model.addAttribute("semester1", semester1);
		model.addAttribute("semester2", semester2);
		
		int y15s1=classService.scorecount(year15, semester1);
		int y15s2=classService.scorecount(year15, semester2);
		int y16s1=classService.scorecount(year16, semester1);
		int y16s2=classService.scorecount(year16, semester2);
		int y17s1=classService.scorecount(year17, semester1);
		int y17s2=classService.scorecount(year17, semester2);
		
		model.addAttribute("y15s1",y15s1);
		model.addAttribute("y15s2",y15s2);
		model.addAttribute("y16s1",y16s1);
		model.addAttribute("y16s2",y16s2);
		model.addAttribute("y17s1",y17s1);
		model.addAttribute("y17s2",y17s2);
		
		return "semesterscore";
	}

	@RequestMapping("/semesterscore1")
	public String semesterscore1(@RequestParam("year") int year, @RequestParam("semester") int semester, Model model) {
		
		model.addAttribute("ye",year);
		model.addAttribute("se",semester);
		
		List<Course> courses = classService.getsemesterClasses(year, semester);
		//List<Class> classes = classService.getsemesterClasses(2015, 1);
		model.addAttribute("courses", courses);

		return "semesterscore1";
	}

	
	// 2. 이수 구분별 학점 조회
	@RequestMapping("/kindscore")
	public String kindscore(Model model, Course cla) {

		int total1 = classService.kindscore("교필");
		int total2 = classService.kindscore("핵교A");
		int total3 = classService.kindscore("핵교B");
		int total4 = classService.kindscore("전지");
		int total5 = classService.kindscore("전기");
		int total6 = classService.kindscore("전선");
		int total7 = classService.kindscore("자율");
		int total8 = total1+total2+total3+total4+total5+total6+total7;
		
		model.addAttribute("pg", total1);
		model.addAttribute("hga", total2);
		model.addAttribute("hgb", total3);
		model.addAttribute("jj", total4);
		model.addAttribute("jg", total5);
		model.addAttribute("js", total6);
		model.addAttribute("jy", total7);
		model.addAttribute("total", total8);
		return "kindscore";
	}

	// 4. 수강신청 조회
	@RequestMapping("/newclass")
	public String newclass(Model model, Course cla) {

		List<Course> courses = classService.getsemesterClasses(2018, 1);
		model.addAttribute("courses", courses);

		return "newclass";
	}
}
