package person.demo.mapper;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import person.demo.entity.*;

//操作mybatis的接口
public interface StudentMapper {
	/*
	 * 1.方法名与mapper.xml文件中标签的id值相同
	 * 2.方法的输入参数与mapper.xml文件中标签的parameterType类型一致
	 * 3.方法的返回值与mapper.xml文件中标签的resultType类型一致
	 */
	//通过学号查询
	Student queryStudentByStuno(int stuno);
	
	//查询全部
	List<Student> queryAllStudents();
	
	//增加
	void addStudent(Student student);
	
	//删除
	void deleteStudentByStuno(int stuno);
	
	//修改
	void updateStudentByStuno(Student student);

	Student queryStudentByStunoWithConverter(int stuno);
	
	//使用了转换器增加学生
	void addStudentWithConverter(Student student);
	
	//使用名称查询学生
	Student queryStudentByStuname(String stuName);
	
	//查询全部学生
	List<Student> queryStudentOrderByColumn(String column);
	
	
	List<Student> queryStudentBystuageOrstuName(Student student);
	
	//根据地址查询学生
	List<Student> queryStudentByaddress(Student student);
	
	//传参为HashMap
	List<Student> queryStudentBystuageOrstuNameWithHashMap(Map<String, Object> map);
	
	//查询学生总数
	int queryStudentCount();
	
	
	//根据学号查询学生
	Student queryStuByStuno(int stuNo);
	
	//查询返回值为HashMap
	List<HashMap<String, Object>> queryStudentOutByHashMap();
	
}
