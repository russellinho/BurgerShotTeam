package somepackage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import exceptions.AccountTakenException;

@ApplicationScoped
@ManagedBean
public class UserBean {
	private UserController uc = new UserController();
	private boolean loggedIn;
	private boolean admin;
	private String username;
	private String password;
	private ArrayList<OrderBean> orders;
	private ArrayList<OrderBean> allOrders;
	
	private String searchQuery;
	private String selectedUser;
	private ArrayList<OrderBean> ordersForSelectedUser;
	private ArrayList<String> usersFound;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}
	/**
	 * @param loggedIn the loggedIn to set
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}
	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	public String login() {
		UserBean returned = null;
		try {
			returned = uc.login(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (returned == null) {
			FacesMessage message = new FacesMessage("Invalid username and/or password.");
			FacesContext.getCurrentInstance().addMessage("headerform:loginbutton", message);
			loggedIn = false;
			admin = false;
			username = null;
			password = null;
			return null;
		} else {
			loggedIn = returned.isLoggedIn();
			admin = returned.isAdmin();
			username = returned.getUsername();
			password = returned.getPassword();
		}
		return "home";
	}
	
	
	
	public String logout() {
		loggedIn = false;
		admin = false;
		username = null;
		password = null;
		orders = null;
		allOrders = null;
		searchQuery = null;
		usersFound = null;
		return "home";
	}
	/**
	 * @return the orders
	 */
	public ArrayList<OrderBean> getOrders() {
		if (uc == null) uc = new UserController();
		try {
			orders = uc.retrieveOrderHistory(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(ArrayList<OrderBean> orders) {
		this.orders = orders;
	}
	
	public String register() {
		if (uc == null) uc = new UserController();
		FacesMessage message = null;
		try {
			uc.register(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (AccountTakenException e) {
			message = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("registerform:regbutton", message);
			return null;
		}
		message = new FacesMessage("Account successfully registered!");
		FacesContext.getCurrentInstance().addMessage("registerform:regbutton", message);
		return "register";
	}
	/**
	 * @return the allOrders
	 */
	public ArrayList<OrderBean> getAllOrders() {
		if (uc == null) uc = new UserController();
			try {
				allOrders = uc.retrieveAllOrders();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return allOrders;
	}
	/**
	 * @param allOrders the allOrders to set
	 */
	public void setAllOrders(ArrayList<OrderBean> allOrders) {
		this.allOrders = allOrders;
	}
	
	public String updateOrderStatuses() {
		if (uc == null) uc = new UserController();
		try {
			uc.changeOrderStatuses(allOrders);
		} catch (SQLException e) {
			FacesMessage message = new FacesMessage("A database error occurred while updating orders.");
			FacesContext.getCurrentInstance().addMessage("viewAllOrdersForm:processbutton", message);
			e.printStackTrace();
		}
		return "viewAllOrders";
	}
	/**
	 * @return the usersFound
	 */
	public ArrayList<String> getUsersFound() {
		if (uc == null) uc = new UserController();
		try {
			usersFound = uc.findUsers(searchQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersFound;
	}
	/**
	 * @param usersFound the usersFound to set
	 */
	public void setUsersFound(ArrayList<String> usersFound) {
		this.usersFound = usersFound;
	}
	/**
	 * @return the searchQuery
	 */
	public String getSearchQuery() {
		return searchQuery;
	}
	/**
	 * @param searchQuery the searchQuery to set
	 */
	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}
	/**
	 * @return the selectedUser
	 */
	public String getSelectedUser() {
		return selectedUser;
	}
	/**
	 * @param selectedUser the selectedUser to set
	 */
	public void setSelectedUser(String selectedUser) {
		this.selectedUser = selectedUser;
	}
	/**
	 * @return the ordersForSelectedUser
	 */
	public ArrayList<OrderBean> getOrdersForSelectedUser() {
		if (uc == null) uc = new UserController();
		try {
			ordersForSelectedUser = uc.retrieveOrderHistory(selectedUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordersForSelectedUser;
	}
	/**
	 * @param ordersForSelectedUser the ordersForSelectedUser to set
	 */
	public void setOrdersForSelectedUser(ArrayList<OrderBean> ordersForSelectedUser) {
		this.ordersForSelectedUser = ordersForSelectedUser;
	}
	
	public String updateOrderStatusesForSelectedUser() {
		if (uc == null) uc = new UserController();
		try {
			uc.changeOrderStatuses(ordersForSelectedUser);
		} catch (SQLException e) {
			FacesMessage message = new FacesMessage("A database error occurred while updating orders.");
			FacesContext.getCurrentInstance().addMessage("viewDetailsSelectedUser:processbutton", message);
			e.printStackTrace();
		}
		return "viewAccountDetails";
	}
	
	public String proceedToUserPage() {
		FacesContext ctx = FacesContext.getCurrentInstance();
	    Map<String,String> params = ctx.getExternalContext().getRequestParameterMap();
	    selectedUser = params.get("selectedUser");
	    return "viewAccountDetails";
	}
	
}
