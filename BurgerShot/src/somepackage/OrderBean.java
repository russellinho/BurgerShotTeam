package somepackage;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import exceptions.InvalidOrderException;

@ManagedBean
public class OrderBean {
	
	private OrderController oc;
	private UIComponent subbutton;
	@ManagedProperty(value="#{param.username}")
	private String username;
	
	private int orderNumber;
	private int newOrderNumber;
	
	private String timeProcessed;
	
	private String[] orderCategories;
	
	// Meat
	private boolean quarter;
	private boolean half;
	private boolean doublePounder;
	private boolean turkey;
	private boolean chicken;
	private boolean pulledPork;
	
	// Toppings
  private boolean cheese;
  private boolean lettuce;
  private boolean tomato;
  private boolean onion;
  private boolean pickles;
  private boolean carrots;
  
  // Sides
  private boolean fries;
  private boolean onionRings;
  private boolean chickenNuggets;
  private boolean chips;
  private boolean celerySticks;
  
  // Drinks
  private boolean fountainDrink;
  private boolean orangeJuice;
  private boolean appleJuice;
  private boolean cranberryJuice;
  private boolean milk;
  private boolean water;
  
  private boolean stat;
  private String statString;
  
  // Formatted Strings
  private String meatString;
  private String toppingsString;
  private String sidesString;
  private String drinksString;
  
  public String someActionControllerMethod() {
    return("page-b");  // Means to go to page-b.xhtml (since condition is not mapped in faces-config.xml)
  }
  
