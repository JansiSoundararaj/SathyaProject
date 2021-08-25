package com.sathya.mobilePage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class Mobiles extends TestBase{
	

//	Actions builder = new Actions(driver);


	@FindBy(xpath="//ul[@class='nav nav-tabs nav-tabs-line']//a[@href='#pd-tabs-2']") WebElement features;
	@FindBy(xpath="//table[@class='table pd-specs-table']//tr//td[text()='Brand']/following-sibling::td") WebElement brandElement;
	@FindBy(xpath="//aside[@class='col-12 col-md-6 col-lg-5 pd-info-col zoom-window-container']//div[@class='pd-group clearfix']//span[contains(text(),'Regular:')]/following-sibling::span[1]") WebElement regularPriceElement;
	@FindBy(xpath="//aside[@class='col-12 col-md-6 col-lg-5 pd-info-col zoom-window-container']//div[@class='pd-group clearfix']//div[@class='pd-price-block']") WebElement currentPriceElement;
	@FindBy(xpath="//div[@class='pd-oldprice-line']//span[contains(text(),'You save:')]/following-sibling::span") WebElement youSavedElement;
	@FindBy(xpath="//table[@class='table pd-specs-table']//tr//td[text()='Primary Camera']/following-sibling::td") WebElement frontCameraElement;
	@FindBy(xpath="//table[@class='table pd-specs-table']//tr//td[text()='Secondary Camera']/following-sibling::td") WebElement rearCameraElement;
	@FindBy(xpath="//table[@class='table pd-specs-table']//tr//td[text()='RAM Capacity']/following-sibling::td") WebElement ramCapacityElement;
	@FindBy(xpath="//table[@class='table pd-specs-table']//tr//td[text()='ROM Capacity']/following-sibling::td") WebElement romCapacityElement;
	@FindBy(xpath="//table[@class='table pd-specs-table']//tr//td[text()='Operating System']/following-sibling::td") WebElement operatingSystemElement;
	@FindBy(xpath="//table[@class='table pd-specs-table']//tr//td[text()='Processor']/following-sibling::td") WebElement processorElement;
	public Mobiles() {
		PageFactory.initElements(driver, this);
	}
	ArrayList<ProductInformation> info=new ArrayList<ProductInformation>();
//	@DataProvider(name="getMobileDetails")
//	@SuppressWarnings("unused")
	public void action()
	{
//		ArrayList<ProductInformation> info=new ArrayList<ProductInformation>();
		String brand="";
		String regularPrice="";
		String currentPrice="";
		String youSaved="";
		String frontCamera="";
		String rearCamera="";
		String ramCapacity="";
		String romCapacity="";
		String operatingSystem="";
		String processor="";
		List<String> value = new ArrayList<String>();
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table pd-specs-table']//tbody//tr"));

		for (int l=1;l<=tableRows.size();l++) {
			String a =  driver.findElement(By.xpath("//table[@class='table pd-specs-table']//tr["+l+"]//td")).getText();
			value.add(a);
		}
		WebElement asideText=driver.findElement(By.xpath("//aside[@class='col-12 col-md-6 col-lg-5 pd-info-col zoom-window-container']//div[@class='pd-group clearfix']"));
		String	b =  asideText.getText();
		String	c =  driver.findElement(By.xpath("//aside[@class='col-12 col-md-6 col-lg-5 pd-info-col zoom-window-container']")).getText();

		for (int i=1; i<=10; i++)
		{


			driver.findElement(By.xpath("//article["+i+"]//a[@class='art-picture img-center-container']")).click();


			if(value.contains("Brand")) {
				brand=brandElement.getText();

			}
			else {
				brand="Nil";
			}

			if(b.toLowerCase().contains("regular")) {
				regularPrice=regularPriceElement.getText();
				regularPrice=regularPrice.substring(2);
				regularPrice=regularPrice.replace(",", "");

			}
			else {
				regularPrice="Nil";
			}	
			if(c.toLowerCase().contains("review"))
			{
				currentPrice=currentPriceElement.getText();
				currentPrice=currentPrice.substring(2);
				currentPrice=currentPrice.replace(",", "");

			}
			else {
				currentPrice="Nil";
			}
			if(driver.findElements(By.xpath("//div[@class='pd-oldprice-line']//span[contains(text(),'You save:')]/following-sibling::span")).size()>0)
			{
				youSaved=youSavedElement.getText();	
				youSaved=youSaved.substring(2);
				youSaved=youSaved.replaceAll("10", "");
				youSaved=youSaved.replaceAll("%", "");
				youSaved=youSaved.replaceAll(" ", "");
				youSaved=youSaved.replaceAll("()", "");
			}
			else
			{
				youSaved="Nil";
			}

			if(value.contains("Primary Camera")) {
				frontCamera=frontCameraElement.getText();
				frontCamera = frontCamera.replace("MP", "");
				frontCamera = frontCamera.replace(" ", "");
				String[] split_Value=frontCamera.split("\\+");
				int add=0;
				for(int indexPlus=0; indexPlus<split_Value.length;indexPlus++) {
					int cam=Integer.parseInt(split_Value[indexPlus]);
					add=add+cam;
				}
				frontCamera=add+"";

			}
			else {
				frontCamera="Nil";
			}	
			if(value.contains("Secondary Camera")) {
				rearCamera=rearCameraElement.getText();
				rearCamera=rearCamera.replace(" MP", "");

			}
			else {
				rearCamera="Nil";
			}	
			if(value.contains("RAM Capacity")) {
				ramCapacity=ramCapacityElement.getText();
				ramCapacity=ramCapacity.replace(" GB", "");

			}
			else {
				ramCapacity="Nil";
			}	
			if(value.contains("ROM Capacity")) {
				romCapacity=romCapacityElement.getText();
				romCapacity=romCapacity.replace(" GB", "");

			}
			else {
				romCapacity="Nil";
			}	
			if(value.contains("Operating System")) {
				operatingSystem=operatingSystemElement.getText();


			}
			else {
				operatingSystem="Nil";
			}	
			if(value.contains("Processor")) {
				processor=processorElement.getText();


			}
			else {

				processor="Nil";
			}	


//System.out.print(info);

			System.out.print(info.add(new ProductInformation(brand, currentPrice, regularPrice, youSaved, frontCamera, rearCamera, ramCapacity, romCapacity, operatingSystem, processor)));


			driver.navigate().back();
		}

	}







//	 public Object[][] getMobileDetails() throws IOException
//	{
//
//		return new Object[][]{
//			FileInputStream fis = new FileInputStream("D:\\Testing class\\testing\\selenium code\\MobileDetails1.xlsx");
//			XSSFWorkbook workbook = new XSSFWorkbook(fis);
//			XSSFSheet sheet = workbook.getSheetAt(0);
	

//			for(int i=0; i<info.size();i++)
//			{
	
//
//				sheet.createRow(i+1);
//				sheet.getRow(i+1).createCell(0).setCellValue((i+1));
//				sheet.getRow(i+1).createCell(1).setCellValue(info.get(i).getBrand());
//				sheet.getRow(i+1).createCell(2).setCellValue(info.get(i).getCurrentPrice());
//				sheet.getRow(i+1).createCell(3).setCellValue(info.get(i).getRegularPrice());
//				sheet.getRow(i+1).createCell(4).setCellValue(info.get(i).getYouSaved());
//				sheet.getRow(i+1).createCell(5).setCellValue(info.get(i).getFrontCamera());
//				sheet.getRow(i+1).createCell(6).setCellValue(info.get(i).getRearCamera());
//				sheet.getRow(i+1).createCell(7).setCellValue(info.get(i).getRamCapacity());
//				sheet.getRow(i+1).createCell(8).setCellValue(info.get(i).getRomCapacity());
//				sheet.getRow(i+1).createCell(9).setCellValue(info.get(i).getOperatingSystem());
//				sheet.getRow(i+1).createCell(10).setCellValue(info.get(i).getProcessor());
//			}
//			fis.close();
//
//
//
//			FileOutputStream fos = new FileOutputStream("D:\\Testing class\\testing\\selenium code\\MobileDetails1.xlsx");
//			workbook.write(fos);
//			fos.close();
//			workbook.close();
//		}
//
//
//
//
//	}
//
//
//
//	void bestInproductSheet() throws IOException
//	{
//		int firstRam = 0, firstRom = 0, firstfc=0,firstrc=0,firstcp=0;
//		int compareRam = 0, compareRom = 0, comparefc=0,comparerc=0,comparecp=0;
//		String mobileName = null, mobileName1=null,mobileName2=null,mobileName3=null,mobileName4=null;
//		String bestRam=null, bestRom=null,bestfc=null,bestrc=null, bestcp=null;
//
//		for(int i=0;i<info.size();i++)		//compare ram
//		{
//			String ram=info.get(i).getRamCapacity().replace(" GB", "");
//			compareRam =Integer.parseInt(ram);
//
//			if(firstRam <= compareRam)
//			{
//				firstRam=compareRam;
//				mobileName=info.get(i).getBrand();
//			}
//			bestRam=firstRam+" GB";
//
//		}
//
//		for(int i=0;i<info.size();i++)		//compare rom
//		{
//			String rom=info.get(i).getRomCapacity().replace(" GB", "");
//			compareRom =Integer.parseInt(rom);
//
//			if(firstRom <= compareRom)
//			{
//				firstRom=compareRom;
//			}
//			bestRom=firstRom+" GB";
//			mobileName1=info.get(i).getBrand();
//		}
//
//		for(int i=0;i<info.size();i++)		//compare frontcam
//		{
//			String fc=info.get(i).getFrontCamera().replace("MP", "");
//			comparefc =Integer.parseInt(fc);
//
//			if(firstfc <= comparefc)
//			{
//				firstfc=comparefc;
//			}
//			bestfc=firstfc+"MP";
//			mobileName2=info.get(i).getBrand();
//		}
//		for(int i=0;i<info.size();i++)		//compare rearcam
//		{
//			String rc=info.get(i).getRearCamera().replace("MP", "").replace(" ", "");
//			comparerc =Integer.parseInt(rc);
//
//			if(firstrc <= comparerc)
//			{
//				firstrc=comparerc;
//				mobileName3=info.get(i).getBrand();
//			}
//			bestrc=firstrc+"MP";
//
//		}
//
//		for(int i=0;i<info.size();i++)		//compare currentprice
//		{
//			String cp=info.get(i).getCurrentPrice().substring(2).replace(".00", "").replace(",", "");
//			comparecp =Integer.parseInt(cp);
//
//			if(firstcp <= comparecp)
//			{
//				firstcp=comparecp;
//			}
//			bestcp=firstcp+" INR";
//			mobileName4=info.get(i).getBrand();
//		}
//
//
//		System.out.println(bestRam+" "+bestRom+" "+bestfc+" "+bestrc+" "+bestcp);
//		System.out.println(mobileName+" "+mobileName+" "+mobileName2+" "+mobileName3+" "+mobileName4);
//		FileInputStream fis = new FileInputStream("D:\\Suganya\\MobileDetails.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(1);
//		sheet.getRow(1).createCell(1).setCellValue(mobileName4);
//		sheet.getRow(1).createCell(2).setCellValue(bestcp);
//		sheet.getRow(2).createCell(1).setCellValue(mobileName);
//		sheet.getRow(2).createCell(2).setCellValue(bestRam);
//		sheet.getRow(3).createCell(1).setCellValue(mobileName1);
//		sheet.getRow(3).createCell(2).setCellValue(bestRom);
//		sheet.getRow(4).createCell(1).setCellValue(mobileName2);
//		sheet.getRow(4).createCell(2).setCellValue(bestfc);
//		sheet.getRow(5).createCell(1).setCellValue(mobileName3);
//		sheet.getRow(5).createCell(2).setCellValue(bestrc);
//		fis.close();
//		FileOutputStream fos = new FileOutputStream("D:\\Suganya\\MobileDetails.xlsx");
//		workbook.write(fos);
//		fos.close();
//		workbook.close();
//
//
//
//
//
//	}
}
