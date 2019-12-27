package admin.mapper;

import admin.po.User;

public interface UserMapper {
	//检验用户登录
	public int checkUser(User user) throws Exception;
}
