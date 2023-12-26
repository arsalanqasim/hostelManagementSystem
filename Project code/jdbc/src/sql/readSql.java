package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class readSql {
    // JDBC URL, username, and password of MySQL server
    String jdbcURL = "jdbc:mysql://sql12.freesqldatabase.com:3306/";
    String username = "sql12672453";
    String password = "ykNU6XuszM";

    // Database name
    String databaseName = "sql12672453";

    public String[] readinfo(String userName) {
        String[] info = new String[6];
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to read data from the table
            String sql = "select * from uinfo where userName = '" + userName + "'";

            // Create a PreparedStatement object to execute the query
            Statement stm = con.createStatement();

            // Execute the query
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                info[0] = rs.getString(2);
                info[1] = Integer.toString(rs.getInt(3));
                info[2] = rs.getString(4);
                info[3] = Integer.toString(rs.getInt(5));
                info[4] = rs.getString(6);
                info[5] = rs.getString(7);
            }

            // System.out.println("read successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    // takes Username and Password. If username and pwd are correct its reutrns true
    // otherwise false
    public boolean readlog(String uname, String pwd) {
        boolean check = false;
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "select * from ulog WHERE userName = '" + uname + "'";

            // Create a PreparedStatement object to execute the query
            Statement stm = con.createStatement();

            // Execute the query
            ResultSet rs = stm.executeQuery(sql);
            String realUname = "", realpwd = "";
            while (rs.next()) {
                realUname = rs.getString(1);
                realpwd = rs.getString(2);
            }
            if ((realUname.equals(uname)) && realpwd.equals(pwd)) {
                check = true;
            }
            con.close();
            // System.out.println("read successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }

    // takes Username and checks if username is in database or not
    public boolean readlog(String uname) {
        boolean check = false;
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "select userName from ulog";

            // Create a PreparedStatement object to execute the query
            Statement stm = con.createStatement();

            // Execute the query
            ResultSet rs = stm.executeQuery(sql);
            String realUname = "";
            while (rs.next()) {
                realUname = rs.getString(1);
                if (realUname.equals(uname)) {
                    check = true;
                }
            }
            con.close();
            // System.out.println("read successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }

    public String[][] readServices() {
        int num = 0;
        try {
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            String sql = "select count(*) row_count from services";

            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                num = rs.getInt(1);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[][] data = new String[num][4];
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "SELECT userName, CASE WHEN mealAsked = TRUE THEN 'meal' ELSE NULL END AS meal_status, CASE WHEN clothWash = TRUE THEN 'cloth' ELSE NULL END AS cloth_status, CASE WHEN roomClean = TRUE THEN 'clean' ELSE NULL END AS clean_status FROM services WHERE mealAsked = TRUE OR clothWash = TRUE OR roomClean = TRUE;";
            // String sql = "select * from services";

            // Create a PreparedStatement object to execute the query
            Statement stm = con.createStatement();

            // Execute the query
            ResultSet rs = stm.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4);
                i++;
            }
            con.close();
            // System.out.println("read successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public String[][] readRent() {
        int num = 0;
        try {
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            String sql = "select count(*) row_count from rent";

            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                num = rs.getInt(1);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[][] data = new String[num][13];
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "SELECT userName, CASE WHEN January = TRUE THEN 'January' ELSE NULL END AS January_status, CASE WHEN February = TRUE THEN 'February' ELSE NULL END AS February_status, CASE WHEN March = TRUE THEN 'March' ELSE NULL END AS March_status, CASE WHEN April = TRUE THEN 'April' ELSE NULL END AS April_status, CASE WHEN May = TRUE THEN 'May' ELSE NULL END AS May_status, CASE WHEN June = TRUE THEN 'June' ELSE NULL END AS June_status, CASE WHEN July = TRUE THEN 'July' ELSE NULL END AS July_status, CASE WHEN August = TRUE THEN 'August' ELSE NULL END AS August_status, CASE WHEN September = TRUE THEN 'September' ELSE NULL END AS September_status, CASE WHEN October = TRUE THEN 'October' ELSE NULL END AS October_status, CASE WHEN November = TRUE THEN 'November' ELSE NULL END AS November_status, CASE WHEN December = TRUE THEN 'December' ELSE NULL END AS December_status FROM rent WHERE January = TRUE OR February = TRUE OR March = TRUE OR April = TRUE OR May = TRUE OR June = TRUE OR July = TRUE OR August = TRUE OR September = TRUE OR October = TRUE OR November = TRUE OR December = TRUE;";
            // String sql = "select * from services";

            // Create a PreparedStatement object to execute the query
            Statement stm = con.createStatement();

            // Execute the query
            ResultSet rs = stm.executeQuery(sql);
            // String realUname = "", realpwd = "";
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);
                data[i][7] = rs.getString(8);
                data[i][8] = rs.getString(9);
                data[i][9] = rs.getString(10);
                data[i][10] = rs.getString(11);
                data[i][11] = rs.getString(12);
                data[i][12] = rs.getString(13);
                i++;
            }
            con.close();
            // System.out.println("read successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public String[][] readComplains() {
        int num = 0;
        try {
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            String sql = "select count(*) row_count from complains";

            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                num = rs.getInt(1);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[][] data = new String[num][2];
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "select * from complains";

            // Create a PreparedStatement object to execute the query
            Statement stm = con.createStatement();

            // Execute the query
            ResultSet rs = stm.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                i++;
            }
            con.close();
            // System.out.println("read successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public String[] readNotification() {
        int num = 0;
        try {
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            String sql = "select count(*) row_count from notifications";

            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                num = rs.getInt(1);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] data = new String[num];
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "select * from notifications";

            // Create a PreparedStatement object to execute the query
            Statement stm = con.createStatement();

            // Execute the query
            ResultSet rs = stm.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                data[i] = rs.getString(2);
                i++;
            }
            con.close();
            // System.out.println("read successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
