package pageUINopcomerce;

public class CommonPageUI {
	public static final String MYPRODUCT_REVIEW_LINK = "//div[@class='listbox']//a[text()='My product reviews']";
	public static final String ADDRESSES_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	public static final String ORDER_LINK = "//div[@class='listbox']//a[text()='Orders']";
	public static final String CUSTOMERINFOR_LINK = "//div[@class='listbox']//a[text()='Customer info']";
	
	public static final String DYNAMIC_LINK = "//div[@class='listbox']//a[text()='%s']";
	public static final String LOADING_ICON = "//div[@id='ajaxBusy' and contains(@style,'block')]";
	public static final String UPLOAD_FILE_TYPE_BY_PANEL = "//div[@id='%s']//input[@type='file']";
	
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_CLASS = "//button[@class='%s']";
	public static final String REGISTER_MESSAGE_SUCCESS = "//div[@class='result']";
	
	public static final String DYNAMIC_FOOTER_LINK_BY_CLASS = "//a[@class='%s']";
}
