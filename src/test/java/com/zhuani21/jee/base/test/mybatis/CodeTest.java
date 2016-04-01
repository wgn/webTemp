package com.zhuani21.jee.base.test.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhuani21.jee.base.bean.Code;

public class CodeTest {
	
	public static void main(String [] args) throws IOException{
		
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		
		SqlSession sqlSession =new SqlSessionFactoryBuilder().build(in).openSession();
		Code code = new Code();
		code.setType("gender");
		code.setCode("1");
		code.setName("男");
		sqlSession.insert("code.insertCode", code);
		
		sqlSession.commit();
		sqlSession.close();
		System.out.println(code);
	}

}
