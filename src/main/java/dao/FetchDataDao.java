package main.java.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import main.java.jpamanager.JpaManager;
import main.java.models.Address;
import main.java.models.Party;
import main.java.models.Policy;
import main.java.models.Vehicle;


public class FetchDataDao {
	
	
	
	public List<Object[]> fetchData()
	{		
		//create the entity manager
		EntityManager entityManager = JpaManager.getEntityManagerFactory().createEntityManager();
		
		//Begin entity manager transaction
		entityManager.getTransaction().begin();
		
		System.out.println("Getting details of a single policy : ");
		String query = "SELECT u FROM Policy u where u.name= :policyName";
		Query policyQuery = entityManager.createQuery(query,Policy.class).setParameter("policyName", "PolicyOne");
		List<Policy> fetchedPolicyData = policyQuery.getResultList();
		for(Policy data : fetchedPolicyData) {
			System.out.println(data.getName());
			Iterator<Vehicle> itr = data.getVehicles().iterator();
			while (itr.hasNext()) {
				Vehicle v = itr.next();
				System.out.println("Vehicle : " + v.getVehicleName());
			}
			System.out.println("------------------");
		}
		
		//Fetching all the data
		Query q = entityManager.createNativeQuery("SELECT policy.policy_name,party.party_name,vehicle.vehicle_name,address.city,address.state FROM party_details party INNER JOIN policy_details policy ON party.policy_id = policy.policy_id INNER JOIN vehicle_details vehicle ON vehicle.policy_id = policy.policy_id INNER JOIN address_details address ON address.vehicle_id = vehicle.vehicle_id");
		List<Object[]> fetchedData = q.getResultList();
		
		System.out.println("********************************************************************************************************");
		System.out.println("WITHOUT USING JOIN FETCH");
		System.out.println("********************************************************************************************************");
		Query vehicleAddress2 = entityManager.createQuery("FROM Vehicle");
		List<Vehicle> fetchedVehicleData2 = vehicleAddress2.getResultList();
		System.out.println("Vehicle Details :");
		System.out.println("*****************");
		for(Vehicle data : fetchedVehicleData2) {
			System.out.println(data.getVehicleName());
			Iterator<Address> itr = data.getAddresses().iterator();
			while (itr.hasNext()) {
				Address adr = itr.next();
				System.out.println("City : " + adr.getCity() + " State : " + adr.getState());
			}
			System.out.println("------------------");
		}
		System.out.println("*****************");
		System.out.println("********************************************************************************************************");
		
		System.out.println("********************************************************************************************************");
		System.out.println("USING JOIN FETCH");
		System.out.println("********************************************************************************************************");
		Query vehicleAddress = entityManager.createQuery("FROM Vehicle v JOIN FETCH v.addresses");
		List<Vehicle> fetchedVehicleData = vehicleAddress.getResultList();
		System.out.println("Vehicle Details :");
		System.out.println("*****************");
		for(Vehicle data : fetchedVehicleData) {
			System.out.println(data.getVehicleName());
			Iterator<Address> itr = data.getAddresses().iterator();
			while (itr.hasNext()) {
				Address adr = itr.next();
				System.out.println("City : " + adr.getCity() + " State : " + adr.getState());
			}
			System.out.println("------------------");
		}
		System.out.println("*****************");
		System.out.println("********************************************************************************************************");
		
		//closing the entity manager transaction
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return fetchedData;
	}
	
	public List<Policy> fetchAllPolicies()
	{
		EntityManager entityManager = JpaManager.getEntityManagerFactory().createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Query queryPolicies = entityManager.createNamedQuery("Policy.getAllPolicies");
		List<Policy> fetchedPolicies = queryPolicies.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		
		return fetchedPolicies;
	}
	
	public List<Party> fetchAllParties()
	{
		EntityManager entityManager = JpaManager.getEntityManagerFactory().createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Query queryParties = entityManager.createNamedQuery("Party.getAllParties");
		List<Party> fetchedParties = queryParties.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		
		return fetchedParties;
	}
	
	public List<Vehicle> fetchAllVehicles()
	{
		EntityManager entityManager = JpaManager.getEntityManagerFactory().createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Query queryVehicles = entityManager.createNamedQuery("Vehicle.getAllVehicles");
		List<Vehicle> fetchedVehicles = queryVehicles.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		
		return fetchedVehicles;
	}
	
	public List<Address> fetchAllAddresses()
	{
		EntityManager entityManager = JpaManager.getEntityManagerFactory().createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Query queryAddresses = entityManager.createNamedQuery("Address.getAllAddresses");
		List<Address> fetchedAddresses = queryAddresses.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		
		return fetchedAddresses;
	}
}
