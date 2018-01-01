package cn.et.lesson03.food.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.et.lesson03.food.entity.Result;
import cn.et.lesson03.food.entity.Student;
import cn.et.lesson03.food.service.StudentService;
import cn.et.lesson03.food.util.PageTools;

@Controller
public class StudentController {
	@Autowired
	StudentService service;
	@ResponseBody
	@RequestMapping("/queryStudent")
	public PageTools queryStudent(String sname,Integer rows,Integer page) {
		return service.queryStudent(sname, rows, page);
	}
	
	@ResponseBody
	@RequestMapping(value="/student/{sid}",method=RequestMethod.DELETE)
	public Result deleteStudent(@PathVariable Integer sid) {
		Result r = new Result();
		r.setCode(1);
		try{
			service.deleteStudent(sid);
		}catch(Exception e){
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value="/student/{sid}",method=RequestMethod.PUT)
	public Result updateStudent(@PathVariable Integer sid,Student student) {
		student.setSid(sid);
		Result r = new Result();
		r.setCode(1);
		try{
			service.updateStudent(student);
		}catch(Exception e){
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value="/student",method=RequestMethod.POST)
	//@PathVariable ��reast�����Ҫ��������ȡֵ�Ļ���Ҫ��ע��
	//MultipartFile�ϴ��ļ�
	public Result saveStudent(Student student,MultipartFile myImage) {
		Result r = new Result();
		r.setCode(1);
		try{
			//��ȡ�ϴ��ļ����ļ���
			String fileName=myImage.getOriginalFilename();
			File destFile = new File("E:\\"+fileName);
			myImage.transferTo(destFile);
			//service.updateStudent(student);
		}catch(Exception e){
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
}
