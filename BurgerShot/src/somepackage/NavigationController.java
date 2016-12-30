package somepackage;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class NavigationController {
	
	public String goToIndex() {
		return "index";
	}
	
	public String goToPageB() {
		return "page-b";
	}
	
	public String goHome() {
		return "home";
	}
	
	public String goToAboutUs() {
		return "about";
	}
	
	public String goToOrderHistory() {
		return "orderHistory";
	}
	
	public String goToLogin() {
		return "login";
	}
	
	public String goToRegister() {
		return "register";
	}
	
	public String goToViewAllOrders() {
		return "viewAllOrders";
	}
	
	public String goToAccountDirectory() {
		return "accountDirectory";
	}
	
	public String goToAccountDetails() {
		return "viewAccountDetails";
	}
}
