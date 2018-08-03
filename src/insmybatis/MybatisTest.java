package insmybatis;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import dao.EmployeeMapper;
import entity.Employee;




public class MybatisTest {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return  new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	@Test
 public  void test() throws IOException {
	 String resource = "mybatis-config.xml";
	 InputStream inputStream = Resources.getResourceAsStream(resource);
	 SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	 //獲取sqlsession實例
	 SqlSession openSession = sqlSessionFactory.openSession();
	 try {
		 Employee employee = openSession.selectOne("com.mybatis.selectEmp", 1);
		 System.out.println(employee.getLastname());
	 } finally{
		 openSession.close();
		 }
 }
	@Test
    public void test01() throws IOException {
    	//获取sqlsessionFactory对象
    	SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    	//获取sqlSession对象
    	SqlSession openSession = sqlSessionFactory.openSession();
    	//获取接口的实现类
    	//回为接口自动创建一个代理对象，代理对象去执行增删改查方法
    	try{EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
    	
    	Employee employee = mapper.getEmpById(1);
    	System.out.println(employee);
    	}finally {
    		openSession.close();
    	}
    	
    }
	
}
