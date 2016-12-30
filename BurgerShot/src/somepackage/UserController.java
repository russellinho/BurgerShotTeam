package somepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import exceptions.AccountTakenException;

public class UserController {
	
	public UserController() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<OrderBean> retrieveOrderHistory(String username) throws SQLException {
		ArrayList<OrderBean> toReturn = new ArrayList<OrderBean>();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgershot", "root", "");
		PreparedStatement stmnt = con.prepareStatement("SELECT * FROM orders WHERE username=\"" + username + "\"");
		ResultSet rs = stmnt.executeQuery();
		while (rs.next()) {
			OrderBean temp = new OrderBean();
			temp.setUsername(username);
			temp.setOrderNumber(rs.getInt(2));
			temp.setQuarter(rs.getBoolean(3));
			temp.setHalf(rs.getBoolean(4));
			temp.setDoublePounder(rs.getBoolean(5));
			temp.setTurkey(rs.getBoolean(6));
			temp.setChicken(rs.getBoolean(7));
			temp.setPulledPork(rs.getBoolean(8));
			temp.setCheese(rs.getBoolean(9));
			temp.setLettuce(rs.getBoolean(10));
			temp.setTomato(rs.getBoolean(11));
			temp.setOnion(rs.getBoolean(12));
			temp.setPickles(rs.getBoolean(13));
			temp.setCarrots(rs.getBoolean(14));
			temp.setFries(rs.getBoolean(15));
			temp.setOnionRings(rs.getBoolean(16));
			temp.setChickenNuggets(rs.getBoolean(17));
			temp.setChips(rs.getBoolean(18));
			temp.setCelerySticks(rs.getBoolean(19));
			temp.setFountainDrink(rs.getBoolean(20));
			temp.setOrangeJuice(rs.getBoolean(21));
			temp.setAppleJuice(rs.getBoolean(22));
			temp.setCranberryJuice(rs.getBoolean(23));
			temp.setMilk(rs.getBoolean(24));
			temp.setWater(rs.getBoolean(25));
			temp.setStat(rs.getBoolean(26));
			temp.setTimeProcessed(rs.getString(27));
			toReturn.add(temp);
		}
		return toReturn;
	}
	
	public ArrayList<OrderBean> retrieveAllOrders() throws SQLException {
		ArrayList<OrderBean> toReturn = new ArrayList<OrderBean>();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgershot", "root", "");
		PreparedStatement stmnt = con.prepareStatement("SELECT * FROM orders");
		ResultSet rs = stmnt.executeQuery();
		while (rs.next()) {
			OrderBean temp = new OrderBean();
			temp.setUsername(rs.getString(1));
			temp.setOrderNumber(rs.getInt(2));
			temp.setQuarter(rs.getBoolean(3));
			temp.setHalf(rs.getBoolean(4));
			temp.setDoublePounder(rs.getBoolean(5));
			temp.setTurkey(rs.getBoolean(6));
			temp.setChicken(rs.getBoolean(7));
			temp.setPulledPork(rs.getBoolean(8));
			temp.setCheese(rs.getBoolean(9));
			temp.setLettuce(rs.getBoolean(10));
			temp.setTomato(rs.getBoolean(11));
			temp.setOnion(rs.getBoolean(12));
			temp.setPickles(rs.getBoolean(13));
			temp.setCarrots(rs.getBoolean(14));
			temp.setFries(rs.getBoolean(15));
			temp.setOnionRings(rs.getBoolean(16));
			temp.setChickenNuggets(rs.getBoolean(17));
			temp.setChips(rs.getBoolean(18));
			temp.setCelerySticks(rs.getBoolean(19));
			temp.setFountainDrink(rs.getBoolean(20));
			temp.setOrangeJuice(rs.getBoolean(21));
			temp.setAppleJuice(rs.getBoolean(22));
			temp.setCranberryJuice(rs.getBoolean(23));
			temp.setMilk(rs.getBoolean(24));
			temp.setWater(rs.getBoolean(25));
			temp.setStat(rs.getBoolean(26));
			temp.setTimeProcessed(rs.getString(27));
			toReturn.add(temp);
		}
		return toReturn;
	}
	
	public UserBean login(String username, String password) throws SQLException {
		UserBean toReturn = null;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgershot", "root", "");
			PreparedStatement stmnt = con.prepareStatement("SELECT * FROM users");
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				String tempuser = rs.getString(1);
				String temppass = rs.getString(2);
				if (tempuser.equals(username) && temppass.equals(password)) {
					toReturn = new UserBean();
					toReturn.setUsername(tempuser);
					toReturn.setPassword(temppass);
					toReturn.setAdmin(rs.getBoolean(3));
					toReturn.setLoggedIn(true);
					break;
				}
			}
		return toReturn;
	}
	
	public void register(String username, String password) throws SQLException, AccountTakenException {
		if (username.equals("admin") || username.equals("guest")) throw new AccountTakenException("This username is restricted.");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgershot", "root", "");
		PreparedStatement stmnt = con.prepareStatement("SELECT * FROM users WHERE username=\"" + username + "\"");
		ResultSet rs = stmnt.executeQuery();
		if (rs.next()) {
			throw new AccountTakenException("This username is already taken!");
		} else {
			stmnt = con.prepareStatement("INSERT INTO users VALUES (\"" + username + "\", \"" + password + "\", false);");
			stmnt.executeUpdate();
		}
	}
	
	public void changeOrderStatus(int orderNo, boolean newStatus) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgershot", "root", "");
		PreparedStatement stmnt = null;
		if (newStatus) {
			LocalDateTime temp = LocalDateTime.now();
			String minute = "" + temp.getMinute();
			if (temp.getMinute() < 10) minute = "0" + minute;
			String time = temp.getMonthValue() + "/" + temp.getDayOfMonth() + "/" + temp.getYear() + " " + temp.getHour() + ":" + minute;
			stmnt = con.prepareStatement("UPDATE orders SET stat=" + newStatus + ", dateProcessed=\"" + time + "\"" + " WHERE orderNo=" + orderNo);
		} else {
			stmnt = con.prepareStatement("UPDATE orders SET stat=" + newStatus + ", dateProcessed=null WHERE orderNo=" + orderNo);
		}
		stmnt.executeUpdate();
	}
	
	public void changeOrderStatuses(ArrayList<OrderBean> orders) throws SQLException {
		for (int i = 0; i < orders.size(); i++) {
			OrderBean temp = orders.get(i);
			String newStatString = temp.getStatStringRaw();
			boolean newStatBool = false;
			if (newStatString.equals("Processed")) {
				newStatBool = true;
			} else {
				newStatBool = false;
			}
			if (newStatBool != temp.isStat()) changeOrderStatus(temp.getOrderNumber(), newStatBool);
		}
	}
	
	public ArrayList<String> findUsers(String username) throws SQLException {
		ArrayList<String> toReturn = new ArrayList<String>();
		if (username != null && username.equals("")) return toReturn;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgershot", "root", "");
		PreparedStatement stmnt = con.prepareStatement("SELECT * FROM users WHERE username LIKE \"" + username + "%\"");
		ResultSet rs = stmnt.executeQuery();
		while (rs.next()) {
			toReturn.add(rs.getString(1));
		}
		return toReturn;
	}
	
}
