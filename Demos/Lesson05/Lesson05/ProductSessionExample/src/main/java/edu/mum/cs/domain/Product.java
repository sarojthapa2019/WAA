package edu.mum.cs.domain;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 5784L;
	private long id;
	private String name;
	private String description;
	private float price;

	// Form related flag -
	// WARNING :: THIS IS A CODE SMELL!!!
	private boolean prgFlag;

	public boolean isPrgFlag() {
		return prgFlag;
	}

	public void setPrgFlag(boolean prgFlag) {
		this.prgFlag = prgFlag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", prgFlag=" + prgFlag + "]";
	}
}