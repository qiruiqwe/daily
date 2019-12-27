package util;

import java.util.List;

public class Pagination<T> {
	/**
	 * 存放数据项的列表
	 */
	private List<T> list;
	/**
	 * 当前页号，起始于0
	 */
	private int number = 0;
	/**
	 * 页面大小
	 */
	private int size = 4;

	/**
	 * 数据项的总数量
	 */
	private int totalElements;
	
	/**
	 * 需要访问的目标地址ַ
	 */
	private String uri;
	
	public boolean isFirst() {
		if (number == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isLast() {
		if (number == getTotalPages() - 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return 总页面数
	 */
	public int getTotalPages() {
		return totalElements % size == 0 ? totalElements / size : totalElements / size + 1;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
