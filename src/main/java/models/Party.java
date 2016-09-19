package main.java.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * The Data transfer object for tbl_party table.
 * @author jeffin
 */
@Entity
@Table(name = "tbl_party")
public class Party {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name = "party_id")
	private int partyId;
	@Column(name = "party_name")
	private String Name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "policy_id")
	private Policy policy = new Policy();

	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
}
