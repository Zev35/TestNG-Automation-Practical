package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCategoryPage;
import util.BrowserFactory;

public class AddCategoryTest {
	WebDriver driver;
	String NAME = "@@TestNg";

	@Test
	public void userAbleToAddCategory() throws IOException, InterruptedException {

		driver = BrowserFactory.init();

		AddCategoryPage addcategory = PageFactory.initElements(driver, AddCategoryPage.class);

		addcategory.insertCategoryName(NAME);

		addcategory.clickAddCategory();
		addcategory.categoryNameIsDisplayed();

		addcategory.noDuplicateCategory();
        addcategory.selectFromDropDown();
        BrowserFactory.tearDown();
	}

}
