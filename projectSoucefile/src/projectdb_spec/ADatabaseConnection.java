/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdb_spec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ADatabaseConnection {

    private Connection myDBCon;
    private Statement st;

    public ADatabaseConnection() {
    }

    public void connectDB() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find class oracle.jdbc.driver.OracleDriver");
            System.exit(1);
        }
        try {
            
            myDBCon
                    = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                            "system", "1234");
            st = myDBCon.createStatement();
            System.out.println("Connected success");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }
    
    public void setSt(Statement st) {
        this.st=st;
    
    }
    public Statement getSt(){
      return st;
    }
    
    public void setmyDBCon(Connection myDBCon) {
        this.myDBCon=myDBCon;

    
    }
    public Connection getmyDBCon(){
      return myDBCon;
    }
    

}
