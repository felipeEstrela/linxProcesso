package test;

import org.junit.*;
import components.*;
import utils.Driver;

public class TestKabum extends Driver{
	
	Kabum kbm;
	
	@Before
	public void setUp(){
		driver = newDriver();
		kbm = new Kabum();
	}
	
	@Test
	public void CT0001() throws Exception{
		
		kbm.navegate(driver);
		kbm.searchProd(driver, "Mouse Razer");
		kbm.goToElementAndClick(driver);
		kbm.checkInfoProd(driver);
		kbm.insertToCart(driver);
		kbm.checkInfoCart(driver);
		kbm.removeProd(driver);
		kbm.checkInfoCartClear(driver);
		kbm.goToHome(driver);
	}
	
	@After
	public void tearDown(){
		closeDriver(driver);
	}

	
	
}
