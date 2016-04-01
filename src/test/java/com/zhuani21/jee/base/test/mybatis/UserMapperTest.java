package com.zhuani21.jee.base.test.mybatis;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zhuani21.jee.base.bean.OrderDetail;
import com.zhuani21.jee.base.bean.Orders;
import com.zhuani21.jee.base.bean.User;
import com.zhuani21.jee.base.bean.UserCustom;
import com.zhuani21.jee.base.mapper.UserMapper;

public class UserMapperTest {
	
	SqlSessionFactory sqlSessionFactory = null;
	@Before
	public void setUpBeforeClass() throws Exception {
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}

	@Test
	public void testFindUserViaId() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User u = userMapper.findUserViaId(28);
		sqlSession.close();
		System.out.println(u);
		
	}

	@Test
	public void testFindUsersViaName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.findUsersViaName("wgn");
		sqlSession.close();
		for(User u :  users){
			System.out.println(u);
		}
	}

	@Test
	public void testInsertUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User u = new User();
		u.setUsername("Lee");
		u.setBirthday(new Date());
		u.setAddress("Calgary");
		u.setSex("0");
		userMapper.insertUser(u);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(u);
	}

	@Test
	public void testDeleteUserViaId() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUserViaId(29);
		userMapper.deleteUserViaId(30);
		userMapper.deleteUserViaId(31);
		userMapper.deleteUserViaId(32);
		userMapper.deleteUserViaId(33);
		userMapper.deleteUserViaId(34);
		userMapper.deleteUserViaId(35);
		userMapper.deleteUserViaId(36);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdateUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User u = userMapper.findUserViaId(37);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse("1985-01-05");
		u.setBirthday(d);
		userMapper.updateUser(u);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testFindUserCustomViaCustom() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserCustom uc = new UserCustom();
		User user = new User();
		//user.setUsername("张");
		//user.setSex("1");
		uc.setU(user);
		
		List<UserCustom> ucList = userMapper.findUserCustomViaCustom(uc);
		for(UserCustom u :  ucList){
			System.out.println(u);
		}
		sqlSession.close();
	}

	@Test
	public void testFindOrders() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<Orders> ucList = userMapper.findOrders();
		for(Orders u :  ucList){
			System.out.println(u);
		}
		sqlSession.close();
	}
	@Test
	public void testLazyLoadOrders() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Orders t = null;
		List<Orders> ucList = userMapper.lazyLoadOrders();
		
		
			t = ucList.get(0);
			
			OrderDetail od = t.getOrderDetailList().get(0);
		
			System.out.println("XXX" + od.getId());
			od.setId(od.getId()+1);
			
			System.out.println(t.getOrderDetailList().get(0).getId());
		
		sqlSession.close();
	}

}
