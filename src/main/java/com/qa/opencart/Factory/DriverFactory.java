package com.qa.opencart.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	FileInputStream ip;

	public WebDriver initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser");

		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "E:\\Naveen\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.chrome.driver", "E:\\Naveen\\drivers\\chromedriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.chrome.driver", "E:\\Naveen\\drivers\\chromedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Please enter the valid browser name");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}

	public Properties initProperty() {
		prop = new Properties();
		String envName = System.getProperty("env");
		try {
			if (envName == null) {
				ip = new FileInputStream(
						"E:\\SeleniumPracticals\\POMFramework2\\src\\tests\\resources\\config\\config.properties");
				System.out.println("You haven't passed the environment, so running on default stage environment..");
			} else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream(
							"E:\\SeleniumPracticals\\POMFramework2\\src\\tests\\resources\\config\\QA.config.properties");
					System.out.println("Running on QA environment..");
					break;

				default:
					System.out.println("Please pass the valid browser..");
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
