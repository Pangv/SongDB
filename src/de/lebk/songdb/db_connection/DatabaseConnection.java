package de.lebk.songdb.db_connection;

import java.sql.*;

/**
 * @author sopaetzel
 */
public class DatabaseConnection {

    private static DatabaseConnection ourInstance = new DatabaseConnection();
    private static final String HOME_DIR = System.getProperty("user.dir");

    private Connection connection = null;
    private Statement statement = null;

    private String databaseName = "songdb";
    private String user = "root";
    private String password = "root";

    private String connectionString = "jdbc:h2:~/data/" + databaseName;


    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance(){
        return ourInstance;
    }

    public void getMetaInformation() throws SQLException {
        DatabaseMetaData metaData = this.connection.getMetaData();
    }


    public void openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection(connectionString, user, password);
    }

    public void closeConnection() throws SQLException{
        connection.close();
    }

    public Connection getConnection() {
        return connection;
    }









}
