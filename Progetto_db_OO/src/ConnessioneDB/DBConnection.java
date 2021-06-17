package ConnessioneDB;

	
    import java.sql.PreparedStatement;


    import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.sql.DatabaseMetaData;
	import java.sql.ResultSet;

	public class DBConnection {

	    

//	    private final String USERNAME = "postgres";
//	    private final String PASSWORD = "";
//	    private final String IP = "localhost";
//	    private final String PORT = "5432";
//	    private String url = "jdbc:postgresql://"+IP+":"+PORT+"/postgres";
	    
		private static DBConnection instance;
		private static Connection connection = null;
		
		private String strSshUser = "Progetto_oo_db"; // SSH loging username
		private String strSshPassword = "Progetto_oo_db"; // SSH login password
		private String strSshHost = "dnsobject.ddns.net"; // hostname or ip or SSH server
		private int nSshPort = 22; // remote SSH host port number
		private String strRemoteHost = "localhost"; // hostname or ip of your database server
		private int nLocalPort = 5433; // local port number use to bind SSH tunnel
		private int nRemotePort = 5432; // remote port number of your database
		private String strDbUser = "postgres"; // database loging username
		private String strDbPassword = ""; // database login password

	    
//	    public static void main(String[] args) 2
//	    	
//	    	DBConnection connessione = (DBConnection) getConnection(); 
//	       System.out.println("Connesso correttamente ");	
//	    
//	    }
	    
	    
	    private DBConnection() throws SQLException
		{
	        //Properties props = new Properties();
	        //props.setProperty("user", USERNAME);
	        //props.setProperty("pwd", PASSWORD);

	        try
	        {
//				System.out.println("try inizio");
//	            Class.forName("org.postgresql.Driver");
//	            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
	        	
	        	doSshTunnel(strSshUser, strSshPassword, strSshHost, nSshPort, strRemoteHost, nLocalPort, nRemotePort);

	        	Class.forName("org.postgresql.Driver");
	        	connection = DriverManager.getConnection("jdbc:postgresql://localhost:"+nLocalPort + "/", strDbUser,  strDbPassword );
	        	//connection.close();
	   
				System.out.println("try fine");
	        }
			catch ( JSchException exx )
			{
				System.out.println("Database SSH Connection Creation Failed :" + exx.getMessage() );
				exx.getStackTrace();
				
			}
	        catch (ClassNotFoundException ex)
	        {
	            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
	        }  
	        catch (SQLException e)
	        {
	            System.out.println("Database Connection Creation Failed (SQL EXCEPTION) : " + e.getMessage());
	        }


	    }

	    public Connection getConnection() {
	        return connection;
	    }

	    public static DBConnection getInstance() throws SQLException {
	        if (instance == null)
	        {	
				System.out.println("getInstance tt ok");
	            instance = new DBConnection();
	        }
	        else
	            if (instance.getConnection().isClosed())
	            {
					System.out.println("istanza chiusa tt ok");
	                instance = new DBConnection();
	            }

	        return instance;
	    }
	    
	    private static void doSshTunnel( String strSshUser, String strSshPassword, String strSshHost, int nSshPort, String strRemoteHost, int nLocalPort, int nRemotePort ) throws JSchException
		{
			final JSch jsch = new JSch();
			Session session = jsch.getSession( strSshUser, strSshHost, 22 );
			session.setPassword( strSshPassword );
	
			final Properties config = new Properties();
			config.put( "StrictHostKeyChecking", "no" );
			session.setConfig( config );
	
			session.connect();
			session.setPortForwardingL(nLocalPort, strRemoteHost, nRemotePort);
		} 
	    
	    
	    
	    
	    

}
