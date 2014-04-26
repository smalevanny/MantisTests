package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class AccountHelper extends WebDriverHelperBase {
	
	public AccountHelper(ApplicationManager manager) {
		super(manager);
	}

	public void signUp(User user) {
		openUrl("/");
		click(By.linkText("Signup for a new account"));
		type(By.name("username"), user.login);
		type(By.name("email"), user.email);
		click(By.cssSelector("input.button"));
		
		pause(3000);
		Msg msg = manager.getMailHelper().getNewMail(user.login, user.password);
		String confirmationLink = msg.getConfirmationLink();
		openAbsoluteUrl(confirmationLink);
		
		type(By.name("password"), user.password);
		type(By.name("password_confirm"), user.password);
		click(By.cssSelector("input.button"));
	}

	public void login(User user) {
		openUrl("/");
		type(By.name("username"), user.login);
		type(By.name("password"), user.password);
		click(By.cssSelector("input.button"));
	}

	public String loggedUser() {
		WebElement element = driver.findElement(By.cssSelector("td.login-info-left span"));
		return element.getText();
	}

}
