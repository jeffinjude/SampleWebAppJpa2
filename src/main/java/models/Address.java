package main.java.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Data transfer object for tbl_address table.
 * @author jeffin
 */
@Entity
@Table(name = "tbl_address")
public class Address {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;
	@Column(name = "address_name")
	private String addressName;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
