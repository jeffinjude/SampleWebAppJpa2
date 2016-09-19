package main.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import main.java.jpamanager.JpaManager;


public class FetchDataDao {
	
	public List<Object[]> fetchData()
	{
		//create the entity manager
		EntityManager entityManager = JpaManager.getEntityManagerFactory().createEntityManager();
		
		//Begin entity manager transaction
		entityManager.getTransaction().begin();
		
		Query q = entityManager.createNativeQuery("SELECT policy.policy_name,party.party_name,vehicle.vehicle_name,address.address_name FROM tbl_party party INNER JOIN tbl_policy policy ON party.policy_id = policy.policy_id INNER JOIN tbl_policy_vehicle policy_vehicle ON policy_vehicle.policy_id =  policy.policy_id INNER JOIN tbl_vehicle vehicle ON vehicle.vehicle_id = policy_vehicle.vehicle_id INNER JOIN tbl_vehicle_address vehicle_address ON vehicle_address.vehicle_id = vehicle.vehicle_id INNER JOIN tbl_address address ON address.address_id = vehicle_address.address_id");
		List<Object[]> fetchedData = q.getResultList();
		
		//closing the entity manager transaction
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return fetchedData;
	}
}
