package commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageOpjectsNopcomerce.PageGeneratorManage;
import pageOpjectsNopcomerce.UserAddressesPO;
import pageOpjectsNopcomerce.UserCustomerInforPO;
import pageOpjectsNopcomerce.UserMyProductReviewPO;
import pageOpjectsNopcomerce.UserOrdersPO;
import pageUINopcomerce.CommonPageUI;

public class AbtractPage {
	WebDriver driver;

	public void openPageURL(WebDriver driver, String URL) {
		driver.get(URL);
	}

	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void fowardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refeshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void setTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void swithToWindowHandleByID(WebDriver driver, String parentID) {
		Set<String> allWindow = driver.getWindowHandles();

		for (String runWindow : allWindow) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void swithToWindowHandleByTitle(WebDriver driver, String title) {
		Set<String> allWindow = driver.getWindowHandles();

		for (String runWindow : allWindow) {
			driver.switchTo().window(runWindow);
			String curentWin = driver.getTitle();
			if (curentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWindowWithoutWindowParent(WebDriver driver, String parentID) {
		Set<String> allWindow = driver.getWindowHandles();

		for (String runWindow : allWindow) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}

		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1) {
			return true;
		} else
			return false;
	}

	public WebElement getElement(WebDriver driver, String Locator) {
		return driver.findElement(By.xpath(Locator));
	}

	public List<WebElement> getElements(WebDriver driver, String Locator) {
		return driver.findElements(By.xpath(Locator));
	}

	public By getByxpath(String Locator) {
		return By.xpath(Locator);
	}

	public void clickToElement(WebDriver driver, String Locator) {
		hightlightElement( driver, Locator);
		element = getElement(driver, Locator);
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			clickToElementByJS(driver, Locator);
			sleepInSecond(3);
		} else {
			element.click();
		}
	}

	public void clickToElement(WebDriver driver, String Locator, String... values) {
		hightlightElement( driver, getDynamicLocator(Locator, values));
		element = getElement(driver, getDynamicLocator(Locator, values));
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			clickToElementByJS(driver, Locator, values);
			;
			sleepInSecond(3);
		} else {
			element.click();
		}
	}

	public void senKeysToElement(WebDriver driver, String Locator, String value) {
		hightlightElement( driver, Locator);
		element = getElement(driver, Locator);
		element.clear();
		element.sendKeys(value);
	}

