package cn.et.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.et.lesson02.entity.Emp;

@Mapper
public interface EmpMapper {
	@Select("select * from emp")
	List<Emp> queryEmp();
}
