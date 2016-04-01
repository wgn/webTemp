package com.zhuani21.jee.base.test.mybatis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ScopeDemo {
	private String s = null;
	private static final String[] ss = new String[]{"a","b"};
	public static final List<String> sss = Collections.unmodifiableList(Arrays.asList(ss));
	public static String[] getSS(){
		return ss.clone();
	}
	
	public void p(){
		System.out.println(s);
		new ScopeInner().toS();
	}
	
	private class ScopeInner{
		public void toS(){
			System.out.println("ScopeInner toS is running ");
		}
	}
	
	public static void main(String[] args) {
		ScopeDemo sd = new ScopeDemo();
		sd.new ScopeInner().toS();
		sd.s = "11";
		sd.p();

	}

}
