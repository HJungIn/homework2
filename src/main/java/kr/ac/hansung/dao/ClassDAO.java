package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository // annotation 사용
public class ClassDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired // annotation 사용
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from classes";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// query and return a single object
	public Course getClass(String name) {
		String sqlStatement = "select * from classes where name=?";

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { name }, new RowMapper<Course>() { // 한번 쓰고 버릴때
																											// 익명클래스 사용
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course cla = new Course();

				cla.setYear(rs.getInt("year"));
				cla.setSemester(rs.getInt("semester"));
				cla.setCode(rs.getString("code"));
				cla.setName(rs.getString("name"));
				cla.setKind(rs.getString("kind"));
				cla.setScore(rs.getInt("score"));

				return cla; // ppt.20
			}

		});
	}

	// query and return multiple object
	public List<Course> getClasses() {
		String sqlStatement = "select * from classes";

		return jdbcTemplate.query(sqlStatement, // 복수일 때는 query사용
				new RowMapper<Course>() { // 한번 쓰고 버릴때 익명클래스 사용
					public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

						Course cla = new Course();

						cla.setYear(rs.getInt("year"));
						cla.setSemester(rs.getInt("semester"));
						cla.setCode(rs.getString("code"));
						cla.setName(rs.getString("name"));
						cla.setKind(rs.getString("kind"));
						cla.setScore(rs.getInt("score"));

						return cla; // ppt.20
					}

				});
	}


	// 1번 학기별 이수 학점 조회
	public List<Course> getsemesterClasses(int year, int semester) {
		String sqlStatement = "select * from classes where year=? and semester=?";
		
		return jdbcTemplate.query(sqlStatement, // 복수일 때는 query사용
				new RowMapper<Course>() { // 한번 쓰고 버릴때 익명클래스 사용
					public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

						Course cla = new Course();

						cla.setYear(rs.getInt("year"));
						cla.setSemester(rs.getInt("semester"));
						cla.setCode(rs.getString("code"));
						cla.setName(rs.getString("name"));
						cla.setKind(rs.getString("kind"));
						cla.setScore(rs.getInt("score"));
						
						return cla; // ppt.20
					}

				}, year, semester);
		
	}
	public int getScoreCount(int year, int semester) {
		String sqlStatement = "select sum(score) from classes where year=? and semester=?";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class , year, semester);
	}
	
	
	// 2번 학기별 이수 학점 조회
	public int getKindCount(String kind) {
		String sqlStatement = "select sum(score) from classes where kind=?";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class , kind);
	}

	//3번 추가
	public boolean insert(Course cla) {

		int year = cla.getYear();
		int semester = cla.getSemester();
		String code = cla.getCode();
		String name = cla.getName();
		String kind = cla.getKind();
		int score = cla.getScore();

		String sqlStatement = "insert into classes (year, semester, code, name, kind, score) values (?, ?, ?, ?, ?, ?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, code, name, kind, score }) == 1);
	}

}
