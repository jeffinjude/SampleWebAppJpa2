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
@NamedNativeQueries({
	@NamedNativeQuery(
	name        = "FetchData",
	query       = "SELECT policy.policy_name,party.party_name,vehicle.vehicle_name,address.address_name FROM tbl_party party"
					+"INNER JOIN tbl_policy policy ON party.policy_id = policy.policy_id"
					+"INNER JOIN, tbl_policy_vehicle policy_vehicle ON policy_vehicle.policy_id =  policy.policy_id"
					+"INNER JOIN tbl_vehicle vehicle ON vehicle.vehicle_id = policy_vehicle.vehicle_id"
					+"INNER JOIN tbl_vehicle_address vehicle_address ON vehicle_address.vehicle_id = vehicle.vehicle_id"
					+"INNER JOIN tbl_address address ON address.address_id = vehicle_address.address_id"
	)
})
public class Party {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name = "party_id")
	private int partyId;
	@Column(name = "party_name")
	private String Name;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
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