	public void senKeysToElement(WebDriver driver, String Locator, String value, String... values) {
		hightlightElement( driver, getDynamicLocator(Locator, values));
		element = getElement(driver, getDynamicLocator(Locator, values));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String Locator, String itemValue) {
		WebElement element = getElement(driver, Locator);
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	public void selectItemInDropdown(WebDriver driver, String Locator, String itemValue, String... values) {
		WebElement element = getElement(driver, getDynamicLocator(Locator, values));
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	public String getFirstSelectedTextInDropdown(WebDriver driver, String Locator) {
		element = getElement(driver, Locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void selectCustomerItemInDropdown(WebDriver driver, String parentLocator, String itemLocator, String expectedItem) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		getElement(driver, parentLocator).click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByxpath(itemLocator)));

		List<WebElement> allItem = driver.findElements(getByxpath(itemLocator));
		System.out.println("Item size: " + allItem.size());

		for (WebElement item : allItem) {
			String acctualItem = item.getText();
			if (acctualItem.equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				explicitWait.until(ExpectedConditions.elementToBeClickable(item));
				item.click();
				break;
			}
		}
	}

	public String getElementAttribute(WebDriver driver, String Locator, String attributeName) {
		element = getElement(driver, Locator);
		return element.getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String Locator, String attributeName, String... values) {
		element = getElement(driver, getDynamicLocator(Locator, values));
		return element.getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String Locator, String... values) {
		hightlightElement( driver, getDynamicLocator(Locator, values));
		element = getElement(driver, getDynamicLocator(Locator, values));
		return element.getText();
	}

	public String getElementText(WebDriver driver, String Locator) {
		hightlightElement( driver, Locator);
		element = getElement(driver, Locator);
		return element.getText();
	}

	public int countElementSize(WebDriver driver, String Locator) {
		return getElements(driver, Locator).size();
	}

	public int countElementSize(WebDriver driver, String Locator, String... values) {
		return getElements(driver, getDynamicLocator(Locator, values)).size();
	}

	public void checkToCheckBox(WebDriver driver, String Locator) {
		hightlightElement( driver, Locator);
		element = getElement(driver, Locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToCheckBox(WebDriver driver, String Locator, String... values) {
		hightlightElement( driver, getDynamicLocator(Locator, values));
		element = getElement(driver, getDynamicLocator(Locator, values));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToCheckBox(WebDriver driver, String Locator) {
		hightlightElement( driver, Locator);
		element = getElement(driver, Locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String Locator) {
		return getElement(driver, Locator).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String Locator, String... values) {
		return getElement(driver, getDynamicLocator(Locator, values)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String Locator) {
		return getElement(driver, Locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String Locator) {
		return getElement(driver, Locator).isSelected();
	}

	public void swithToFrame(WebDriver driver, String Locator) {
		driver.switchTo().frame(getElement(driver, Locator));
	}

	public void swithToDefaultContent(WebDriver driver, String Locator) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String Locator) {
		hightlightElement( driver, Locator);
		actions = new Actions(driver);
		actions.doubleClick(getElement(driver, Locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String Locator) {
		hightlightElement( driver, Locator);
		actions = new Actions(driver);
		actions.contextClick(getElement(driver, Locator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String Locator) {
		actions = new Actions(driver);
		actions.moveToElement(getElement(driver, Locator)).perform();
	}

	public void clickAndHoldToElement(WebDriver driver, String Locator) {
		actions = new Actions(driver);
		actions.clickAndHold(getElement(driver, Locator)).perform();
	}

	public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		actions = new Actions(driver);
		actions.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void senKeyBoardToElement(WebDriver driver, String Locator, Keys key) {
		element = getElement(driver, Locator);
		actions = new Actions(driver);
		actions.sendKeys(element, key).perform();
	}

	public Object executeForBroswer(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	public void navigateToURLByJS(WebDriver driver, String URL) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + URL + "'");
	}

	public void hightlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void clickToElementByJS(WebDriver driver, String locator, String... values) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, getDynamicLocator(locator, values)));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean isImageLoad(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		Boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitToElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByxpath(locator)));
	}

	public void waitAllToElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByxpath(locator)));
	}

	public void waitAllToElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByxpath(getDynamicLocator(locator, values))));
	}

	public void waitToElementInVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.SHORT_TIMEOUT);
		OverideImplicitWait(driver, GlobalConstans.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByxpath(locator)));
		OverideImplicitWait(driver, GlobalConstans.LONG_TIMEOUT);
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		OverideImplicitWait(driver, GlobalConstans.SHORT_TIMEOUT);
		elements = getElements(driver, locator);
		OverideImplicitWait(driver, GlobalConstans.LONG_TIMEOUT);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	private void OverideImplicitWait(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public void waitToElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByxpath(getDynamicLocator(locator, values))));
	}

	public void waitToElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByxpath(locator)));
	}

	public void waitToElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByxpath(getDynamicLocator(locator, values))));
	}

	public String getDynamicLocator(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	public UserAddressesPO clickToAddressesPage(WebDriver driver) {
		waitToElementClickable(driver, CommonPageUI.ADDRESSES_LINK);
		clickToElement(driver, CommonPageUI.ADDRESSES_LINK);
		return PageGeneratorManage.getUserAddressesPageObject(driver);
	}

	public UserMyProductReviewPO clickToMyProductReviewPage(WebDriver driver) {
		waitToElementClickable(driver, CommonPageUI.MYPRODUCT_REVIEW_LINK);
		clickToElement(driver, CommonPageUI.MYPRODUCT_REVIEW_LINK);
		return PageGeneratorManage.getUserMyProductReviewPageObject(driver);
	}

	public UserOrdersPO clickToOrdersPage(WebDriver driver) {
		waitToElementClickable(driver, CommonPageUI.ORDER_LINK);
		clickToElement(driver, CommonPageUI.ORDER_LINK);
		return PageGeneratorManage.getUserOrdersPageObject(driver);
	}

	public UserCustomerInforPO clickToCustomerInforPage(WebDriver driver) {
		waitToElementClickable(driver, CommonPageUI.CUSTOMERINFOR_LINK);
		clickToElement(driver, CommonPageUI.CUSTOMERINFOR_LINK);
		return PageGeneratorManage.getUserCustomerInforPageObject(driver);
	}

	public AbtractPage openLinkByPageName(WebDriver driver, String pageName) {
		waitToElementClickable(driver, CommonPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, CommonPageUI.DYNAMIC_LINK, pageName);

		switch (pageName) {
		case "Addresses": {
			return PageGeneratorManage.getUserAddressesPageObject(driver);
		}
		case "My product reviews": {
			return PageGeneratorManage.getUserMyProductReviewPageObject(driver);
		}
		case "Orders": {
			return PageGeneratorManage.getUserOrdersPageObject(driver);
		}
		default:
			return PageGeneratorManage.getUserCustomerInforPageObject(driver);
		}
	}

	public void openLinkWithPageName(WebDriver driver, String pageName) {
		waitToElementClickable(driver, CommonPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, CommonPageUI.DYNAMIC_LINK, pageName);
	}

	public void waitAjaxLoadingInvisible(WebDriver driver) {
		waitToElementVisible(driver, CommonPageUI.LOADING_ICON);
	}

	public void uploadFileByPanelID(WebDriver driver, String panelID, String... fileNames) {
		String filePath = GlobalConstans.UPLOAD_FOLDER;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, getDynamicLocator(CommonPageUI.UPLOAD_FILE_TYPE_BY_PANEL, panelID)).sendKeys(fullFileName);
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void sleepInMiliSecond(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	

	public boolean isDataStringSortedAscending(WebDriver driver, String locator) {
		ArrayList<String> arrayList = new ArrayList<>();

		List<WebElement> elementList = getElements(driver, locator);

		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}
		System.out.println("----------Dữ liệu trên UI:--------");
		for (String name : arrayList) {
			System.out.println(name);
		}

		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		Collections.sort(sortedList);

		System.out.println("--------------------Dữ liệu đã SORT ASC trong code:---------");
		for (String name : sortedList) {
			System.out.println(name);
		}
		return sortedList.equals(arrayList);
	}

	public boolean isDataStringSortedDescending(WebDriver driver, String locator) {
		ArrayList<String> arrayList = new ArrayList<>();

		List<WebElement> elementList = getElements(driver, locator);

		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}
		System.out.println("----------Dữ liệu trên UI:--------");
		for (String name : arrayList) {
			System.out.println(name);
		}

		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		Collections.sort(sortedList);

		System.out.println("--------------------Dữ liệu đã SORT ASC trong code:---------");
		for (String name : sortedList) {
			System.out.println(name);
		}

		Collections.reverse(sortedList);

		System.out.println("--------------------Dữ liệu đã SORT DESC trong code:---------");
		for (String name : sortedList) {
			System.out.println(name);
		}
		return sortedList.equals(arrayList);
	}

	public boolean isDataFloatSortedDescending(WebDriver driver, String locator) {
		ArrayList<Float> arrayList = new ArrayList<Float>();

		List<WebElement> elementList = getElements(driver, locator);

		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		System.out.println("----------Dữ liệu trên UI:--------");
		for (Float name : arrayList) {
			System.out.println(name);
		}

		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}

		Collections.sort(sortedList);

		System.out.println("--------------------Dữ liệu đã SORT ASC trong code:---------");
		for (Float name : sortedList) {
			System.out.println(name);
		}

		Collections.reverse(sortedList);

		System.out.println("--------------------Dữ liệu đã SORT DESC trong code:---------");
		for (Float name : sortedList) {
			System.out.println(name);
		}

		return sortedList.equals(arrayList);
	}

	public boolean isDataFloatSortedAscending(WebDriver driver, String locator) {
		ArrayList<Float> arrayList = new ArrayList<Float>();

		List<WebElement> elementList = getElements(driver, locator);

		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		System.out.println("----------Dữ liệu trên UI:--------");
		for (Float name : arrayList) {
			System.out.println(name);
		}

		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}

		Collections.sort(sortedList);

		System.out.println("--------------------Dữ liệu đã SORT ASC trong code:---------");
		for (Float name : sortedList) {
			System.out.println(name);
		}

		return sortedList.equals(arrayList);
	}

	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private WebElement element;
	private List<WebElement> elements;
	private Actions actions;
	private Select select;

}
