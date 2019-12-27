package entity;


public class Task {
	private Long id;
	private Long year;
	private Long month;
	private Long day;
	private String  information;
	private Long user_id;
	/**
	 * @return the user_id
	 */
	public Long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Task() {
		super();
	}
	
	public Task(Long year, Long month, String information) {
		super();
		this.year = year;
		this.month = month;
		this.information = information;
	}
	
	public Task(Long year, Long month, Long day, String information) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.information = information;
	}
	/**
	 * @return the information
	 */
	public String getInformation() {
		return information;
	}
	/**
	 * @param information the information to set
	 */
	public void setInformation(String information) {
		this.information = information;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the year
	 */
	public Long getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(Long year) {
		this.year = year;
	}
	/**
	 * @return the month
	 */
	public Long getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(Long month) {
		this.month = month;
	}
	/**
	 * @return the day
	 */
	public Long getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(Long day) {
		this.day = day;
	}
	
}