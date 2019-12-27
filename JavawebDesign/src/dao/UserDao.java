package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.User;
import util.DBUtil;

public class UserDao {

	/**
	 * 将结果集中的用户 一个一个取出
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private User dump(ResultSet rs) throws SQLException {
		User user = new User();

		user.setId(rs.getLong("id"));
		user.setName(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		return user; 
	}
	/**
	 * 根据id寻找用户
	 * @param id
	 * @return
	 */
	public User findById(Long id) {
		User user = null;
		try (Connection connection = DBUtil.getConnection();) {
			PreparedStatement statement = connection.prepareStatement("select * from user where id=?");
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				user = dump(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return user;
	}

	/**
	 * @param user
	 * @return 如果失败，返回null；如果成功，返回登录用户对象
	 */
	public User add(User user) {
		if (user == null) {
			return null;
		}

		try (Connection connection = DBUtil.getConnection();) {
			PreparedStatement statement = connection.prepareStatement("insert into user(username, password) values(?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			if (statement.executeUpdate() == 0) {
				return null;
			} else {
				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					user.setId(rs.getLong(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return user;
	}

	/**
	 * 
	 * @param name
	 * @param password
	 * @return 如果失败，返回null；如果成功，返回登录用户对象
	 */
	public User login(String name, String password) {
		User user = null;

		try (Connection connection = DBUtil.getConnection();) {
			PreparedStatement statement = connection.prepareStatement("select * from user where username=? and password=?");
			statement.setString(1, name);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				user = dump(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	

	/**
	 * 根据ID删除用户
	 * 
	 * @param id
	 * @return 0：删除失败；1：删除成功
	 */
	public int delete(long id) {
		try (Connection connection = DBUtil.getConnection();) {
			PreparedStatement statement = connection.prepareStatement("delete from user where id=?");
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public User update(User user) {
		if (user == null || user.getId() == null) {
			return null;
		}
		
		try(Connection connection = DBUtil.getConnection();){
			PreparedStatement statement = connection.prepareStatement("update user set username=?, password=? where id=?");
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setLong(3, user.getId());
			
			if (statement.executeUpdate() == 1) {
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		User user2 = new User("zhang", "123");
		User user = new UserDao().add(user2);
		
		System.out.println(user.getName()+" ");
		System.out.println(user.getPassword());
	}
}
