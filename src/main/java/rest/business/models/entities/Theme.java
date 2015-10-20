package rest.business.models.entities;

public class Theme {

	private int id;

	private String name;

	public Theme() {
	}

	public Theme(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
