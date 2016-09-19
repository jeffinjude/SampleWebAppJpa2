package main.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import main.java.jpamanager.JpaManager;
import main.java.models.Address;
import main.java.models.Party;
import main.java.models.Policy;
import main.java.models.Vehicle;

/**
 * The Service class to handle the crud operations to the database.
 * @author jeffin
 */
public class PersistDataDao {
	
	/**
	 * Function that will insert data into database.
	 * @param Nil.
	 * @return Nil.
	 */
	public void insertData()
	{
		//create the entity manager
		EntityManager entityManager = JpaManager.getEntityManagerFactory().createEntityManager();
		
		//Begin entity manager transaction
		entityManager.getTransaction().begin();
		
		//Remove all the previous data from database
		Query truncateParty = entityManager.createNativeQuery("TRUNCATE TABLE tbl_party;");
		truncateParty.executeUpdate();
		Query truncatePolicy = entityManager.createNativeQuery("TRUNCATE TABLE tbl_policy;");
		truncatePolicy.executeUpdate();
		Query truncateVehicle = entityManager.createNativeQuery("TRUNCATE TABLE tbl_vehicle;");
		truncateVehicle.executeUpdate();
		Query truncateAddress = entityManager.createNativeQuery("TRUNCATE TABLE tbl_address;");
		truncateAddress.executeUpdate();
		/********************************************/
		/*****Vehicle To Address (One to Many)*********/
		/********************************************/
		Address address1 = new Address();
		address1.setAddressName("address1");
		//entityManager.persist(address1);
		Address address2 = new Address();
		address2.setAddressName("address2");
		//entityManager.persist(address2);
		Address address3 = new Address();
		address3.setAddressName("address3");
		//entityManager.persist(address3);
		Address address4 = new Address();
		address4.setAddressName("address4");
		//entityManager.persist(address4);
		
		Vehicle vehicle1 =new Vehicle();
		vehicle1.setVehicleName("VehicleOne");
		vehicle1.getAddress().add(address1);
		vehicle1.getAddress().add(address2);
		address1.setVehicle(vehicle1);
		address2.setVehicle(vehicle1);
		//entityManager.persist(vehicle1);
		Vehicle vehicle2 =new Vehicle();
		vehicle2.setVehicleName("VehicleTwo");
		vehicle2.getAddress().add(address3);
		vehicle2.getAddress().add(address4);
		address3.setVehicle(vehicle2);
		address4.setVehicle(vehicle2);
		//entityManager.persist(vehicle2);
		/********************************************/
		/*****Policy to Vehicle(One to Many)*********/
		/********************************************/
		Policy policy = new Policy();
		policy.setPolicyName("PolicyOne");
		policy.getVehicle().add(vehicle1);
		policy.getVehicle().add(vehicle2);
		vehicle1.setPolicy(policy);
		vehicle2.setPolicy(policy);
		entityManager.persist(policy);
		/*******************************************/
		/*****Party to Policy (Many to One)*********/
		/*******************************************/
		// Multiple parties mapped to same policy
		Party party1 = new Party();
		party1.setName("PartyOne");
		party1.setPolicy(policy);
		entityManager.persist(party1);
		Party party2 = new Party();
		party2.setName("PartyTwo");
		party2.setPolicy(policy);
		entityManager.persist(party2);
		
		//closing the entity manager transaction
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
}
