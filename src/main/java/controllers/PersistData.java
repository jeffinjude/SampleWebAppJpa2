package main.java.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dao.FetchDataDao;
import main.java.dao.PersistDataDao;
import main.java.models.Address;
import main.java.models.Party;
import main.java.models.Policy;
import main.java.models.Vehicle;

/**
 * Servlet implementation class PersisitData
 */
@WebServlet(description = "JPA Demo Servlet", urlPatterns = { "/PersistData" })
public class PersistData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersistData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Insert the data
		PersistDataDao persistDataDao = new PersistDataDao();
		persistDataDao.insertData();
		
		//Fetch the data
		FetchDataDao fetchDataDao = new FetchDataDao();
		List<Object[]> fetchedData = fetchDataDao.fetchData();
		List<Policy> fetchedPolicies = fetchDataDao.fetchAllPolicies();
		List<Party> fetchedParties = fetchDataDao.fetchAllParties();
		List<Vehicle> fetchedVehicles = fetchDataDao.fetchAllVehicles();
		List<Address> fetchedAddresses = fetchDataDao.fetchAllAddresses();
		
		//Set the fetched data into the request object
		request.setAttribute("fetchedData", fetchedData);
		request.setAttribute("fetchedPolicies", fetchedPolicies);
		request.setAttribute("fetchedParties", fetchedParties);
		request.setAttribute("fetchedVehicles", fetchedVehicles);
		request.setAttribute("fetchedAddresses", fetchedAddresses);
		
		//Forward to the view page
		RequestDispatcher view = request.getRequestDispatcher("DisplayData.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
