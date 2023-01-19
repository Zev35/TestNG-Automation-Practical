package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public static int generateRandomNumber(int boundry) {

		Random rnd = new Random();
		int generatednumber = rnd.nextInt(boundry);
		return generatednumber;

	}

}
