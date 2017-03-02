package de.lebk.songdb.db_connection;

import java.sql.*;

/**
 * @author sopaetzel
 */
public class DatabaseConnection {

    private static DatabaseConnection ourInstance = new DatabaseConnection();

    private Connection connection = null;

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

        String[] types = { "TABLE"};

        ResultSet metaRS = metaData.getTables(null, null, "%", types);

        while (metaRS.next()) {
            System.out.println("Meta-Information: ");
            System.out.println("==============\n");
            // Catalog
            String tableCatalog = metaRS.getString(1);
            System.out.println("Catalog: " + tableCatalog);

            // Schemata
            String tableSchema = metaRS.getString(2);
            System.out.println("Tabellen-Schema: " + tableSchema);

            // Tabellennamen
            String tableName = metaRS.getString(3);
            System.out.println("Tabellen-Name: " + tableName);

            // Tabellentyp
            String tableType = metaRS.getString(4);
            System.out.println("Tabellen-Typ: " + tableType + "\n");
        }
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
