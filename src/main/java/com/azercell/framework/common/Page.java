/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azercell.framework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Mensur Owary
 */
public class Page {
    
    protected WebDriver webdriver;
    protected WebDriverWait wait;
    
    public Page(WebDriver webdriver){
        this.webdriver = webdriver;
        this.wait = new WebDriverWait(webdriver, 10);
        PageFactory.initElements(webdriver, this);
    }
    
}
