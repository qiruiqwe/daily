package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Task;
import util.DBUtil;
import util.Pagination;

public class TaskDao {

	private Task dump(ResultSet rs) throws SQLException {
		Task Task = new Task();

		Task.setId(rs.getLong("id"));
		Task.setYear(rs.getLong("year"));
		Task.setMonth(rs.getLong("month"));
		Task.setDay(rs.getLong("day"));
		Task.setInformation(rs.getString("information"));
		Task.setUser_id(rs.getLong("user_id"));
		return Task;
	}

	public List<Long> findYearsById(Long u_id) {
		List<Long> years = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection();) {
			PreparedStatement statement = connection.prepareStatement("select distinct year from Task where user_id = ? order by `year` DESC");
			statement.setLong(1, u_id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()){
				years.add(rs.getLong("year"));
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return years;
	}
	public List<Task> findAllById(Long u_id) {
		List<Task> tasks = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection();) {
			PreparedStatement statement = connection.prepareStatement("select * from Task where user_id = ? order by `year` DESC");
			statement.setLong(1, u_id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				tasks.add(dump(rs));
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return tasks;
	}

	public Pagination<Task> findAll(Pagination<Task> pagination) {
		try (Connection connection = DBUtil.getConnection();) {
			PreparedStatement statement = connection.prepareStatement("select * from Task order by `year` DESC limit ?,? " );
			statement.setInt(1, pagination.getNumber() * pagination.getSize());
			statement.setInt(2, pagination.getSize());
			ResultSet rs = statement.executeQuery();
			List<Task> tasks = new ArrayList<>();
			while (rs.next()) {
				tasks.add(dump(rs));
			}
			pagination.setList(tasks.size() == 0 ? null : tasks);

			statement = connection.prepareStatement("select count(*) from Task");
			rs = statement.executeQuery();
			rs.next();
			pagination.setTotalElements(rs.getInt(1));
		} catch (SQLException e) {
			// e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return pagination;
	}

	public Task findById(Long id) {
		Task Task = null;
		try (Connection connection = DBUtil.getConnection();) {
			PreparedStatement statement = connection.prepareStatement("select * from Task where id=?");
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Task = dump(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Task;
	}

	/**
	 * @param Task
	 * @return 如果失败，返回null；如果成功，返回登录用户对象
	 */
	public Task add(Task Task) {
		if (Task == null) {
			return null;
		}

		try (Connection connection = DBUtil.getConnection();) {
			PreparedStatement statement = connection.prepareStatement(
					"insert into Task (year,month,day,information,user_id) values(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, Task.getYear());
			statement.setLong(2, Task.getMonth());
			System.out.println(Task.getDay());
			statement.setLong(3, Task.getDay());
			statement.setString(4, Task.getInformation());
			statement.setLong(5, Task.getUser_id());
			if (statement.executeUpdate() == 0) {
				return null;
			} else {
				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					Task.setId(rs.getLong(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return Task;
	}

	/**
	 * 根据ID删除task
	 * 
	 * @param id
	 * @return 0：删除失败；1：删除成功
	 */
	public int delete(long id) {
		try (Connection connection = DBUtil.getConnection();) {
			PreparedStatement statement = connection.prepareStatement("delete from Task where id=?");
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 更新task信息
	 * 
	 * @param Task
	 * @return
	 */
	public Task update(Task Task) {
		if (Task == null || Task.getId() == null) {
			return null;
		}

		try (Connection connection = DBUtil.getConnection();) {
			PreparedStatement statement = connection
					.prepareStatement("update Task set year=?, month=?,day=?,information=? where id=?");
			statement.setLong(1, Task.getYear());
			statement.setLong(2, Task.getMonth());
			statement.setLong(3, Task.getDay());
			statement.setString(4, Task.getInformation());
			statement.setLong(5, Task.getId());
			if (statement.executeUpdate() == 1) {
				return Task;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
//		Task task = new Task();
//		task.setYear(2013L);
//		task.setMonth(6L);
//		task.setDay(6L);
//		task.setInformation("发布国内首个HTML5实验室");
//		task.setUser_id(1L);
//		Task Task = new TaskDao().add(task);
		List<Task> tasks = new TaskDao().findAllById(1L);
		System.out.println(tasks);
//		System.out.println(Task.getYear() + " ");
//		System.out.println(Task.getMonth());
	}
}
