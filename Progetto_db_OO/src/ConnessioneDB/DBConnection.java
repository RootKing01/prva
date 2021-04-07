package ConnessioneDB;

	
    import java.sql.PreparedStatement;


    import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.sql.DatabaseMetaData;
	import java.sql.ResultSet;

	public class DBConnection {

	    private static DBConnection instance;
	    private static Connection connection = null;
	    private final String USERNAME = "postgres";
	    private final String PASSWORD = "Database12";
	    private final String IP = "localhost";
	    private final String PORT = "5432";
	    private String url = "jdbc:postgresql://"+IP+":"+PORT+"/postgres";

	      
//	    public static void main(String[] args) {
//	    	
//	    	DBConnection connessione = (DBConnection) getConnection(); 
//	       System.out.println("Connesso correttamente ");	
//	    
//	    }
	    
	    
	     private DBConnection() throws SQLException {
	        //Properties props = new Properties();
	        //props.setProperty("user", USERNAME);
	        //props.setProperty("pwd", PASSWORD);

	        try
	        {
				System.out.println("try inizio");
	            Class.forName("org.postgresql.Driver");
	            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
				System.out.println("try fine");
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

}
