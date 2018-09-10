/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azercell.framework.pages;

import com.azercell.framework.common.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Mensur Owary
 */
public class Google extends Page{

    @FindBy(xpath="//*[@id=\"lst-ib\"]")
    private WebElement searchBar;
    
    @FindBy(xpath="//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")
    private WebElement searchBtn;
    
    public Google(WebDriver webdriver) {
        super(webdriver);
        this.webdriver.get("https://www.google.com/");
    }
    
    public WebDriver makeSearch(String str){
        this.typeToSearchbar(str);
        this.clickSearch();
        return webdriver;
    }
    
    private void typeToSearchbar(String search){
        this.searchBar.sendKeys(search);
    }
    
    private void clickSearch(){
        this.searchBtn.click();
    }
    


    
    
}
