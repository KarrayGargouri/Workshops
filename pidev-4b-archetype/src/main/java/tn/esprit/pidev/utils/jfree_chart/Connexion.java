package tn.esprit.pidev.utils.jfree_chart;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.util.Vector;

/**
 *
 * @author sana
 */
public class Connexion {
Connection con;
static  Statement st;
public static ResultSet rs;
static Connexion CON;


public Connexion(){
 try {
                    Class.forName("org.gjt.mm.mysql.Driver");

                } catch (Exception E) {
                    System.out.println("Pas de pilote !");
                }
                        try {
                String url = "jdbc:mysql://localhost/esprit";
                con = DriverManager.getConnection(url, "root", "");

                   st = con.createStatement();
            } catch (SQLException E) {
                System.err.println(E.getMessage());
            }
       

}











}
