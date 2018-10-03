package Tests;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accenture.TestFramework2.RunEvent;

import AbstractBaseTests.TestBase;
import AbstractBaseTests.Utilidades;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@CucumberOptions(strict = true, monochrome = true, 
features = "classpath:features", 
plugin = { "pretty" }
//,tags= {"@tag","@tag1"}
)
public class Login extends TestBase {

	
	String userSecret ;
	public void loginExitoso(String usuario ,String passwrd,RunEvent runer) throws Exception {
		runevent = runer;
		Thread.sleep(100);
		ingresaruser(usuario);
		clickContinuar();
		ingresarPss(passwrd);
		clickIngresar();
	}
	
	@Given("^que el usuario ingresar a la app de Banistmo$")
	public void que_el_usuario_ingresar_a_la_app_de_Banistmo() throws Throwable {
		System.out.println("Ingreso a la aplicacion");
	}

	@When("^ingresa sus credenciales correctas$")
	public void ingresa_sus_credenciales_correctas() throws Throwable {
		findExpectativa("loginExitoso");
		Thread.sleep(100);
		ingresaruser(user);System.out.println("user");
		runevent.clickWait(By.cssSelector("p"));
		clickContinuar();System.out.println("continuar");
		ingresarPss(pss);System.out.println("psss");
		runevent.clickWait(By.cssSelector("p"));
		clickIngresar();System.out.println("ingresar");
	}

	@Then("^el deberia poder ver la pagina principal de la app$")
	public void el_deberia_poder_ver_la_pagina_principal_de_la_app() throws Throwable {
		WebElement button = (new WebDriverWait((WebDriver)runevent.getDriver(), 100)).until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-t1-3")));
		tearDown();
	}

	@When("^ingresa sus credenciales correctas y elige la opcion de recordar usuario$")
	public void ingresa_sus_credenciales_correctas_y_elige_la_opcion_de_recordar_usuario() throws Throwable {
		findExpectativa("loginExitoso");
		Thread.sleep(100);
		ingresaruser(user);System.out.println("user");
		runevent.clickWait(By.cssSelector("p"));
		clickRecordar();
		clickContinuar();System.out.println("continuar");
		ingresarPss(pss);System.out.println("psss");
		runevent.clickWait(By.cssSelector("p"));
		clickIngresar();System.out.println("ingresar");
		Thread.sleep(2000);
		tearDown();
	}

	@And("^cuando el usuario cierre sesion y vuelva a ingresa a la app$")
	public void cuando_el_usuario_cierre_sesion_y_vuelva_a_ingresa_a_la_app() throws Throwable {
		ingresarRecordandouser();
		userSecret = ""+user.charAt(0);
		for (int i = 1; i < user.length() -1; i++) {
			userSecret= userSecret+"*";
		}
	}

	@Then("^el debera observar sus credenciales en el campos correspondiente$")
	public void el_debera_observar_sus_credenciales_en_el_campos_correspondiente() throws Throwable {
		userSecret= userSecret+user.charAt(user.length()-1);
		runevent.CompararTextodeAtributo(By.cssSelector("#inpUser > input"), userSecret, "value");
				
		tearDown();	
	}

	@When("^el usuario ingresa sus credenciales correctas y selecciona la opcion de recorda usuario$")
	public void el_usuario_ingresa_sus_credenciales_correctas_y_selecciona_la_opcion_de_recorda_usuario()
			throws Throwable {
		findExpectativa("loginExitoso");
		Thread.sleep(100);
		ingresaruser(user);System.out.println("user");
		runevent.clickWait(By.cssSelector("p"));
		clickRecordar();
		clickContinuar();System.out.println("continuar");
		ingresarPss(pss);System.out.println("psss");
		runevent.clickWait(By.cssSelector("p"));
		clickIngresar();System.out.println("ingresar");
	}

	@And("^el usuario cierre su sesion y vuelca a ingresar a la app deberia de observar sus credenciales en el correspondiente campo$")
	public void el_usuario_cierre_su_sesion_y_vuelca_a_ingresar_a_la_app_deberia_de_observar_sus_credenciales_en_el_correspondiente_campo()
			throws Throwable {
		tearDown();
		ingresarRecordandouser();
	}

