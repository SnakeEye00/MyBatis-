package person.demo.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import person.demo.entity.Student;
import person.demo.mapper.StudentMapper;

public class Test {
	//查询一个学生
	public static void queryStudentByStuno() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		System.out.println(studentMapper.queryStudentByStuno(1).toString());
		session.close();
	}
	
	//查询全部学生
	public static void queryAllStudents() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactoty = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactoty.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		List<Student> students = studentMapper.queryAllStudents();
		System.out.println(students.toString());
		session.close();
	}
	//添加学生
	public static void addStudents() throws IOException {
		Student student = new Student(5 , "王睿" , 22 , "g4");
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		studentMapper.addStudent(student);
		session.commit();
		session.close();
	}
	//删除学生
	public static void deleteStudents() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		studentMapper.deleteStudentByStuno(5);
		session.commit();
		session.close();
	}
	//修改学生
	public static void updateStudents() throws IOException {
		Student student = new Student(4 , "ll" , 20 , "g4" );
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		studentMapper.updateStudentByStuno(student);
		session.commit();
		session.close();
	}
	
	public static void main(String[] args) throws IOException {
		queryAllStudents();
		addStudents();
		queryAllStudents();
		updateStudents();
		deleteStudents();
		queryAllStudents();
		queryStudentByStuno();
	}
}
