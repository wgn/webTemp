package com.zhuani21.jee.base.auto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zhuani21.jee.base.bean.Unno;
import com.zhuani21.jee.base.mapper.UnnoMapper;

public class ImportUnnoDataIntoDB {

	public static void main(String[] args) throws IOException, ParseException {
		String fileName ="C:\\Users\\vuclip111\\Desktop\\111.txt";
		
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UnnoMapper unnoMapper = sqlSession.getMapper(UnnoMapper.class);
		List<Unno> unnoList = getUnnoList(fileName);
		unnoMapper.insertUnnoList(unnoList);
		sqlSession.commit();
		sqlSession.close();
	}

	private static List<Unno> getUnnoList(String fileName) throws IOException, ParseException {
		List<Unno> retList = new ArrayList<Unno>();
		File f = new File(fileName);
		if(f.isFile()){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(StringUtils.isNotBlank(line)){
				Unno unno = new Unno();
				String[] fields = line.split("	 ");
				String s = fields[0].trim();
				char[] s1 = s.toCharArray();
				for(char s11:s1){
					System.out.println(Integer.toBinaryString(s11));
				}
				if(s.length()>8){
					s = s.substring(1);
				}
				Date cDate = sdf1.parse(s);
				unno.setPeriod(cDate);
				unno.setPre_value(Float.parseFloat(fields[1].replaceAll("万", "")));
				try{
				unno.setNow_value(Float.parseFloat(fields[2].replaceAll("万", "")));
				}catch(Exception e){
					if("-".equals(fields[2].replaceAll("万", ""))){
						unno.setNow_value(0);
					}
				}
				unno.setCreate_date(sdf.parse(fields[3]));
				retList.add(unno);
				line = br.readLine();
			}
			br.close();
		}
		return retList;
	}

}
