package pageOpjectsNopcomerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManage {
	public static UserLoginPO getLoginPageOject(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	
	public static UserHomePO getHomePageOjectt(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserRegisterPO getUserRegisterPageObject(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	
	public static UserCustomerInforPO getUserCustomerInforPageObject(WebDriver driver) {
		return new UserCustomerInforPO(driver);
	}
	
	public static UserAddressesPO getUserAddressesPageObject(WebDriver driver) {
		return new UserAddressesPO(driver);
	}
	
	public static UserMyProductReviewPO getUserMyProductReviewPageObject(WebDriver driver) {
		return new UserMyProductReviewPO(driver);
	}
	
	public static UserOrdersPO getUserOrdersPageObject(WebDriver driver) {
		return new UserOrdersPO(driver);
	}
	
	public static CommonPageObject getCommonPageObject(WebDriver driver) {
		return new CommonPageObject(driver);
	}
	
}
