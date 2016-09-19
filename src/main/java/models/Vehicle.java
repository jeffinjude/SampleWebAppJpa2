package main.java.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Data transfer object for tbl_vehicle table.
 * @author jeffin
 */
@Entity
@Table(name = "tbl_vehicle")
public class Vehicle {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private int vehicleId;
	@Column(name = "vehicle_name")
	private String vehicleName;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="policy_id")
	private Policy policy;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="vehicle",targetEntity=Address.class)
	private Collection<Address> address = new ArrayList<Address>(); 
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public Collection<Address> getAddress() {
		return address;
	}
	public void setAddress(Collection<Address> address) {
		this.address = address;
	}
	
}
