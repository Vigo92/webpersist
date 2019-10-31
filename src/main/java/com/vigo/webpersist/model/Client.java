package com.vigo.webpersist.model;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name="client")
@XmlRootElement
public class Client {

	@Id
	private int id;

	private String name;

	//private Date date;

	private int fees;

	public Client() {

	}

	public Client(int id, String name, int fees) {
		this.id = id;

		this.name = name;

		this.fees = fees;

	//	this.date = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}*/

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", date=" + ", fees=" + fees + "]";
	}

}
