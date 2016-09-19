package main.java.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import main.java.jpamanager.JpaManager;
import main.java.models.Address;
import main.java.models.Vehicle;


public class FetchDataDao {
	
	public List<Object[]> fetchData()
	{
		//create the entity manager
		EntityManager entityManager = JpaManager.getEntityManagerFactory().createEntityManager();
		
		//Begin entity manager transaction
		entityManager.getTransaction().begin();
		
		//Fetching all the data
		Query q = entityManager.createNativeQuery("SELECT policy.policy_name,party.party_name,vehicle.vehicle_name,address.address_name FROM tbl_party party INNER JOIN tbl_policy policy ON party.policy_id = policy.policy_id INNER JOIN tbl_vehicle vehicle ON vehicle.policy_id = policy.policy_id INNER JOIN tbl_address address ON address.vehicle_id = vehicle.vehicle_id");
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
			Iterator<Address> itr = data.getAddress().iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next().getAddressName());
			}
			System.out.println("------------------");
		}
		System.out.println("*****************");
		System.out.println("********************************************************************************************************");
		
		System.out.println("********************************************************************************************************");
		System.out.println("USING JOIN FETCH");
		System.out.println("********************************************************************************************************");
		Query vehicleAddress = entityManager.createQuery("FROM Vehicle v JOIN FETCH v.address");
		List<Vehicle> fetchedVehicleData = vehicleAddress.getResultList();
		System.out.println("Vehicle Details :");
		System.out.println("*****************");
		for(Vehicle data : fetchedVehicleData) {
			System.out.println(data.getVehicleName());
			Iterator<Address> itr = data.getAddress().iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next().getAddressName());
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
}
