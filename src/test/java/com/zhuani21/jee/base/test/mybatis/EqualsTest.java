package com.zhuani21.jee.base.test.mybatis;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class EqualsTest {

	public static void main(String[] args) {
		Set set = new HashSet();
		while(set.size()<1000000){
			long a = System.currentTimeMillis() + new Random().nextInt(100000);
			set.add(a);
		}
	}

}
