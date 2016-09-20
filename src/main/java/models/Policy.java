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
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * The Data transfer object for tbl_policy table.
 * @author jeffin
 */
@Entity
@Table(name = "policy_details")
@NamedQuery(name="Policy.getAllPolicies", query="SELECT policy FROM Policy policy") 
public class Policy {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name = "POLICY_ID")
	private Long id;
	@Column(name = "POLICY_NAME")
	private String name;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="policy",targetEntity=Party.class)
	private Collection<Party> parties = new ArrayList<Party>();
	@OneToMany(cascade=CascadeType.ALL,mappedBy="policy",targetEntity=Vehicle.class)
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
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
	public Collection<Party> getParties() {
		return parties;
	}
	public void setParties(Collection<Party> parties) {
		this.parties = parties;
	}
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	} 
}
