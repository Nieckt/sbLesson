package cn.et.lesson01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.et.lesson01.dao.EmpRepository;


@EnableAutoConfiguration
@RestController
public class SbController {
	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	EmpRepository er;
	
	@RequestMapping("/hello")
	public Map hello() {
		Map map = new HashMap();
		map.put("id", 1);
		map.put("name", "zs");
		return map;
	}
	
	@RequestMapping("emp/{empId}")
	public Map query(@PathVariable String empId) {
		List<Map<String, Object>> result = jdbc.queryForList("select * from emp where id="+empId);
		return result.get(0);
	}
	
	@RequestMapping("/saveEmp")
	public String saveEmp() {
		Emp emp = new Emp();
		emp.setEname("王祖贤");
		emp.setSal(30000);
		emp.setDeptid(4);
		er.save(emp);
		return "1";
	}
	
	@RequestMapping("/queryEmp/{id}")
	public Emp queryEmp(@PathVariable Integer id) {
		Emp emp = er.findOne(id);
		return emp;
	}
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(SbController.class, args);
    }
	
}
