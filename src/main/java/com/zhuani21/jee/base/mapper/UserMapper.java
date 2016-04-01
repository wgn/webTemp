package com.zhuani21.jee.base.mapper;

import java.util.List;

import com.zhuani21.jee.base.bean.Orders;
import com.zhuani21.jee.base.bean.User;
import com.zhuani21.jee.base.bean.UserCustom;

public interface UserMapper {
	
	public User findUserViaId(int id) throws Exception;
	
	public List<User> findUsersViaName(String name) throws Exception;

	public void insertUser(User u) throws Exception;
	
	public void deleteUserViaId(int id) throws Exception;
	
	public void updateUser(User u) throws Exception;
	
	public List<UserCustom> findUserCustomViaCustom(UserCustom uc) throws Exception;
	
	public List<Orders> findOrders() throws Exception;
	
	public List<Orders> lazyLoadOrders() throws Exception;
}
