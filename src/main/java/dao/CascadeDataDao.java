package main.java.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import main.java.jpamanager.JpaManager;
import main.java.models.Address;
import main.java.models.Vehicle;

/**
 * The Service class to implement JPA cascade operations.
 * @author jeffin
 */
public class CascadeDataDao {
	
	/**
	 * Function that will implement cascade operations.
	 * @param Nil.
	 * @return Nil.
	 */
	public void cascadeData()
	{
		//create the entity manager
		EntityManager entityManager = JpaManager.getEntityManagerFactory().createEntityManager();
		
		//Begin entity manager transaction
		entityManager.getTransaction().begin();
		
		//Remove all the previous data from database
		Query truncateParty = entityManager.createNativeQuery("TRUNCATE TABLE party_details;");
		truncateParty.executeUpdate();
		Query truncatePolicy = entityManager.createNativeQuery("TRUNCATE TABLE policy_details;");
		truncatePolicy.executeUpdate();
		Query truncateVehicle = entityManager.createNativeQuery("TRUNCATE TABLE vehicle_details;");
		truncateVehicle.executeUpdate();
		Query truncateAddress = entityManager.createNativeQuery("TRUNCATE TABLE address_details;");
		truncateAddress.executeUpdate();
		
		/*******************************************/
		/*************Persist Operation*************/
		/*******************************************/
		Address adr1 = new Address();
		adr1.setCity("City1");
		adr1.setState("State1");
		Address adr2 = new Address();
		adr2.setCity("City2");
		adr2.setState("State2");
		
		Vehicle vehicle1 =new Vehicle();
		vehicle1.setVehicleName("Vehicle1");
		vehicle1.getAddresses().add(adr1);
		vehicle1.getAddresses().add(adr2);
		adr1.setVehicle(vehicle1);
		adr2.setVehicle(vehicle1);
		
		//Only vehicle1 is persisted but since in the entity bean cascade is set to all adr1 and adr2 are also persisted
		entityManager.persist(vehicle1);
		vehicle1.setVehicleName("Vehicle1_updated_after_persist");//Any change made after PERSIST will get updated in the database
		
		/*******************************************/
		/*************MERGE Operation*************/
		/*******************************************/
		Address adr3 = new Address();
		adr3.setCity("City3");
		adr3.setState("State3");
		Address adr4 = new Address();
		adr4.setCity("City4");
		adr4.setState("State4");
		
		Vehicle vehicle2 =new Vehicle();
		vehicle2.setVehicleName("Vehicle2");
		vehicle2.getAddresses().add(adr3);
		vehicle2.getAddresses().add(adr4);
		adr3.setVehicle(vehicle2);
		adr4.setVehicle(vehicle2);
		
		//Only vehicle2 is persisted but since in the entity bean cascade is set to all adr3 and adr4 are also persisted
		Vehicle vehicleMergeEntity = entityManager.merge(vehicle2);
		vehicle2.setVehicleName("Vehicle2_updated");//Any change made after MERGE will not get updated in the database
		//Changes made to the merge entity (vehicleMergeEntity) will get updated in the database
		vehicleMergeEntity.setVehicleName("Vehicle2_updated_after_merge");
		
		/*******************************************/
		/*************REMOVE Operation*************/
		/*******************************************/
		Address adrToDel1 = new Address();
		adrToDel1.setCity("City");
		adrToDel1.setState("State");
		Address adrToDel2 = new Address();
		adrToDel2.setCity("City");
		adrToDel2.setState("State");
		
		Vehicle vehicleToDel =new Vehicle();
		vehicleToDel.setVehicleName("Vehicle");
		vehicleToDel.getAddresses().add(adrToDel1);
		vehicleToDel.getAddresses().add(adrToDel2);
		adrToDel1.setVehicle(vehicleToDel);
		adrToDel2.setVehicle(vehicleToDel);
		
		//insert the entity
		entityManager.persist(vehicleToDel);
		//Remove the entity
		//entityManager.remove(adrToDel1);
		//entityManager.remove(adrToDel2);
		entityManager.remove(vehicleToDel);//Since cascade type is set to all the child address entities are also removed.
		
		/*******************************************/
		/*************REFRESH Operation*************/
		/*******************************************/
		vehicle1.setVehicleName("New Vehicle"); //Vehicle name modified in the entity (in memory)
		System.out.println("Vehicle Name before refresh :" + vehicle1.getVehicleName()); //Output : New Vehicle
		entityManager.refresh(vehicle1); // Vehicle entity is refreshed with data from the database and this is loaded into memory
		System.out.println("Vehicle Name after refresh :" + vehicle1.getVehicleName()); // Outputs the vehicle name present in the db
		
		//closing the entity manager transaction
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
