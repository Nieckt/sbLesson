package cn.et.lesson03.food.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lesson03.food.dao.StudentMapper;
import cn.et.lesson03.food.entity.Student;
import cn.et.lesson03.food.entity.StudentExample;
import cn.et.lesson03.food.service.StudentService;
import cn.et.lesson03.food.util.PageTools;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentMapper sm;
	/* (non-Javadoc)
	 * @see cn.et.lesson03.food.service.impl.StudentService#queryStudent(java.lang.String)
	 */
	public PageTools queryStudent(String sname,Integer rows,Integer page) {
		if(sname==null){
			sname="";
		}
		StudentExample se = new StudentExample();
		//������Ҫ�Լ���%
		se.createCriteria().andSnameLike("%"+sname+"%");
		int total = queryStudentCount(se);
		PageTools pts = new PageTools(page, total, rows);
		RowBounds rb = new RowBounds(pts.getStartIndex()-1,rows);
		List<Student> studentList = sm.selectByExampleWithRowbounds(se, rb);
		pts.setRows(studentList);
		return pts;
	}
	
	/**
	 * ɾ��
	 */
	public void deleteStudent(Integer sid) {
		sm.deleteByPrimaryKey(sid);
	}
	
	/**
	 * 
	 * 
	 * @param se
	 * @return
	 */
	public void updateStudent(Student student) {
		sm.updateByPrimaryKey(student);
	}
	
	public int queryStudentCount(StudentExample se) {
		
		int total = (int)sm.countByExample(se);
		return total;
	}
}