  public String someOtherActionControllerMethod() {
    return("index");  // Means to go to index.xhtml (since condition is not mapped in faces-config.xml)
  }

/**
 * @return the orderCategories
 */
public String[] getOrderCategories() {
	orderCategories = new String[1];
	orderCategories[0] = "Toppings";
	//orderCategories[1] = "Sides";
	//orderCategories[2] = "Drinks";
	return orderCategories;
}

/**
 * @param orderCategories the orderCategories to set
 */
public void setOrderCategories(String[] orderCategories) {
	this.orderCategories = orderCategories;
}

/**
 * @return the cheese
 */
public boolean isCheese() {
	return cheese;
}

/**
 * @param cheese the cheese to set
 */
public void setCheese(boolean cheese) {
	this.cheese = cheese;
}

/**
 * @return the tomato
 */
public boolean isTomato() {
	return tomato;
}

/**
 * @param tomato the tomato to set
 */
public void setTomato(boolean tomato) {
	this.tomato = tomato;
}

/**
 * @return the lettuce
 */
public boolean isLettuce() {
	return lettuce;
}

/**
 * @param lettuce the lettuce to set
 */
public void setLettuce(boolean lettuce) {
	this.lettuce = lettuce;
}

/**
 * @return the onion
 */
public boolean isOnion() {
	return onion;
}

/**
 * @param onion the onion to set
 */
public void setOnion(boolean onion) {
	this.onion = onion;
}

/**
 * @return the pickles
 */
public boolean isPickles() {
	return pickles;
}

/**
 * @param pickles the pickles to set
 */
public void setPickles(boolean pickles) {
	this.pickles = pickles;
}

/**
 * @return the carrots
 */
public boolean isCarrots() {
	return carrots;
}

/**
 * @param carrots the carrots to set
 */
public void setCarrots(boolean carrots) {
	this.carrots = carrots;
}

/**
 * @return the fries
 */
public boolean isFries() {
	return fries;
}

/**
 * @param fries the fries to set
 */
public void setFries(boolean fries) {
	this.fries = fries;
}

/**
 * @return the onionRings
 */
public boolean isOnionRings() {
	return onionRings;
}

/**
 * @param onionRings the onionRings to set
 */
public void setOnionRings(boolean onionRings) {
	this.onionRings = onionRings;
}

/**
 * @return the chickenNuggets
 */
public boolean isChickenNuggets() {
	return chickenNuggets;
}

/**
 * @param chickenNuggets the chickenNuggets to set
 */
public void setChickenNuggets(boolean chickenNuggets) {
	this.chickenNuggets = chickenNuggets;
}

/**
 * @return the chips
 */
public boolean isChips() {
	return chips;
}

/**
 * @param chips the chips to set
 */
public void setChips(boolean chips) {
	this.chips = chips;
}

/**
 * @return the celerySticks
 */
public boolean isCelerySticks() {
	return celerySticks;
}

/**
 * @param celerySticks the celerySticks to set
 */
public void setCelerySticks(boolean celerySticks) {
	this.celerySticks = celerySticks;
}

/**
 * @return the fountainDrink
 */
public boolean isFountainDrink() {
	return fountainDrink;
}

/**
 * @param fountainDrink the fountainDrink to set
 */
public void setFountainDrink(boolean fountainDrink) {
	this.fountainDrink = fountainDrink;
}

/**
 * @return the orangeJuice
 */
public boolean isOrangeJuice() {
	return orangeJuice;
}

/**
 * @param orangeJuice the orangeJuice to set
 */
public void setOrangeJuice(boolean orangeJuice) {
	this.orangeJuice = orangeJuice;
}

/**
 * @return the appleJuice
 */
public boolean isAppleJuice() {
	return appleJuice;
}

/**
 * @param appleJuice the appleJuice to set
 */
public void setAppleJuice(boolean appleJuice) {
	this.appleJuice = appleJuice;
}

/**
 * @return the cranberryJuice
 */
public boolean isCranberryJuice() {
	return cranberryJuice;
}

/**
 * @param cranberryJuice the cranberryJuice to set
 */
public void setCranberryJuice(boolean cranberryJuice) {
	this.cranberryJuice = cranberryJuice;
}

/**
 * @return the milk
 */
public boolean isMilk() {
	return milk;
}

/**
 * @param milk the milk to set
 */
public void setMilk(boolean milk) {
	this.milk = milk;
}

/**
 * @return the water
 */
public boolean isWater() {
	return water;
}

/**
 * @param water the water to set
 */
public void setWater(boolean water) {
	this.water = water;
}

/**
 * @return the quarter
 */
public boolean isQuarter() {
	return quarter;
}

/**
 * @param quarter the quarter to set
 */
public void setQuarter(boolean quarter) {
	this.quarter = quarter;
}

/**
 * @return the half
 */
public boolean isHalf() {
	return half;
}

/**
 * @param half the half to set
 */
public void setHalf(boolean half) {
	this.half = half;
}

/**
 * @return the doublePounder
 */
public boolean isDoublePounder() {
	return doublePounder;
}

/**
 * @param doublePounder the doublePounder to set
 */
public void setDoublePounder(boolean doublePounder) {
	this.doublePounder = doublePounder;
}

/**
 * @return the turkey
 */
public boolean isTurkey() {
	return turkey;
}

/**
 * @param turkey the turkey to set
 */
public void setTurkey(boolean turkey) {
	this.turkey = turkey;
}

/**
 * @return the chicken
 */
public boolean isChicken() {
	return chicken;
}

/**
 * @param chicken the chicken to set
 */
public void setChicken(boolean chicken) {
	this.chicken = chicken;
}

/**
 * @return the pulledPork
 */
public boolean isPulledPork() {
	return pulledPork;
}

/**
 * @param pulledPork the pulledPork to set
 */
public void setPulledPork(boolean pulledPork) {
	this.pulledPork = pulledPork;
}

/**
 * @return the orderNumber
 */
public int getOrderNumber() {
	return orderNumber;
}

/**
 * @param orderNumber the orderNumber to set
 */
public void setOrderNumber(int orderNumber) {
	this.orderNumber = orderNumber;
}

/**
 * @return the oc
 */
public OrderController getOc() {
	if (oc == null) oc = new OrderController();
	return oc;
}

/**
 * @param oc the oc to set
 */
public void setOc(OrderController oc) {
	this.oc = oc;
}

public String placeOrder() {
	if (oc == null) oc = new OrderController();
	try {
		oc.verifyOrder(quarter, half, doublePounder, turkey, chicken, pulledPork, cheese, lettuce, tomato, onion, pickles, carrots, fries, onionRings, chickenNuggets, chips, celerySticks, fountainDrink, orangeJuice, appleJuice, cranberryJuice, milk, water);
	} catch (InvalidOrderException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		FacesMessage message = new FacesMessage(e.getMessage());
		FacesContext.getCurrentInstance().addMessage("mainform:subbutton", message);
		//context.addMessage(subbutton.getClientId(context), message);
		return null;
	}
	oc.createOrder(username, quarter, half, doublePounder, turkey, chicken, pulledPork, cheese, lettuce, tomato, onion, pickles, carrots, fries, onionRings, chickenNuggets, chips, celerySticks, fountainDrink, orangeJuice, appleJuice, cranberryJuice, milk, water);
	return "page-b";
}

/**
 * @return the subbutton
 */
public UIComponent getSubbutton() {
	return subbutton;
}

/**
 * @param subbutton the subbutton to set
 */
public void setSubbutton(UIComponent subbutton) {
	this.subbutton = subbutton;
}

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
 * @return the meatString
 */
public String getMeatString() {
	if (quarter) meatString = "Quarter-Pounder";
	if (half) meatString = "Half-Pounder";
	if (doublePounder) meatString = "Double-Pounder";
	if (turkey) meatString = "Turkey";
	if (chicken) meatString = "Chicken";
	if (pulledPork) meatString = "Pulled Pork";
	return meatString;
}

/**
 * @param meatString the meatString to set
 */
public void setMeatString(String meatString) {
	this.meatString = meatString;
}

/**
 * @return the toppingsString
 */
public String getToppingsString() {
	toppingsString = "";
	if (cheese) toppingsString += "Cheese, ";
	if (lettuce) toppingsString += "Lettuce, ";
	if (tomato) toppingsString += "Tomato, ";
	if (toppingsString.length() >= 20) toppingsString += "\n";
	if (onion) toppingsString += "Onion, ";
	if (pickles) toppingsString += "Pickles, ";
	if (carrots) toppingsString += "Carrots, ";
	if (toppingsString.length() > 0) {
		int subAmount = 2;
		if (toppingsString.charAt(toppingsString.length() - 1) == '\n') subAmount = 3;
		toppingsString = toppingsString.substring(0, toppingsString.length() - subAmount);
	}
	return toppingsString;
}

/**
 * @param toppingsString the toppingsString to set
 */
public void setToppingsString(String toppingsString) {
	this.toppingsString = toppingsString;
}

/**
 * @return the sidesString
 */
public String getSidesString() {
	sidesString = "";
	if (fries) sidesString += "Fries, ";
	if (onionRings) sidesString += "Onion Rings, ";
	if (sidesString.length() >= 20) sidesString += "\n";
	if (chickenNuggets) sidesString += "Chicken Nuggets, ";
	if (chips) sidesString += "Chips, ";
	if (sidesString.length() >= 20) sidesString += "\n";
	if (celerySticks) sidesString += "Celery Sticks, ";
	if (sidesString.length() > 0) {
		int subAmount = 2;
		if (sidesString.charAt(sidesString.length() - 1) == '\n') subAmount = 3;
		sidesString = sidesString.substring(0, sidesString.length() - subAmount);
	}
	return sidesString;
}

/**
 * @param sidesString the sidesString to set
 */
public void setSidesString(String sidesString) {
	this.sidesString = sidesString;
}

/**
 * @return the drinksString
 */
public String getDrinksString() {
	drinksString = "None";
	if (fountainDrink) drinksString = "Soda";
	if (orangeJuice) drinksString = "Orange Juice";
	if (appleJuice) drinksString = "Apple Juice";
	if (cranberryJuice) drinksString = "Cranberry Juice";
	if (milk) drinksString = "Milk";
	if (water) drinksString = "Water";
	return drinksString;
}

/**
 * @param drinksString the drinksString to set
 */
public void setDrinksString(String drinksString) {
	this.drinksString = drinksString;
}

/**
 * @return the newOrderNumber
 */
public int getNewOrderNumber() {
	if (oc == null) oc = new OrderController();
	newOrderNumber = oc.getOrderNumber() - 1;
	return newOrderNumber;
}

/**
 * @param newOrderNumber the newOrderNumber to set
 */
public void setNewOrderNumber(int newOrderNumber) {
	this.newOrderNumber = newOrderNumber;
}

/**
 * @return the stat
 */
public boolean isStat() {
	return stat;
}

/**
 * @param stat the stat to set
 */
public void setStat(boolean stat) {
	this.stat = stat;
}

/**
 * @return the statString
 */
public String getStatString() {
	if (stat) statString = "Processed";
	else statString = "Pending";
	return statString;
}

public String getStatStringRaw() {
	return statString;
}

/**
 * @param statString the statString to set
 */
public void setStatString(String statString) {
	this.statString = statString;
}

/**
 * @return the timeProcessed
 */
public String getTimeProcessed() {
	return timeProcessed;
}

/**
 * @param timeProcessed the timeProcessed to set
 */
public void setTimeProcessed(String timeProcessed) {
	this.timeProcessed = timeProcessed;
}

}
