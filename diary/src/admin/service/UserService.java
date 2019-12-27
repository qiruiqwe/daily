package admin.service;

import admin.po.User;

public interface UserService {
	//检验用户登录
		public int checkUser(User user) throws Exception;
}
