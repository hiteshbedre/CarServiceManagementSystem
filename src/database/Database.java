package database;

import java.sql.Connection;
import java.sql.DriverManager;

import panes.LoginPane;

/**
 * @author James DiNovo
 * @date 24.10.2018
 * @version 1.0
 * 
 * The Database class is a singleton class that represents our database connection
 */
public class Database {
	//create private instance variable
	private static Database instance = null;
	private Connection connection = null;
	//create private constructor
	private Database() {
		if(connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://" + DBConst.getDbHost() + "/" + DBConst.getDbName() + "?useSSL=false", DBConst.getDbUser(), DBConst.getDbPass());
				System.out.println("Successfully Created Connection");
			} catch(Exception e) {
				e.printStackTrace();

			}

		}
	}

	/**
	 * @author James DiNovo
	 * @date 24.10.2018
	 * @param
	 * @version 1.0
	 * @return instance
	 *
	 * gets the single instance of the database connection
	 * if there isnt an instance, it will create a new one
	 */
	public static Database getInstance() {
		if(instance == null) {
			instance = new Database();
		}
		return instance;
	}

	/**
	 * @author James DiNovo
	 * @date 24.10.2018
	 * @param
	 * @version 1.0
	 * @return connection
	 *
	 * gets the database connection
	 */
	public Connection getConnection() {
		return connection;
	}
}
