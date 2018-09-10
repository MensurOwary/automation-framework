/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azercell.framework.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Mensur Owary
 */
public class CSVExtractor {
    
    public static Object[][] getData(Class c, String path){
        Object[][] arr = null;
        InputStream input = c.getClassLoader().getResourceAsStream(path);
        try(BufferedReader buffer = new BufferedReader(new InputStreamReader(input))){
            List<Object[]> collect = buffer.lines().skip(1).map(el->el.split(",")).collect(Collectors.toList());
            arr = new Object[collect.size()][collect.get(0).length];
            for(int i=0;i<arr.length;i++){
                arr[i] = collect.get(i);
            }
        }catch(Exception e){
            
        }
        return arr;
    }
    
}
