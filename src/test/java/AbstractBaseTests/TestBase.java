package AbstractBaseTests;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.accenture.TestFramework2.RunEvent;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public abstract class TestBase extends AbstractTestNGCucumberTests {
	public static RunEvent<?> runevent;
	public static String user, pss;
	public static String[] argumentosAutenticacionMovil = new String[4];
	public static XSSFSheet sheet;
	public static String testtype;
	
	@BeforeClass
	 public  void setUpPage() throws InterruptedException, IOException {
		System.out.println("Set Up");

		 String port =System.getProperty("port");
		 if ((port==null)||(port.equals(""))) {
			 port= "4723"  ;
		}
		 String url =System.getProperty("url");
		 if ((port==null)||(port.equals(""))) {
			 url= ""  ;
		}
		 String ip =System.getProperty("port");
		 if ((ip==null)||(ip.equals(""))) {
			 ip= "0.0.0.0"  ;
		}
		 String pack =System.getProperty("pack");
		 if ((pack==null)||(pack.equals(""))) {
			 pack= "com.banistmo.per.apl.appmobile"  ;
//			 pack= "C:\\Users\\d.diaz.alvarez\\Downloads\\chromedriver_win32\\chromedriver.exe"  ;
		}
		 String act =System.getProperty("act");
		 if ((act==null)||(act.equals(""))) {
			 act= "com.banistmo.per.apl.appmobile.MainActivity"  ;
//			 act= "Report"  ;
		}
		  testtype =System.getProperty("testtype");
		 if ((testtype==null)||(testtype.equals(""))) {
			 testtype= "AWS"  ;
//			 testtype= "SeleniumChrome";
		}
		// com.banistmo.ca.apr.app.personas/com.banistmo.ca.apr.app.personas.MainActivity}
		runevent = Utilidades.setDriverType(testtype);
		runevent.setIp(ip);
		runevent.setPort(port);
		sheet = runevent.leerExcel(System.getProperty("user.dir") + "/Data/DataDriveAutenticacionMovil.xlsx",0);
		runevent.initDriver(pack, act, 10);
		runevent.setCapturar(false);
		//driver = runevent.getDriver();
		Thread.sleep(2000); // tiempo de espera por que la aplicacion demora demaciado en iniciar 
		
		// verificar si el app es hybrida para implementar esta linea de codigo 
		if (testtype.contains("Appium")||testtype.contains("AWS")) {
			runevent.ingresarAlWebview("Ionic App");
			Thread.sleep(6000);
		}else {
			runevent.gotoUrl("https://d3qacmft9our92.cloudfront.net/login");
		}
	}

	 
	 
	 @BeforeSuite
	 public void setUpAppium() throws IOException, InterruptedException{
		 
	 }
	 
	 @AfterClass
	 public void restartApp() {
		 
	 }
	 @AfterSuite
	 public void tearDownAppium() {
//	       try {
//			runevent.closeDriver();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	  }
}
