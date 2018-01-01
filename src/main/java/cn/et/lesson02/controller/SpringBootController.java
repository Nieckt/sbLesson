package cn.et.lesson02.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.et.lesson02.entity.Emp;
import cn.et.lesson02.mapper.EmpMapper;

@RestController
public class SpringBootController {
	@Autowired
	DataSource dataSource;
	@Autowired
	EmpMapper em;
	
	@RequestMapping("/sysoSource")
	public List<Emp> hello() {
		return em.queryEmp();
	}
	
}
