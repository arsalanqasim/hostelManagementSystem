package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class writeSql {
    // JDBC URL, username, and password of MySQL server
    String jdbcURL = "jdbc:mysql://sql12.freesqldatabase.com:3306/";
    String username = "sql12672453";
    String password = "ykNU6XuszM";

    // Database name
    String databaseName = "sql12672453";

    public void writeHostelerLog(String uname, String pwd) {
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "INSERT INTO ulog (userName, password) VALUES (?, ?)";

            // Create a PreparedStatement object to execute the query
            PreparedStatement pstm = con.prepareStatement(sql);

            // Set values for the placeholders in the query
            pstm.setString(1, uname);
            pstm.setString(2, pwd);

            // Execute the query
            pstm.executeUpdate();

            // System.out.println("Data inserted successfully!");

            con.close();
            pstm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeHostelerInfo(String userName, String name, String age, String contact, String roomNumber,
            String email, String address) {
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "INSERT INTO uinfo (userName,name, age, contactNumber, roomNumber, email, address) VALUES (?, ?, ?, ?, ?, ?, ?)";

            // Create a PreparedStatement object to execute the query
            PreparedStatement pstm = con.prepareStatement(sql);

            // Set values for the placeholders in the query
            pstm.setString(1, userName);
            pstm.setString(2, name);
            pstm.setString(3, age);
            pstm.setString(4, contact);
            pstm.setString(5, roomNumber);
            pstm.setString(6, email);
            pstm.setString(7, address);

            // Execute the query
            pstm.executeUpdate();

            // System.out.println("Data inserted successfully!");

            con.close();
            pstm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeNofications(String notification) {
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "INSERT INTO notifications (notification) VALUES (?)";

            // Create a PreparedStatement object to execute the query
            PreparedStatement pstm = con.prepareStatement(sql);

            // Set values for the placeholders in the query
            pstm.setString(1, notification);

            // Execute the query
            pstm.executeUpdate();

            // System.out.println("Data inserted successfully!");

            con.close();
            pstm.close();

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public void writeServices(String uname, String asked) {
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            if (asked.equals("meal")) {
                String sql = "insert into services (userName, mealAsked, clothWash, roomClean) values(?, ?, ?, ?) on duplicate key update mealAsked = ?;";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, true);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (asked.equals("cloth")) {
                String sql = "insert into services (userName, mealAsked, clothWash, roomClean) values(?, ?, ?, ?) on duplicate key update clothWash = ?;";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, true);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (asked.equals("clean")) {
                String sql = "insert into services (userName, mealAsked, clothWash, roomClean) values(?, ?, ?, ?) on duplicate key update roomClean = ?;";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, true);
                pstm.setBoolean(5, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();
            }

            // System.out.println("Data inserted successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeRent(String uname, String month) {
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName,
                    username, password);

            if (month.equals("January")) {
                String sql = "INSERT INTO rent (userName, January, February, March, April, May, June, July, August, September, October, November, December) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE January = ?";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, true);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, false);
                pstm.setBoolean(6, false);
                pstm.setBoolean(7, false);
                pstm.setBoolean(8, false);
                pstm.setBoolean(9, false);
                pstm.setBoolean(10, false);
                pstm.setBoolean(11, false);
                pstm.setBoolean(12, false);
                pstm.setBoolean(13, false);
                pstm.setBoolean(14, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (month.equals("February")) {
                String sql = "INSERT INTO rent (userName, January, February, March, April, May, June, July, August, September, October, November, December) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE February = ?";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, true);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, false);
                pstm.setBoolean(6, false);
                pstm.setBoolean(7, false);
                pstm.setBoolean(8, false);
                pstm.setBoolean(9, false);
                pstm.setBoolean(10, false);
                pstm.setBoolean(11, false);
                pstm.setBoolean(12, false);
                pstm.setBoolean(13, false);
                pstm.setBoolean(14, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (month.equals("March")) {
                String sql = "INSERT INTO rent (userName, January, February, March, April, May, June, July, August, September, October, November, December) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE March = ?";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, true);
                pstm.setBoolean(5, false);
                pstm.setBoolean(6, false);
                pstm.setBoolean(7, false);
                pstm.setBoolean(8, false);
                pstm.setBoolean(9, false);
                pstm.setBoolean(10, false);
                pstm.setBoolean(11, false);
                pstm.setBoolean(12, false);
                pstm.setBoolean(13, false);
                pstm.setBoolean(14, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (month.equals("April")) {
                String sql = "INSERT INTO rent (userName, January, February, March, April, May, June, July, August, September, October, November, December) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE April = ?";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, true);
                pstm.setBoolean(6, false);
                pstm.setBoolean(7, false);
                pstm.setBoolean(8, false);
                pstm.setBoolean(9, false);
                pstm.setBoolean(10, false);
                pstm.setBoolean(11, false);
                pstm.setBoolean(12, false);
                pstm.setBoolean(13, false);
                pstm.setBoolean(14, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (month.equals("May")) {
                String sql = "INSERT INTO rent (userName, January, February, March, April, May, June, July, August, September, October, November, December) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE May = ?";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, false);
                pstm.setBoolean(6, true);
                pstm.setBoolean(7, false);
                pstm.setBoolean(8, false);
                pstm.setBoolean(9, false);
                pstm.setBoolean(10, false);
                pstm.setBoolean(11, false);
                pstm.setBoolean(12, false);
                pstm.setBoolean(13, false);
                pstm.setBoolean(14, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (month.equals("June")) {
                String sql = "INSERT INTO rent (userName, January, February, March, April, May, June, July, August, September, October, November, December) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE June = ?";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, false);
                pstm.setBoolean(6, false);
                pstm.setBoolean(7, true);
                pstm.setBoolean(8, false);
                pstm.setBoolean(9, false);
                pstm.setBoolean(10, false);
                pstm.setBoolean(11, false);
                pstm.setBoolean(12, false);
                pstm.setBoolean(13, false);
                pstm.setBoolean(14, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (month.equals("July")) {
                String sql = "INSERT INTO rent (userName, January, February, March, April, May, June, July, August, September, October, November, December) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE July = ?";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, false);
                pstm.setBoolean(6, false);
                pstm.setBoolean(7, false);
                pstm.setBoolean(8, true);
                pstm.setBoolean(9, false);
                pstm.setBoolean(10, false);
                pstm.setBoolean(11, false);
                pstm.setBoolean(12, false);
                pstm.setBoolean(13, false);
                pstm.setBoolean(14, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (month.equals("August")) {
                String sql = "INSERT INTO rent (userName, January, February, March, April, May, June, July, August, September, October, November, December) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE August = ?";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, false);
                pstm.setBoolean(6, false);
                pstm.setBoolean(7, false);
                pstm.setBoolean(8, false);
                pstm.setBoolean(9, true);
                pstm.setBoolean(10, false);
                pstm.setBoolean(11, false);
                pstm.setBoolean(12, false);
                pstm.setBoolean(13, false);
                pstm.setBoolean(14, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (month.equals("September")) {
                String sql = "INSERT INTO rent (userName, January, February, March, April, May, June, July, August, September, October, November, December) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE September = ?";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, false);
                pstm.setBoolean(6, false);
                pstm.setBoolean(7, false);
                pstm.setBoolean(8, false);
                pstm.setBoolean(9, false);
                pstm.setBoolean(10, true);
                pstm.setBoolean(11, false);
                pstm.setBoolean(12, false);
                pstm.setBoolean(13, false);
                pstm.setBoolean(14, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (month.equals("October")) {
                String sql = "INSERT INTO rent (userName, January, February, March, April, May, June, July, August, September, October, November, December) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE October = ?";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, false);
                pstm.setBoolean(6, false);
                pstm.setBoolean(7, false);
                pstm.setBoolean(8, false);
                pstm.setBoolean(9, false);
                pstm.setBoolean(10, false);
                pstm.setBoolean(11, true);
                pstm.setBoolean(12, false);
                pstm.setBoolean(13, false);
                pstm.setBoolean(14, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (month.equals("November")) {
                String sql = "INSERT INTO rent (userName, January, February, March, April, May, June, July, August, September, October, November, December) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE November = ?";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, false);
                pstm.setBoolean(6, false);
                pstm.setBoolean(7, false);
                pstm.setBoolean(8, false);
                pstm.setBoolean(9, false);
                pstm.setBoolean(10, false);
                pstm.setBoolean(11, false);
                pstm.setBoolean(12, true);
                pstm.setBoolean(13, false);
                pstm.setBoolean(14, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            } else if (month.equals("December")) {
                String sql = "INSERT INTO rent (userName, January, February, March, April, May, June, July, August, September, October, November, December) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE December = ?";

                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, uname);
                pstm.setBoolean(2, false);
                pstm.setBoolean(3, false);
                pstm.setBoolean(4, false);
                pstm.setBoolean(5, false);
                pstm.setBoolean(6, false);
                pstm.setBoolean(7, false);
                pstm.setBoolean(8, false);
                pstm.setBoolean(9, false);
                pstm.setBoolean(10, false);
                pstm.setBoolean(11, false);
                pstm.setBoolean(12, false);
                pstm.setBoolean(13, true);
                pstm.setBoolean(14, true);

                // Execute the query
                pstm.executeUpdate();
                pstm.close();

            }

            // System.out.println("Data inserted successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeComplains(String uname, String complain) {
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "INSERT INTO complains (userName, complain) VALUES (?, ?)";

            // Create a PreparedStatement object to execute the query
            PreparedStatement pstm = con.prepareStatement(sql);

            // Set values for the placeholders in the query
            pstm.setString(1, uname);
            pstm.setString(2, complain);

            // Execute the query
            pstm.executeUpdate();

            // System.out.println("Data inserted successfully!");

            con.close();
            pstm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeServices(String uname) {
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "DELETE FROM services WHERE userName = ?;";

            // Create a PreparedStatement object to execute the query
            PreparedStatement pstm = con.prepareStatement(sql);

            // Set values for the placeholders in the query
            pstm.setString(1, uname);

            // Execute the query
            pstm.executeUpdate();

            con.close();
            pstm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeRent(String uname) {
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "UPDATE rent SET January = FALSE, February = FALSE, March = FALSE, April = FALSE, May = FALSE, June = FALSE, July = FALSE, August = FALSE, September = FALSE, October = FALSE, November = FALSE, December = FALSE WHERE userName = ?;";

            // Create a PreparedStatement object to execute the query
            PreparedStatement pstm = con.prepareStatement(sql);

            // Set values for the placeholders in the query
            pstm.setString(1, uname);

            // Execute the query
            pstm.executeUpdate();

            con.close();
            pstm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeComplains(String uname) {
        try {
            // Establishing a connection to MySQL server
            Connection con = DriverManager.getConnection(jdbcURL + databaseName, username, password);

            // SQL query to insert data into the table
            String sql = "DELETE FROM complains WHERE complain = ?;";

            // Create a PreparedStatement object to execute the query
            PreparedStatement pstm = con.prepareStatement(sql);

            // Set values for the placeholders in the query
            pstm.setString(1, uname);

            // Execute the query
            pstm.executeUpdate();

            con.close();
            pstm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
