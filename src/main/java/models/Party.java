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
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Data transfer object for tbl_party table.
 * @author jeffin
 */
@Entity
@Table(name = "party_details")
@NamedQuery(name="Party.getAllParties", query="SELECT party FROM Party party") 
public class Party {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name = "PARTY_ID")
	private Long id;
	@Column(name = "PARTY_NAME")
	private String name;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "policy_id")
	private Policy policy = new Policy();
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
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

}
