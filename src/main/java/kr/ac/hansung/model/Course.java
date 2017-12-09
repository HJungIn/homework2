package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	@Range(min=2015,max=2020, message="예시 : 2017")
	private int year;
	
	@Range(min=1,max=2, message="예시 : 1")
	@NotNull(message="학기를 입력해 주세요")
	private int semester;

	@NotEmpty(message="학과코드를 입력해 주세요")
	private String code;
	
	@Size(min=3, message="과목이름을 제대로 입력해 주세요")
	private String name;
	
	@Size(min=2, message="과목종류을 제대로 입력해 주세요")
	private String kind;
	
	private int score;
	
	


	
}
