package somepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.InvalidOrderException;

public class OrderController {
	
	public OrderController() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getOrderNumber() {
		int toReturn = 0;
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgershot", "root", "");
			PreparedStatement stmnt = con.prepareStatement("SELECT * FROM orders;");
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				toReturn++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toReturn;
	}
	
	public void createOrder(String username, boolean quarter, boolean half, boolean doublePounder, 
			boolean turkey, boolean chicken, boolean pulledPork, 
			boolean cheese, boolean lettuce, boolean tomato, boolean onion, 
			boolean pickles, boolean carrots, boolean fries, boolean onionRings, 
			boolean chickenNuggets, boolean chips, boolean celerySticks, boolean fountainDrink, 
			boolean orangeJuice, boolean appleJuice, boolean cranberryJuice, boolean milk, boolean water) {
		try {
			int orderID = getOrderNumber();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgershot", "root", "");
			PreparedStatement stmnt = con.prepareStatement("INSERT INTO orders VALUES (\"" + username + "\"" + "," + orderID + "," + quarter + "," + half + "," + doublePounder + "," + turkey + "," + chicken + "," + pulledPork 
					+ "," + cheese + "," + lettuce + "," + tomato + "," + onion + "," + pickles + "," + carrots + "," + fries 
					+ "," + onionRings + "," + chickenNuggets + "," + chips + "," + celerySticks + "," + fountainDrink + "," + orangeJuice 
					+ "," + appleJuice + "," + cranberryJuice + "," + milk + "," + water + ", false, null);");
			stmnt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void verifyOrder(boolean quarter, boolean half, boolean doublePounder, 
			boolean turkey, boolean chicken, boolean pulledPork, 
			boolean cheese, boolean lettuce, boolean tomato, boolean onion, 
			boolean pickles, boolean carrots, boolean fries, boolean onionRings, 
			boolean chickenNuggets, boolean chips, boolean celerySticks, boolean fountainDrink, 
			boolean orangeJuice, boolean appleJuice, boolean cranberryJuice, boolean milk, boolean water) throws InvalidOrderException {
		// Only allow one burger
		int count = 0;
		if (quarter) count++;
		if (half) count++;
		if (doublePounder) count++;
		if (turkey) count++;
		if (chicken) count++;
		if (pulledPork) count++;
		if (count != 1) {
			throw new InvalidOrderException("The combo only allows one type of meat.");
		}
		// Only allow 1 type of drink
		count = 0;
		if (fountainDrink) count++;
		if (orangeJuice) count++;
		if (appleJuice) count++;
		if (cranberryJuice) count++;
		if (milk) count++;
		if (water) count++;
		if (count > 1) {
			throw new InvalidOrderException("The combo only allows one drink.");
		}
	}
	
}
