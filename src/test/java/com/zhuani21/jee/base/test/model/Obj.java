package com.zhuani21.jee.base.test.model;

public class Obj {
	private Obj(){}
	
	private static Obj obj = null;
	
	public static Obj getObjInstance(){
		if(null==obj){
			synchronized(Obj.class){
				if(null==obj){
					obj = new Obj().new ObjChild();
				}
			}
		}
		return obj;
	}
	
	public void toS(){
		System.out.println(this.getClass().getName());
	}
	
	private class ObjChild extends Obj{
		
	}

}
