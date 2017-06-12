package components;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.Commands;

public class Kabum {
	
	private Commands cmd = new Commands();
	private ThreadLocalRandom tlr = ThreadLocalRandom.current();
	
	public void navegate(WebDriver driver){
		driver.get("http://www.kabum.com.br/");
	}
	
	public void searchProd(WebDriver driver, String buscar) throws Exception{
		cmd.insertText(driver, By.xpath("//input[@class='sprocura']"), buscar);
		Thread.sleep(5000);
		cmd.pressKey(driver,Keys.ENTER);
	}
	
	public void goToElementAndClick(WebDriver driver) throws Exception{
		int prod = tlr.nextInt(0, 15);
		String xpath = "(//div[@class='listagem-box'])[" + prod + "]";
		cmd.moveToElement(driver, By.xpath(xpath));
		cmd.click(driver, By.xpath(xpath+"//a"));
	}
	
	public void checkInfoProd(WebDriver driver) throws Exception{
		//Verificar se o titulo aparece
		cmd.isDisplayed(driver, By.xpath("//h1[@class='titulo_det']"));
		//Produto disponível está na tela
		cmd.isDisplayed(driver, By.xpath("//img[contains(@alt, 'produto_disponivel')]"));
		//Btn Comprar
		cmd.isDisplayed(driver, By.xpath("(//p[@class='bot_comprar'])[1]"));
		//Existe os precos
		cmd.isDisplayed(driver, By.xpath("//div[@class='box_preco']"));
		//Descrição do produto
		cmd.isDisplayed(driver, By.xpath("//span[@class='titulo_menu_desc' and contains(.,'DESCRIÇÃO DO PRODUTO')]"));
	}
	
	public void insertToCart(WebDriver driver) throws Exception{
		cmd.click(driver, By.xpath("(//p[@class='bot_comprar'])[1]"));
	}
	
	public void checkInfoCart(WebDriver driver) throws Exception{
		//Verficar se está no carrinho de compras
		cmd.isDisplayed(driver, By.xpath("//div[text()='CARRINHO DE COMPRAS']"));
		//Verificar se existe a tabela do produt
		cmd.moveToElement(driver, By.xpath("//div[@class='carrinhoTabela']"));
		cmd.isDisplayed(driver, By.xpath("//div[@class='carrinhoTabela']"));
		//Ir ate tabela de preços
		cmd.moveToElement(driver, By.xpath("//div[@class='carrinho-valores-total']"));
	}
	
	public void removeProd(WebDriver driver) throws Exception{
		cmd.click(driver, By.xpath("//div[@class='carrinho-limpar']//a"));
		driver.switchTo().alert().accept();
//		cmd.pressKey(driver,Keys.ENTER);
	}
	
	public void checkInfoCartClear(WebDriver driver) throws Exception{
		//verificar se está no carrinho
		cmd.isDisplayed(driver, By.xpath("//div[text()='CARRINHO DE COMPRAS']"));
		//verificar se o carrinho está vazio 
		cmd.isDisplayed(driver, By.xpath("//h4[text()='SEU CARRINHO ESTÁ VAZIO']"));
	}
	
	public void goToHome(WebDriver driver) throws Exception{
		cmd.click(driver, By.xpath("//div[@id='header_logo']//a"));
	}
	
}
