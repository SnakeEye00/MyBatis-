package person.demo.mapper;


import java.util.List;

import person.demo.entity.Student;

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
	
}
