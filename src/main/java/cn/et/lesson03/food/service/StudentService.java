package cn.et.lesson03.food.service;

import java.util.List;

import cn.et.lesson03.food.entity.Student;
import cn.et.lesson03.food.util.PageTools;

public interface StudentService {

	public abstract PageTools queryStudent(String sname,Integer rows,Integer page);
	public void deleteStudent(Integer sid);
	public void updateStudent(Student student);
}