	@And("^el usuario vuelva a hacer login en el app deseleccionado la opcion de recordar usuario$")
	public void el_usuario_vuelva_a_hacer_login_en_el_app_deseleccionado_la_opcion_de_recordar_usuario()
			throws Throwable {
		clickRecordar();
		clickContinuar();System.out.println("continuar");
		ingresarPss(pss);System.out.println("psss");
		clickIngresar();System.out.println("ingresar");
		tearDown();
	}

	@Then("^cuando el cierre sesion y vuelva a ingresa a la app sus credenciales no deberian estar$")
	public void cuando_el_cierre_sesion_y_vuelva_a_ingresa_a_la_app_sus_credenciales_no_deberian_estar()
			throws Throwable {
		ingresarRecordandouser();
		tearDown();	
	}

	@When("^ingresa sus credenciales incorrectas$")
	public void ingresa_sus_credenciales_incorrectas() throws Throwable {
		findExpectativa("usuarioIncorrecto");
		ingresaruser(user);
		runevent.clickWait(By.cssSelector("p"));
		clickContinuar();System.out.println("continuar");
		ingresarPss(pss);System.out.println("psss");
		clickIngresar();System.out.println("ingresar");
	}

	@Then("^el deberia de observa un mensaje de alerta$")
	public void el_deberia_de_observa_un_mensaje_de_alerta() throws Throwable {
		validarmensajeerror("La información no es válida. Por favor verifique sus datos de ingreso.");
		tearDown();	
	}

	@When("^el usuario ingresa sus credenciales fallando tres veces en su clave$")
	public void el_usuario_ingresa_sus_credenciales_fallando_tres_veces_en_su_clave() throws Throwable {
		findExpectativa("loginfallidopor3vez");
		ingresaruser(user);
		runevent.clickWait(By.cssSelector("p"));
		clickContinuar();
		ingresarPss(pss);
		runevent.clickWait(By.cssSelector("p"));
		clickIngresar();
		//1
//		ingresaruser(user);
//		clickContinuar();
		System.out.println("ingresar 1 ");
		runevent.clickWait(By.className("button-inner"));
		ingresarPss(pss);
		clickIngresar();
		System.out.println("ingresar 2 ");
		//2
//		ingresaruser(user);
//		clickContinuar();
		runevent.clickWait(By.className("button-inner"));
		ingresarPss(pss);
		clickIngresar();
	}

	
	@Then("^el deberia de observar un mensaje de alerta de bloqueo$")
	public void el_deberia_de_observar_un_mensaje_de_alerta_de_bloqueo() throws Throwable {
		validarmensajeerrorBloqueo("El usuario ha sido bloqueado por <br> seguridad.");
		tearDown();	
	}

	@When("^el usuario ingresa sus credenciales y da click en la opcion ver clave$")
	public void el_usuario_ingresa_sus_credenciales_y_da_click_en_la_opcion_ver_clave() throws Throwable {
		findExpectativa("Contrasenabotonojo");
		Thread.sleep(100);
		//clickChecbox();
		ingresaruser(user);System.out.println("user");
		runevent.clickWait(By.cssSelector("p"));
		clickContinuar();System.out.println("continuar");
		ingresarPss(pss);System.out.println("psss");
		Thread.sleep(2000);
	}

	@Then("^el deberia poder ver su clave$")
	public void el_deberia_poder_ver_su_clave() throws Throwable {
		clickContrasenaojo();
		runevent.clickWait(By.cssSelector("p"));
		
		tearDown();
	}

	@When("^el usuario ingresa sus credenciales bloqueadas$")
	public void el_usuario_ingresa_sus_credenciales_bloqueadas() throws Throwable {
		findExpectativa("loginUsuarioBloqueado");
		ingresaruser(user);
		runevent.clickWait(By.cssSelector("p"));
		clickContinuar();
		ingresarPss(pss);
		runevent.clickWait(By.cssSelector("p"));
		clickIngresar();
	}

	@When("^el usuario no digita nada en el campo usuario$")
	public void el_usuario_no_digita_nada_en_el_campo_usuario() throws Throwable {
		System.out.println("no ingresa datos");
	}

