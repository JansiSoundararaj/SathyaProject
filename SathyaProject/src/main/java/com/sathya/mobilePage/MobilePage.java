package com.sathya.mobilePage;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class MobilePage extends TestBase{





	@Test(priority=1)
	public void openBrowser() {
		browserOpen();
//		maximizeWindow();
//		pageLoadTimeout();
//		implicitWait();
		

	}
	
	@Test(priority=2)
		public void login() throws IOException {
		
	Mobiles mobilePage=new Mobiles();
		mobilePage.action();
	
		
//	mobilePage.write();
//	mobilePage.bestInproductSheet();
//		mobilePage.userName(userName).password(password).submit();
	}

}
