package main.java.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Data transfer object for tbl_address table.
 * @author jeffin
 */
@Entity
@Table(name = "address_details")
@NamedQuery(name="Address.getAllAddresses", query="SELECT adr FROM Address adr") 
public class Address {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	private Long id;
	@Column(name = "CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
