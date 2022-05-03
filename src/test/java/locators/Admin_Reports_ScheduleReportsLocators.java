package locators;

public class Admin_Reports_ScheduleReportsLocators {
	public static final String titleOfPage = "//div[@class='topBarTitle']";
	public static final String refreshButton = "//div/button[@class='topBarButton' and @title='Refresh Data']";
	public static final String exportButton = "//button[@class='topBarButton']/i[@class='fas fa-file-export']";
	public static final String headerForSort = "//*[@class='k-column-title' and text()='@override']";
	public static final String exportIcon="//a[@title='Export' and contains(@class, 'menu-link')]";
	public static final String closeExportPopup = "//button[text()='Close']";
	public static final String editScheduleReports = "//td[text()='@override']/following-sibling::td/button[text()='Edit']";
	public static final String deleteScheduleReports = "//td[text()='@override']/following-sibling::td/button[text()='Delete']";

}
