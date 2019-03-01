package com.qa.jenkinstests;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.jenkinspages.Login;
import com.qa.jenkinspages.Manage;
import com.qa.jenkinspages.Users;

@RunWith(Parameterized.class)
public class AParametersTest {

	WebDriver driver;
	static FileInputStream file;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Parameters
	public static Collection<Object[]> data() throws IOException {
		file = new FileInputStream("C:\\Users\\Admin\\Downloads\\Assessment\\AssessmentFriday.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(0);
		Object[][] logins = new Object[sheet.getPhysicalNumberOfRows() - 1][5];

		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			for (int colNum = 0; colNum < 5; colNum++) {
				logins[rowNum - 1][colNum] = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			}
		}
		file.close();
		return Arrays.asList(logins);
	}

	private String username;
	private String name;
	private String pass;
	private String passConfirm;
	private String email;

	public AParametersTest(String username, String name, String pass, String passConfirm, String email) {
		this.username = username;
		this.name = name;
		this.pass = pass;
		this.passConfirm = passConfirm;
		this.email = email;
	}

	@Test
	public void addUsers() throws InterruptedException {
		driver.get(Login.page);
		Login login = PageFactory.initElements(driver, Login.class);
		login.login();
		login.manage();
		Manage manage = PageFactory.initElements(driver, Manage.class);
		manage.manageUsers();
		Users users = PageFactory.initElements(driver, Users.class);
		users.createUser(username, pass, passConfirm, name, email);
		assertEquals("No such name in account list", true, users.findItem(username));
	}
}
