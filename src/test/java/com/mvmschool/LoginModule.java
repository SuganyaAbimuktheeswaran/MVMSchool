package com.mvmschool;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginModule {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://frontuser.mvmschoolsavadi.com/login");
		
		WebElement txtuserName = driver.findElement(By.xpath("//input[@name='email']"));
		txtuserName.clear();
		txtuserName.sendKeys("luffy@gmail.com");
		WebElement txtpassword = driver.findElement(By.xpath("//input[@name='password']"));
		txtpassword.clear();
		txtpassword.sendKeys("12345");
		WebElement btnsignin = driver.findElement(By.xpath("//button[@class='w-100 btn btn-primary d-block w-100']"));
		btnsignin.click();
		
		
		//HOMEPAGE
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement ddnMaster = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Masters']")));
        ddnMaster.click();
		//SCHOOL
//		WebElement Schools = driver.findElement(By.xpath("//span[text()='Schools']"));
//		Schools.click();
//		
//		WebElement txtSearchBox = driver.findElement(By.xpath("//input[@type='search']"));
//		txtSearchBox.sendKeys("ABC");
//		
//		WebElement btnAddSchool = driver.findElement(By.xpath("//a[@class='btn btn-primary text-white']"));
//		btnAddSchool.click();
//		
//		WebElement txtSchoolName = driver.findElement(By.xpath("//input[@name='schoolname']"));
//		txtSchoolName.sendKeys("Maharishi Vidhya Mandir School");
//		
//		WebElement txtSchoolCode = driver.findElement(By.xpath("//input[@name='schoolcode']"));
//		txtSchoolCode.sendKeys("THANJAVURR");
//		
//		WebElement txtSchoolLocation = driver.findElement(By.xpath("//input[@name='schoollocation']"));
//		txtSchoolLocation.sendKeys("Chennai");
//		
//		WebElement txtSchoolEnailId = driver.findElement(By.xpath("//input[@name='emailid']"));
//		txtSchoolEnailId.sendKeys("xyz@gmail.com");
//		
//		WebElement txtSchoolMobileNo = driver.findElement(By.xpath("//input[@name='mobilenumber']"));
//		txtSchoolMobileNo.sendKeys("9874563211");
//		
//		WebElement txtSchoolAddress = driver.findElement(By.xpath("//textarea[@name='address']"));
//		txtSchoolAddress.sendKeys("Chrompet,Chennai");
//		
//		WebElement btnStatus = driver.findElement(By.id("radioinline1"));
//		btnStatus.click();
//		
//		WebElement btnAdd = driver.findElement(By.xpath("//button[@type='submit']"));
//		btnAdd.click();
		    
	    //DEPARTMENT
		WebElement department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Departments']")));
		department.click();
		
		WebElement btnAddDept = driver.findElement(By.xpath("//a[@class='btn btn-primary text-white']"));
		btnAddDept.click();
		
		WebElement txtDeptName = driver.findElement(By.xpath("//input[@name='departmentname']"));
		txtDeptName.sendKeys("Chemistry");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checkBoxSchool = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='66fa7097cd0238839a9d5463']")));
		js.executeScript("arguments[0].click();", checkBoxSchool);
		
		
		
		WebElement txtDescription = driver.findElement(By.xpath("//textarea[@name='description']"));
		txtDescription.sendKeys("Chemistry Department");
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement btnStatus2 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("RaiserequestsBasic")));
		btnStatus2.click();
		
		WebElement btnSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
		btnSubmit.click();
		Thread.sleep(6000);
		
		WebElement btnview = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-eye'])[1]")));
		btnview.click();
		Thread.sleep(6000);
		
		WebElement btnBack = driver.findElement(By.xpath("//button[text()='Back']"));
		btnBack.click();
		
		WebElement btnEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil-square-o'])[1]")));
		btnEdit.click();
		
		WebElement afterEditTxtDeptName =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='departmentname']")));
		afterEditTxtDeptName.clear();
		Thread.sleep(3000);
		afterEditTxtDeptName.sendKeys("Physics");
		
		WebElement afterEditTxtDescription = driver.findElement(By.xpath("//textarea[@name='description']"));
		afterEditTxtDescription.clear();
		Thread.sleep(3000);
		afterEditTxtDescription.sendKeys("Physics Department");
		
		WebElement btnUpdate = driver.findElement(By.xpath("//button[text()='Update']"));
		btnUpdate.click();
		Thread.sleep(2000);
		WebElement btnDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-trash'])[1]")));
		btnDelete.click();
	
		Thread.sleep(2000);
		WebElement btnDeleteOk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger']")));
		btnDeleteOk.click();
		
		Thread.sleep(6000);
		
		
		//BUDGET CONFIGURATION
		
		WebElement budgetConfiguration =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='/masters/configurations'])[1]")));
		try {
			budgetConfiguration.click(); // Perform action
		} catch (StaleElementReferenceException e) {
			budgetConfiguration = driver.findElement(By.xpath("(//a[@href='/masters/configurations'])[1]")); // Re-fetch the element
			budgetConfiguration.click(); // Try the action again
		}

		Thread.sleep(6000);
		WebElement btnAddBudgetConfiguration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add budget Configuration']")));
		btnAddBudgetConfiguration.click();
		
		WebElement schoolId =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='schoolid']")));
		schoolId.click();
		WebElement schoolName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='Maharishi Vidhya Mandir School']")));
		schoolName.click();

		
		WebElement txtBudget = driver.findElement(By.xpath("//input[@name='budget']"));
		txtBudget.sendKeys("10000");
		
		
		WebElement btnSubmit1 = driver.findElement(By.xpath("//button[@type='submit']"));
		btnSubmit1.click();
		Thread.sleep(6000);
		
		WebElement btnview1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-eye'])[5]")));
		btnview1.click();
		Thread.sleep(6000);
		
		WebElement btnBack1 = driver.findElement(By.xpath("//button[text()='Back']"));
		btnBack1.click();
		
		WebElement btnEdit1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil-square-o'])[5]")));
		btnEdit1.click();
		
		WebElement forEditSchoolId =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='schoolid']")));
		forEditSchoolId.click();
		WebElement forEditSchoolName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='Maharishi Vidya Mandir Senior Secondary School']")));
		forEditSchoolName.click();

		WebElement forEditTxtBudget = driver.findElement(By.xpath("//input[@name='budget']"));
		forEditTxtBudget.clear();
		Thread.sleep(2000);
		forEditTxtBudget.sendKeys("20000");
		
		Thread.sleep(2000);
		WebElement btnUpdate1 = driver.findElement(By.xpath("//button[text()='Update']"));
		btnUpdate1.click();
		Thread.sleep(2000);
		WebElement btnDelete1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-trash'])[5]")));
		btnDelete1.click();
	
		Thread.sleep(3000);
		WebElement btnDeleteOk1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger']")));
		btnDeleteOk1.click();
		
		
		Thread.sleep(6000);
		
		//TAGS
		
		WebElement tags = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='/masters/tags'])[1]")));
		tags.click();
		
		WebElement btnAddTags = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/masters/tags/createnewtags']")));
		btnAddTags.click();
		
		WebElement txtTagName = driver.findElement(By.xpath("//input[@name='name']"));
		txtTagName.sendKeys("Chemistry Department");
		
		WebElement txtDescription1 = driver.findElement(By.xpath("//input[@name='description']"));
		txtDescription1.sendKeys("Need a Chemicals");
		
		WebElement radioBtn = driver.findElement(By.id("RaiserequestsBasic"));
		radioBtn.click();
		
		WebElement btnSubmit2 = driver.findElement(By.xpath("//button[text()='Add']"));
		btnSubmit2.click();
		Thread.sleep(6000);
		
		WebElement btnview2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-eye'])[1]")));
		btnview2.click();
		Thread.sleep(6000);
		
		WebElement btnBack2 = driver.findElement(By.xpath("//button[text()='Back']"));
		btnBack2.click();
		
		WebElement btnEdit2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-pencil-square-o'])[1]")));
		btnEdit2.click();
		

		WebElement forEditTxtTagName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
		forEditTxtTagName.clear();
		Thread.sleep(2000);
		forEditTxtTagName.sendKeys("Computer Department");
		
		WebElement forEditTxtDescription1 = driver.findElement(By.xpath("//input[@name='description']"));
		Thread.sleep(2000);
		forEditTxtDescription1.clear();
		
		forEditTxtDescription1.sendKeys("Need a Computer");
		
		

		Thread.sleep(2000);
		WebElement btnUpdate2 = driver.findElement(By.xpath("//button[text()='Update']"));
		btnUpdate2.click();
		Thread.sleep(2000);
		WebElement btnDelete2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-trash'])[1]")));
		btnDelete2.click();
	
		Thread.sleep(2000);
		WebElement btnDeleteOk2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger']")));
		btnDeleteOk2.click();
		
		

//		//CATEGORIES
//		WebElement Categories  = driver.findElement(By.xpath("//span[text()='Categories']"));		
//		Categories.click();
//		
//		WebElement btnAddCategory =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/masters/categories/createnewcategories']")));
//		btnAddCategory.click();
//		
		
		
		
		
		
		
		
		
		
		
	}

}
