package person.demo.test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import person.demo.entity.*;
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
	
	public static void queryStudentById() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		System.out.println(studentMapper.queryStudentById(1).toString());
		session.close();
	}
	
	public static void queryStudentByIdWithHashMap() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		System.out.println(studentMapper.queryStudentByIdWithHashMap(1).toString());
		session.close();
	}
	
	public static void queryStuByStuno() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		System.out.println(studentMapper.queryStuByStuno(1).toString());
		session.close();
	}
	
	//查询学生总数
	public static void queryStudentCount() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		System.out.println(studentMapper.queryStudentCount());
		session.close();
	}
	
	//通过姓名查询一个学生
		public static void queryStudentByStuname() throws IOException {
			Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			System.out.println(studentMapper.queryStudentByStuname("zs").toString());
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
	
	
	//查询全部学生返回值用HashMap存储
		public static void queryStudentOutByHashMap() throws IOException {
			Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactoty = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactoty.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			List<HashMap<String, Object>> studentsMap = studentMapper.queryStudentOutByHashMap();
			System.out.println(studentsMap.toString());
			session.close();
		}
	
	//查询全部学生通过stuNo降序排序
		public static void queryStudentOrderByColumn() throws IOException {
			Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactoty = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactoty.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			List<Student> students = studentMapper.queryStudentOrderByColumn("stuno");
			System.out.println(students.toString());
			session.close();
		}
		
		
		public static void queryStudentBystuageOrstuName() throws IOException {
			Student student = new Student();
			student.setStuAge(23);
			student.setStuName("%w%z");
			Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactoty = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactoty.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			List<Student> students = studentMapper.queryStudentBystuageOrstuName(student);
			System.out.println(students.toString());
			session.close();
		}
		
		//根据姓名和年龄查找学生---传入参数类型为HashMap
		public static void queryStudentBystuageOrstuNameWithHashMap() throws IOException {
			Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactoty = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactoty.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			Map<String , Object> studentMap = new HashMap<String, Object>();
			studentMap.put("stuAge", 22);
			studentMap.put("stuName", "ls");
			List<Student> students = studentMapper.queryStudentBystuageOrstuNameWithHashMap(studentMap);
			System.out.println(students.toString());
			session.close();
		}
		
		//根据地址查询学生
		public static void queryStudentByaddress() throws IOException {
			Student student = new Student();
			Address address = new Address();
			address.setHomeAddress("jn");
			address.setSchoolAddress("yt");
			student.setAddress(address);
			Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactoty = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactoty.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			List<Student> students = studentMapper.queryStudentByaddress(student);
			System.out.println(students.toString());
			session.close();
		}
		
	//添加学生
	public static void addStudents() throws IOException {
		Student student = new Student(6 , "ll" , 22 , "g4");
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		studentMapper.addStudent(student);
		session.commit();
		session.close();
	}
	//添加学生带转换器
		public static void addStudentsWithConverter() throws IOException {
			Student student = new Student(8 , "ll" , 22 , "g4" , true);
			Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			studentMapper.addStudentWithConverter(student);
			session.commit();
			session.close();
			System.out.println("增加成功");
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
	
	//带有stuSex的查询 使用了转换器
	public static void queryStudentByStunoWithConverter() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		System.out.println(studentMapper.queryStudentByStunoWithConverter(1).toString());
		session.close();
	}
	
	
	public static void main(String[] args) throws IOException {
//		addStudentsWithConverter();
//		queryStudentByStunoWithConverter();
//		queryAllStudents();
//		addStudents();
//		queryAllStudents();
//		updateStudents();
//		deleteStudents();
//		queryAllStudents();
//		queryStudentByStuno();
//		queryStudentByStuname();
//		queryStudentOrderByColumn();
//		queryStudentBystuageOrstuName();
//		queryStudentByaddress();
//		queryStudentBystuageOrstuNameWithHashMap();
//		queryStudentCount();
//		queryStuByStuno();
//		queryStudentOutByHashMap();
//		queryStudentById();
		queryStudentByIdWithHashMap();
	}
}
