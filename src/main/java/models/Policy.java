package main.java.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Data transfer object for tbl_policy table.
 * @author jeffin
 */
@Entity
@Table(name = "tbl_policy")
public class Policy {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name = "policy_id")
	private int policyId;
	@Column(name = "policy_name")
	private String policyName;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="policy",targetEntity=Vehicle.class)
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>(); 
	
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
}
