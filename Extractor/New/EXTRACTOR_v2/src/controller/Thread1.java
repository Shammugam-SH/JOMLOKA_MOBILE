/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Bean.ERRCOUNT;
import Config_Pack.Config;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.MainExtractor;

/**
 *
 * @author umarmukhtar
 */
public class Thread1 implements Runnable {

    public static boolean status = true;
    //long sleep = 1000 * 60 * 1;
    long sleep = 7000;
    
    public Thread1(String host, int port) {
        Config.ipAddressServer = host;
        Config.portServer = port;
    }
    
    public void run() {
        
        while (status) {
            
            try {
                System.out.println("*************************");
                Date date1 = new Date();
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                System.out.println("["+sdf1.format(date1)+"] Extracting ...");
                
                ERRCOUNT.setLog();
                MainExtractor me = new MainExtractor();
                me.extract();
                
                Date date2 = new Date();
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                System.out.println("["+sdf2.format(date2)+"] Done.");
                System.out.println("*************************");
                System.out.println(" ");
                Thread.sleep(sleep);
                
            } catch (Exception ex) {
                System.out.println("Error: "+ex.getMessage());
                status = false;
            }
        }
    }
    
}
