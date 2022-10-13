/**
 * @author sseyha
 * @date 9 តុលា 2022
 *
 */
public class Student {
	private int id;
	private String name;
	private String dateOfBirth;
	private String course;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	public Student(int id, String name, String dateOfBirth, String course) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.course = course;
	}

	public Student(String name, String dateOfBirth, String course) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.course = course;
	}

	public Student() {

	}

}
