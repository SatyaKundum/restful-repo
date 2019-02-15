package model;

public class Customer {

	private Long id;
	private String name;

	public Customer() {
	}

	public Customer(Long i, String name) {
		super();
		this.id = i;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
