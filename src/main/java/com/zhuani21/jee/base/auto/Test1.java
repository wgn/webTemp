package com.zhuani21.jee.base.auto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test1 {

	public static void main(String[] args) throws ParseException, IOException {
		String fileName ="C:\\Users\\vuclip111\\Desktop\\111.txt";
		File f = new File(fileName);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		System.out.println(line);
		String sx = "2015年11月	 27.10万	 -	 2015-12-04";
		String[] sss = line.split("	 ");
		String[] ss = new String[]{"2015年11月","a"};
		String s = "2015年11月";
		System.out.println(s.length() );
		System.out.println(sss[0].length() );
		System.out.println("-"+ sss[0] + "-" + s.trim().equals(sss[0].trim()));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月");
		System.out.println(sdf1.parse(sss[0].trim()));
	}

}
