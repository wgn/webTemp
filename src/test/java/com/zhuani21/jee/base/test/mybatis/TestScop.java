package com.zhuani21.jee.base.test.mybatis;

import java.util.Collections;
import java.util.List;

public class TestScop {
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		for(int i=0;i<10000000;i++){
			/*List<String> sss = ScopeDemo.sss;
			if(2==sss.size()){
				sss = null;
			}*/
			/*String[] ss = ScopeDemo.getSS();
			if(2==ss.length){
				ss = null;
			}*/
		}
		
		System.out.println(System.currentTimeMillis()-s);
	}

}
