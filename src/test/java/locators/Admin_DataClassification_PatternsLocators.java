package locators;

public class Admin_DataClassification_PatternsLocators {
	public static final String pageHeaderName = "//div[@class='topBar']/child::div[text()='Patterns']";
	public static final String setInitPageBtn = "//button[@title='Set this view as init page']";
	public static final String createBtn = "//button[text()='Create']";
	public static final String dropDownField = "//label[text()='@override']/following-sibling::div//span[@class='k-input-value-text']";
	public static final String dropDownOption = "//span[@class='k-list-item-text' and text()='@override']";
	public static final String nameField = "//label[text()='Name']/following-sibling::div/input";
	public static final String addLabelIcon = "//label[text()='Labels']//following-sibling::div/button";
	public static final String labelName = "//strong[text()='Label']/../../../div/following-sibling::div//form//div[@class='form-group row']//input";
	public static final String addBtn = "//strong[text()='Label']/../../../div/following-sibling::div//form//div//button[text()='Add']";
	public static final String nextBtn = "//button[@class='btn btn-next']";
	public static final String cancelBtn = "//button[@class='btn btn-cancel']";
	public static final String regularExpressionTextArea = "//label[text()='Regular Expression']/following-sibling::div/textarea[contains(@class, 'regexpTextarea')]";
	public static final String saveButton = "//button[text()='Save']";
    public static final String deletePattern = "//td[text()='@override']/following-sibling::td/button[text()='Delete']";
    public static final String deleteOKButton = "//button[text()='OK']";
    public static final String xIconWithNewLabelValue = "//span[@class='k-chip-icon k-icon k-i-x']";
    public static final String labelField = "//input[@class='k-input-inner']";
    public static final String addIncludeKeywordIcon = "//label[text()='@override']//following-sibling::div/button";
    public static final String texFieldOnPopUp = "//textarea[@id='form-ontapshares-field']";
    public static final String addBtnOnPopUp = "//button[text()= 'Add']";
    public static final String deleteKeywordBtn = "//label[text()='@override']/../following-sibling::div//button/i[@class='fas fa-trash-alt']";
    public static final String plusIconForIncludeWords = "//label[text()='Include Words']/../preceding-sibling::div[1]/div/button";
    public static final String editPattern = "//td[text()='@override']/following-sibling::td/button[text()='Edit']";
    public static final String stringTextField = "//label[text()='String']/following-sibling::div/input";
    public static final String testTextField = "//div[@class='k-editor-content k-valid']/div//br";
    public static final String testBtn = "//button[text()='TEST']";
    public static final String testConfirmationMsg = "//div[@class='alert alert-success']";
    
    
}
