package com.zhuani21.jee.base.test.mybatis;

import com.zhuani21.jee.base.test.model.ExtendObj;
import com.zhuani21.jee.base.test.model.ExtendObjSub;

public class ExtendObjTest {

	public static void main(String[] args) {
		ExtendObj eo = new ExtendObjSub();
		eo.toS();

	}

}
