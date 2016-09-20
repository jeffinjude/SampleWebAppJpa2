package main.java.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Data transfer object for tbl_vehicle table.
 * @author jeffin
 */
@Entity
@Table(name = "vehicle_details")
@NamedQuery(name="Vehicle.getAllVehicles", query="SELECT vehicle FROM Vehicle vehicle") 
public class Vehicle {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name = "VEHICLE_ID")
	private Long id;
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="policy_id")
	private Policy policy;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="vehicle",targetEntity=Address.class)
	private Collection<Address> addresses = new ArrayList<Address>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Collection<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}
}
