package cn.et.lesson03.food.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import cn.et.lesson03.food.entity.Student;
import cn.et.lesson03.food.entity.StudentExample;
@Mapper
public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Mon Dec 11 11:40:06 CST 2017
     */
    @SelectProvider(type=StudentSqlProvider.class, method="countByExample")
    long countByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Mon Dec 11 11:40:06 CST 2017
     */
    @DeleteProvider(type=StudentSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Mon Dec 11 11:40:06 CST 2017
     */
    @Delete({
        "delete from student",
        "where SID = #{sid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer sid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Mon Dec 11 11:40:06 CST 2017
     */
    @Insert({
        "insert into student (SID, SNAME, ",
        "SEX, AGE, ADDRESS)",
        "values (#{sid,jdbcType=INTEGER}, #{sname,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=INTEGER}, #{age,jdbcType=INTEGER}, #{address,jdbcType=VARCHAR})"
    })
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Mon Dec 11 11:40:06 CST 2017
     */
    @InsertProvider(type=StudentSqlProvider.class, method="insertSelective")
    int insertSelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Mon Dec 11 11:40:06 CST 2017
     */
    @SelectProvider(type=StudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="SID", property="sid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="SNAME", property="sname", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEX", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="AGE", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR)
    })
    List<Student> selectByExampleWithRowbounds(StudentExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Mon Dec 11 11:40:06 CST 2017
     */
    @SelectProvider(type=StudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="SID", property="sid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="SNAME", property="sname", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEX", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="AGE", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR)
    })
    List<Student> selectByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Mon Dec 11 11:40:06 CST 2017
     */
    @Select({
        "select",
        "SID, SNAME, SEX, AGE, ADDRESS",
        "from student",
        "where SID = #{sid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="SID", property="sid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="SNAME", property="sname", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEX", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="AGE", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR)
    })
    Student selectByPrimaryKey(Integer sid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Mon Dec 11 11:40:06 CST 2017
     */
    @UpdateProvider(type=StudentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Mon Dec 11 11:40:06 CST 2017
     */
    @UpdateProvider(type=StudentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Mon Dec 11 11:40:06 CST 2017
     */
    @UpdateProvider(type=StudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Mon Dec 11 11:40:06 CST 2017
     */
    @Update({
        "update student",
        "set SNAME = #{sname,jdbcType=VARCHAR},",
          "SEX = #{sex,jdbcType=INTEGER},",
          "AGE = #{age,jdbcType=INTEGER},",
          "ADDRESS = #{address,jdbcType=VARCHAR}",
        "where SID = #{sid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Student record);
}