	@Then("^el deberia de observar el boton continuar bloqueado$")
	public void el_deberia_de_observar_el_boton_continuar_bloqueado() throws Throwable {
		try {
			indicarElementoEnabled(By.cssSelector("#btnContinue > button"), runevent, false);

//			runevent.indicarElementoEnabled(((WebDriver)runevent.getDriver()).findElements(By.id("btnContinue")).get(1), "se valida que el boton este bloqueado", false);
			
		} catch (Exception e) {
//		 runevent.indicarElementoFail(((WebDriver)runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
		tearDown();
	}

	@When("^el usuario ingresa sus credenciales excepto su clave$")
	public void el_usuario_ingresa_sus_credenciales_excepto_su_clave() throws Throwable {
		findExpectativa("CampoPasswordObligatorio");
		try {
			ingresaruser(user);
			runevent.clickWait(By.cssSelector("p"));
			clickContinuar();
			
		} catch (Exception e) {
//		 runevent.indicarElementoFail(((WebDriver)runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
		tearDown();
	}

	@Then("^el deberia de observar el boton de acceder bloqueado$")
	public void el_deberia_de_observar_el_boton_de_acceder_bloqueado() throws Throwable {
		try {
			
			indicarElementoEnabled(By.cssSelector("#btnLogin > button"), runevent, false);

		} catch (Exception e) {
//		 runevent.indicarElementoFail(((WebDriver)runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
		tearDown();
	}

	@When("^el usuario intenta ingresar caracteres especiales en le campo usuario$")
	public void el_usuario_intenta_ingresar_caracteres_especiales_en_le_campo_usuario() throws Throwable {
		findExpectativa("loginConCaracteresEspeciales");
		ingresaruser(user);
	}

	@Then("^el deberia el campo usuario vacio$")
	public void el_deberia_el_campo_usuario_vacio() throws Throwable {
		runevent.CompararTexto(By.cssSelector("#inpUser > input"), "");
		//validarmensajeerror("No se aceptan caracteres especiales");
		tearDown();
	}

	@When("^el usuario no ingresa su credencial completa en el campo usuario$")
	public void el_usuario_no_ingresa_su_credencial_completa_en_el_campo_usuario() throws Throwable {
		findExpectativa("longitudMinimaUser");

		ingresaruser(user);
	}

	@Then("^el botono continuar deberia de estar deshabilitado$")
	public void el_botono_continuar_deberia_de_estar_deshabilitado()
			throws Throwable {
		runevent.longitudCaracteres((WebElement)((WebDriver)runevent.getDriver()).findElement(By.id("inpUser")).findElement(By.cssSelector("input")), 8);
		tearDown();
	}

	@When("^el usuario ingresa doce caracteres en el campo usuario$")
	public void el_usuario_ingresa_doce_caracteres_en_el_campo_usuario() throws Throwable {
		findExpectativa("longitudMaximaUser");
		ingresaruser(user);
	}

	@Then("^el deberia de poder ver el boton continuar habiltado$")
	public void el_deberia_de_poder_ver_el_boton_continuar_habiltado() throws Throwable {
		runevent.longitudCaracteres((WebElement)((WebDriver)runevent.getDriver()).findElement(By.id("inpUser")).findElement(By.cssSelector("input")), 12);
		tearDown();
	}

	@When("^el usuario no ingresa su credencial completa en el campo clave$")
	public void el_usuario_no_ingresa_su_credencial_completa_en_el_campo_clave() throws Throwable {
		findExpectativa("longitudMinimaPassword");
		ingresaruser(user);
		runevent.clickWait(By.cssSelector("p"));
		clickContinuar();
		ingresarPss(pss);
	}

	@Then("^el boton ingresar deberia de estar deshabilitado$")
	public void el_boton_ingresar_deberia_de_estar_deshabilitado()
			throws Throwable {
		runevent.longitudCaracteres(By.id("inpPassword"), 8);
		clickIngresar();
		tearDown();
	}

	@When("^el usuario ingresa el maximo de caracteres en el campo clave$")
	public void el_usuario_ingresa_el_maximo_de_caracteres_en_el_campo_clave() throws Throwable {
		findExpectativa("longitudMaximaPassword");
		ingresaruser(user);
		runevent.clickWait(By.cssSelector("p"));
		clickContinuar();
		ingresarPss(pss);
	}

	@Then("^el deberia de poder ver el boton ingresar habiltado$")
	public void el_deberia_de_poder_ver_el_boton_ingresar_habiltado() throws Throwable {
		runevent.longitudCaracteres(By.id("inpPassword"), 12);
		clickIngresar();
		tearDown();
	}

	@When("^el usuario da click en el tooltip del campo usuario$")
	public void el_usuario_da_click_en_el_tooltip_del_campo_usuario() throws Throwable {
		findExpectativa("ValidarToolTipUser");
		Thread.sleep(2000);
		clickToolTipuser();
		runevent.clickWait(By.cssSelector("p"));
	}

	@Then("^el deberia de observar un mensaje correspondiente al tooltip usuario$")
	public void el_deberia_de_observar_un_mensaje_correspondiente_al_tooltip_usuario() throws Throwable {
		validarmensajetolltip("You define it when registering in the People Virtual Branch or Banistmo APP, it is personal and non-transferable");
//		validarmensajetolltip("Usted lo define al registrarse en la Sucursal Virtual Personas o Banistmo APP, es personal e intransferible");
		tearDown();
	}

	@When("^el usuario da click en el tooltip del campo clave$")
	public void el_usuario_da_click_en_el_tooltip_del_campo_clave() throws Throwable {
		findExpectativa("ValidarToolTipPass");
		Thread.sleep(100);
		ingresaruser(user);System.out.println("user");
		runevent.clickWait(By.cssSelector("p"));
		clickContinuar();System.out.println("continuar");
		clickToolTippass();
	}

	@Then("^el deberia de observar un mensaje correspondiente al tooltip clave$")
	public void el_deberia_de_observar_un_mensaje_correspondiente_al_tooltip_clave() throws Throwable {
		validarmensajetolltip("The password was defined by you at the time of registration to the Personal Branch or Banistmo APP, it is personal and non-transferable");
//		validarmensajetolltip("La contraseña fue definida por usted en el momento de realizar el registro a la Sucursal Virtual Personas o Banistmo APP, es personal e intransferible");
		tearDown();
	}

	@When("^el usuario ingresa sus credenciales pero cancela el login$")
	public void el_usuario_ingresa_sus_credenciales_pero_cancela_el_login() throws Throwable {
		findExpectativa("btnCancelar");
		ingresaruser(user);
		runevent.clickWait(By.cssSelector("p"));
		clickContinuar();
		ingresarPss(pss);
	}

	@Then("^el deberia retornar a la opcion de ingresa sus credenciales de usuario$")
	public void el_deberia_retornar_a_la_opcion_de_ingresa_sus_credenciales_de_usuario() throws Throwable {
		runevent.clickWait(By.cssSelector("p"));
		clickCancelar();
		tearDown();
	}

	private void validarmensajeerrorBloqueo(String message)throws Exception {
		Thread.sleep(1000);
		System.out.println("Validar Error");
		runevent.CompararTexto((By.className("alert-text")), message);
		
	}
	
	public void validarmensajeerror(String message) throws Exception {
		Thread.sleep(1000);
		System.out.println("Validar Error");
		runevent.CompararTexto((By.id("lbl-2")), message);
	}

	public void validarmensajetolltip(String message) throws Exception {
		Thread.sleep(1000);
		System.out.println("Validar Error");
		runevent.CompararTexto((By.tagName("tooltip-box")), message);
	}

	// @AfterMethod(alwaysRun = true)
	// @AfterTest(alwaysRun = true)
	// metodo para cerrar ventanas
	public void tearDown() {
		try {
			runevent.closeDriver();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void clickIngresar() {
//		runevent.clickWait(((WebDriver)runevent.getDriver()).findElements(By.name("marca-persona")).get(1));
		runevent.clickWait(By.id("btnLogin"));
	}

	private void ingresaruser(String user) {
//		runevent.sendKeys(By.id("inpUser"),user);
		runevent.clickWait(By.id("inpUser"));
		runevent.sendKeys(
				((WebDriver) runevent.getDriver()).findElement(By.id("inpUser")).findElement(By.cssSelector("input")),
				user);
//		runevent.sendKeys(By.id("inpUser"), user);
//		runevent.clickWait(By.id("inpUser"));

	}

	private void clickContinuar() {
//		((WebDriver)runevent.getDriver()).navigate().back();
		// runevent.clickWait(By.name("marca-persona"));
		runevent.clickWait(By.id("btnContinue"));
	}

	private void clickCancelar() {
//		runevent.clickWait(((WebDriver)runevent.getDriver()).findElements(By.name("marca-persona")).get(1));
		runevent.clickWait(By.id("btnCancel"));
	}

	private void clickContrasenaojo() {
//		((WebDriver)runevent.getDriver()).navigate().back();
		// runevent.clickWait(By.name("marca-persona"));
		runevent.clickWait(By.xpath(
				"//*[@id=\"tabpanel-t0-0\"]/page-login/ion-content/div[2]/card-login/div/ion-card[2]/text-field/div/ion-item/div[1]/button[1]"));
	}

	private void clickToolTipuser() {
//		((WebDriver)runevent.getDriver()).navigate().back();
		// runevent.clickWait(By.name("marca-persona"));
		runevent.clickWait(By.id("tooltipBtnUserId"));
	}

	private void clickToolTippass() {
//		((WebDriver)runevent.getDriver()).navigate().back();
		// runevent.clickWait(By.name("marca-persona"));
		runevent.clickWait(By.id("tooltipBtnPassId"));
	}

	private void clickChecbox() {
//		runevent.clickWait(((WebDriver)runevent.getDriver()).findElements(By.name("marca-persona")).get(1));
		runevent.clickWait(By.name("CheckBox"));
	}

	private void clickRecordar() {
//		runevent.clickWait(By.name("chk_recordar"));
		runevent.clickWait(By.id("chkRemember"));
	}

	private void ingresarPss(String pssword) {
		runevent.clickWait(By.id("inpPassword"));
		runevent.sendKeys(((WebDriver) runevent.getDriver()).findElement(By.id("inpPassword"))
				.findElement(By.cssSelector("input")), pssword);
//		runevent.sendKeys(By.id("inp_password"), pssword);
	}

	public void validaringreso() {
		// se debe cambiar
		runevent.clickWait(By.className("back-button"));
	}

	public void ingresarRecordandouser() throws IOException, InterruptedException {

		System.out.println("Set Up");

		String port = System.getProperty("port");
		if ((port == null) || (port.equals(""))) {
			port = "4723";
		}
		String url = System.getProperty("url");
		if ((port == null) || (port.equals(""))) {
			url = "";
		}
		String ip = System.getProperty("port");
		if ((ip == null) || (ip.equals(""))) {
			ip = "0.0.0.0";
		}
		String pack = System.getProperty("pack");
		if ((pack == null) || (pack.equals(""))) {
			pack = "com.banistmo.per.apl.appmobile";
		}
		String act = System.getProperty("act");
		if ((act == null) || (act.equals(""))) {
			act = "com.banistmo.per.apl.appmobile.MainActivity";
		}
		testtype = System.getProperty("testtype");
		if ((testtype == null) || (testtype.equals(""))) {
			testtype = "AWS";
		}
		// com.banistmo.ca.apr.app.personas/com.banistmo.ca.apr.app.personas.MainActivity}

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android"); // Nombre del sistema operativo

		capabilities.setCapability("appPackage", pack);

		capabilities.setCapability("appActivity", act);

		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("deviceName", "device");

		runevent = Utilidades.setDriverType(testtype);
		runevent.initDriver(capabilities, new URL("http://127.0.0.1:4723/wd/hub"), 90);
		runevent.setIp(ip);
		runevent.setPort(port);
		runevent.ingresarAlWebview("Ionic App");
		Thread.sleep(3000);
//		runevent.initDriver(pack, act, 10);
//		runevent.setCapturar(false);
	}

	// metodo que ha de ser prticular segun la HU , y la longitud de datos que esta
	// necesite
	public int findExpectativa(String expectativa) throws Exception {
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			argumentosAutenticacionMovil = runevent.leerFilaExcel(i, argumentosAutenticacionMovil.length, sheet);
			System.out.println("expectativa = " + expectativa + "Found = " + argumentosAutenticacionMovil[3]);
			if (argumentosAutenticacionMovil[3].equals(expectativa)) {
				user = argumentosAutenticacionMovil[0];
				pss = argumentosAutenticacionMovil[1];
				System.out.println("OK : " + user + " " + pss);
				return i;
			}
		}

		throw new Exception("Expectativa no encontrada");
	}
	public void indicarElementoEnabled(  By by,RunEvent runEvent,boolean estado) throws Exception
	{
		WebElement element  = ((WebDriver) runevent.driver).findElement(by);
		if (element.isEnabled()==estado)
		{
			 return;
		}else {
			throw new Exception(" elemento con estado incorrecto");

		}
	} 

}
