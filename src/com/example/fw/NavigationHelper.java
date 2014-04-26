package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends WebDriverHelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void mainPage() {
		if (! onMainPage()) {
			click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {	
		return (driver.findElements(By.id("maintable")).size() > 0);
	}
	
	
	public void groupsPage() {
		if (! onGroupsPage()) {
			click(By.linkText("groups"));
		}
	}

	private boolean onGroupsPage() {
		return (driver.findElements(By.xpath("//input[@value='New group']")).size() > 0);
	}
}
