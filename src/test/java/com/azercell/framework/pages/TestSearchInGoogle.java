/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azercell.framework.pages;

import com.azercell.framework.common.PageTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Mensur Owary
 */
public class TestSearchInGoogle extends PageTest{
    
    @Test
    public void search(){
        Google google = new Google(this.webdriver);
        assertTrue(google.makeSearch("Day").getTitle().contains("Day"));
    }
    
    
}
