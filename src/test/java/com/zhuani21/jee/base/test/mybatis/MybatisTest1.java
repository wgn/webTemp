package com.zhuani21.jee.base.test.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhuani21.jee.base.bean.MyBatisConstant;
import com.zhuani21.jee.base.bean.User;

public class MybatisTest1 {

	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		test5(sqlSession);

		sqlSession.close();
	}

	private static void test1(SqlSession sqlSession) {
		User u = (User)sqlSession.selectOne("user.findUserViaId", 1);
		System.out.println(u.getUsername());
	}
	
	private static void test2(SqlSession sqlSession) {
		List<User> users = sqlSession.selectList("user.findUsersViaName", "小明' or 1=1 or '");
		for(User u :users){
			System.out.println(u.getUsername());
		}
	}
	private static void test3(SqlSession sqlSession) {
		User user  = new User();
		user.setUsername("wgn");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("视信世纪");
		sqlSession.insert("user.insertUser", user);
		sqlSession.commit();
		
		System.out.println(user.toString());
	}

	private static void test4(SqlSession sqlSession) {
		sqlSession.delete("user.deleteUserViaId", 27);
		sqlSession.commit();
	}
	
	private static void test5(SqlSession sqlSession) {
		User user  = new User();
		user.setId(28);
		user.setUsername("吴贵南");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("视信世纪");
		sqlSession.insert("user.updateUser", user);
		sqlSession.commit();
		
		System.out.println(user.toString());
	}
}
