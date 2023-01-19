package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import util.BrowserFactory;

public class AddCategoryPage extends BasePage {

	WebDriver driver;
	String generatedName;
	@FindBy(how = How.NAME, using = "categorydata")
	WebElement categoryName;
	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement addCategory;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'@@TestNg20')]")
	WebElement categoryIsDisplayed;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Yes')]")
	WebElement updateCategory;
	@FindBy(how = How.NAME, using = "due_month")
	WebElement dueMonth;

	public void insertCategoryName(String name) {
		generatedName = name + generateRandomNumber(99);
		categoryName.sendKeys(generatedName);
		System.out.println(generatedName);
	}

	public void clickAddCategory() {

		addCategory.click();
	}

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;

	}

	public void categoryNameIsDisplayed() {

		List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='controls']//span"));

		for (int i = 0; i < allElements.size(); i++) {

			if (allElements.get(i).getText().equals(generatedName)) {

				System.out.println("true");
			} else {

				System.out.println("false");
			}

		}
	}

	public void noDuplicateCategory() {
		categoryName.sendKeys(generatedName);
		addCategory.click();
		String warningText = ("The category you want to add already exists " + generatedName);
		List<WebElement> list = driver.findElements(By.xpath("//body[contains(text(),warningText)]"));

		if (list.size() > 0) {
			System.out.println("Text:" + warningText + " is present. ");

		} else {

			System.out.println("no duplicates");
		}

	}

	public int selectFromDropDown() {

		updateCategory.click();

		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec" };

		Select sel = new Select(dueMonth);
		List<WebElement> option = sel.getOptions();
		int count = 0;
		for (WebElement dropdown : option) {
			System.out.println("dropdown options :" + dropdown.getText());
			for (int i = 0; i < months.length; i++) {
				if (dropdown.getText().equalsIgnoreCase(months[i])) {
					count++;
					break;
				}

			}

		}

		return count;
	}

}
