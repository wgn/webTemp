package com.zhuani21.jee.base.test.mybatis;

import com.zhuani21.jee.base.test.model.Obj;

public class StaticFactoryMethodTest {

	public static void main(String[] args) {
		Obj obj = Obj.getObjInstance();
		Obj obj1 =  Obj.getObjInstance();
		System.out.println(obj==obj1);
		obj.toS();
	}

}
