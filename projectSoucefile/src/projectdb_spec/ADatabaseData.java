/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdb_spec;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import oracle.net.aso.i;

public class ADatabaseData {

    private Statement st;

    public ADatabaseData(Statement st) {
        this.st = st;
    }

    public ResultSet getAllspec(String str) {
        try {
            String query = "select time , cpu ,vga , mb,price from PROJECTDB_SPEC.SPEC where spec.user_id = '" + str + "'";
            ResultSet rs = st.executeQuery(query);

            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public boolean login(String uid, String pass) {

        try {
            String query = "select * from PROJECTDB_SPEC.USER_SPEC where USER_SPEC.USER_ID = '" + uid + "' and USER_SPEC.USER_PASS ='" + pass + "'";
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public boolean register(String uid, String upass, String cpass, String uname) throws
            SQLException {
        int i = -1;
        if ((upass.equals(cpass))) {
            i = st.executeUpdate("insert into PROJECTDB_SPEC.USER_SPEC values ('" + uid + "', '" + uname + "','" + upass + "')");
        } else {
            JOptionPane.showMessageDialog(null, "password incorrect");
        }
        System.out.print(i);
        if (i > -1) {
            return true;
        } else {
            return false;
        }
    }

    public ResultSet getData(String str) {
        try {
            String query = "select * from PROJECTDB_SPEC." + str;
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public boolean addspec(String uid, String cpu, String mb, String ram, String vga, String m2, String ssd, String hdd, String psu, String Case, String monitor, String cooler, int price) throws
            SQLException {

        System.out.println("insert into PROJECTDB_SPEC.SPEC values ('" + uid + "','','','" + price + "','" + cpu + "','" + vga + "','" + ram + "','" + mb + "','" + Case + "','" + hdd + "','" + ssd + "','" + m2 + "','" + psu + "','" + cooler + "','" + monitor + "')");
        int i = st.executeUpdate("insert into PROJECTDB_SPEC.SPEC values ('" + uid + "','','','" + price + "','" + cpu + "','" + vga + "','" + ram + "','" + mb + "','" + Case + "','" + hdd + "','" + ssd + "','" + m2 + "','" + psu + "','" + cooler + "','" + monitor + "')");

        if (i > -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deletespec(String id, String date) throws SQLException {

        boolean i = st.execute("DELETE FROM PROJECTDB_SPEC.SPEC WHERE USER_ID ='" + id + "' AND TIME='" + date + "'");
        return i;
    }

    public ResultSet getID(String id, String date) {
        try {
            String query = "select SPEC_ID from PROJECTDB_SPEC.SPEC where spec.user_id = '" + id + "' and spec.TIME = '" + date + "'";
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public ResultSet getspec(String str) {
        try {
            String query = "select * from PROJECTDB_SPEC.SPEC where spec.spec_id = '" + str + "'";
            ResultSet rs = st.executeQuery(query);

            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public ResultSet getImage(String qry) {
        try {
            String query = qry;
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    
      public ResultSet getWhere(String qry) {
        try {
            String query = qry;
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    

    public boolean Udatespec(String specid, String cpu, String mb, String ram, String vga, String m2, String ssd, String hdd, String psu, String Case, String monitor, String cooler, int price) throws
            SQLException {
              String Q=("update PROJECTDB_SPEC.SPEC set "
                + "CPU  = (select CPU_NAME from CPU where CPU_name = '"+cpu + "'),"
                + "VGA  = (select VGA_NAME from VGA where VGA_name = '" + vga + "'),"
                + "RAM  = (select RAM_NAME from RAM where RAM_name = '" + ram + "'),"
                + "MB   = (select MB_NAME from MB where MB_name = '" + mb + "'),"
                + "CASE = (select C_NAME from CASE where C_name = '" + Case + "'),"
                + "HDD  = (select HDD_NAME from HDD where HDD_name = '" + hdd + "'),"
                + "SSD  = (select SSD_NAME from SSD where ssd_name = '" + ssd + "'),"
                + "M2   = (select M2_NAME from M2 where M2_name = '" + m2 + "'),"
                + "PSU  = (select PSU_NAME from PSU where PSU_name = '" + psu + "'),"
                + "COOLER =(select CO_NAME from COOLER where Co_name = '" + cooler + "'),"
                + "MONITOR = (select MO_NAME from MONITOr where MO_name = '" + monitor + "'),"
                + "price =" + price + "   where  SPEC_ID='"+specid +"'");
        
        
        
         System.out.println("update PROJECTDB_SPEC.SPEC set PROJECTDB_SPEC.SPEC.VGA = (select VGA.VGA_NAME from PROJECTDB_SPEC.VAG where VGA.VGA_name = '"+vga+"')  where  SPEC_ID='"+specid+"'");
        
        
        

        int i = st.executeUpdate("update PROJECTDB_SPEC.SPEC set PROJECTDB_SPEC.SPEC.CPU = (select CPU.CPU_NAME from PROJECTDB_SPEC.CPU where CPU.CPU_name = '"+cpu+"')  where  SPEC_ID='"+specid+"'");   
            i = st.executeUpdate("update PROJECTDB_SPEC.SPEC set PROJECTDB_SPEC.SPEC.VGA = (select VGA.VGA_NAME from PROJECTDB_SPEC.VGA where VGA.VGA_name = '"+vga+"')  where  SPEC_ID='"+specid+"'");
            i = st.executeUpdate("update PROJECTDB_SPEC.SPEC set PROJECTDB_SPEC.SPEC.MB = (select MB.MB_NAME from PROJECTDB_SPEC.MB where MB.MB_name = '"+mb+"')  where  SPEC_ID='"+specid+"'");
            i = st.executeUpdate("update PROJECTDB_SPEC.SPEC set PROJECTDB_SPEC.SPEC.RAM = (select RAM.RAM_NAME from PROJECTDB_SPEC.RAM where RAM.RAM_name = '"+ram+"')  where  SPEC_ID='"+specid+"'");
            i = st.executeUpdate("update PROJECTDB_SPEC.SPEC set PROJECTDB_SPEC.SPEC.M2 = (select M2.M2_NAME from PROJECTDB_SPEC.M2 where M2.M2_name = '"+m2+"')  where  SPEC_ID='"+specid+"'"); 
            i = st.executeUpdate("update PROJECTDB_SPEC.SPEC set PROJECTDB_SPEC.SPEC.PSU = (select PSU.PSU_NAME from PROJECTDB_SPEC.PSU where PSU.PSU_name = '"+psu+"')  where  SPEC_ID='"+specid+"'");
            i = st.executeUpdate("update PROJECTDB_SPEC.SPEC set PROJECTDB_SPEC.SPEC.SSD = (select SSD.SSD_NAME from PROJECTDB_SPEC.SSD where SSD.SSD_name = '"+ssd+"')  where  SPEC_ID='"+specid+"'");  
            i = st.executeUpdate("update PROJECTDB_SPEC.SPEC set PROJECTDB_SPEC.SPEC.CASE = (select CASE.C_NAME from PROJECTDB_SPEC.CASE where CASE.C_name = '"+Case+"')  where  SPEC_ID='"+specid+"'");   
            i = st.executeUpdate("update PROJECTDB_SPEC.SPEC set PROJECTDB_SPEC.SPEC.COOLER = (select COOLER.CO_NAME from PROJECTDB_SPEC.COOLER where COOLER.CO_name = '"+cooler+"')  where  SPEC_ID='"+specid+"'");   
            i = st.executeUpdate("update PROJECTDB_SPEC.SPEC set PROJECTDB_SPEC.SPEC.MONITOR = (select MONITOR.MO_NAME from PROJECTDB_SPEC.MONITOR where MONITOR.MO_name = '"+monitor+"')  where  SPEC_ID='"+specid+"'");   
            i = st.executeUpdate("update PROJECTDB_SPEC.SPEC set PROJECTDB_SPEC.SPEC.HDD = (select HDD.HDD_NAME from PROJECTDB_SPEC.HDD where HDD.HDD_name = '"+hdd+"')  where  SPEC_ID='"+specid+"'");   

            if (i > -1) {
            return true;
        } else {
            return false;
        }

    }
}
