package tbusService;
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

import entities.traveler; 

import java.sql.*; 
import java.util.ArrayList;

@Path("/db/") 
public class API_DB implements DB { 

	//public static final String URL = "http://www.db4free.net/phpMyAdmin/index.php?token=03ade7ffd1fba76df9bb9197fbd8cf4e#PMAURL-0:index.php?db=&table=&server=1&target=&token=03ade7ffd1fba76df9bb9197fbd8cf4e"; 
	//public static final String URL = "jdbc:mysql://www.db4free.net:3307/tbusdatabase";
	public static final String URL = "jdbc:mysql://db4free.net:3307/tbusdatabase";
	public static final String USER = "pinshai"; 
	public static final String PASSWORD = "0528768200";

	/*private static Connection getConnection() throws Exception { 
		Class.forName("com.mysql.jdbc.Driver"); 
		return DriverManager.getConnection(URL, USER, PASSWORD); 
	} */
	
	private  Connection getConnection() throws Exception { 
		Class.forName("com.mysql.jdbc.Driver"); 
		return (Connection) DriverManager.getConnection(URL, USER, PASSWORD); 
	}
	
	@Path("/AddTraveling") 
	@POST 
	@Produces(MediaType.TEXT_PLAIN) 
	@Consumes(MediaType.APPLICATION_JSON) 
	public String AddTraveling(traveler travel) throws Exception { 

		PreparedStatement query = null; 
		String returnString = null; 
		Connection conn = null; 

		try { 
			conn = getConnection(); 
			// "INSERT INTO Traveler(name,phoneNum,mail,numOfpassengers,exitNeighborhood,exitStreet,exitNumOfBuilding,destNeighborhood,destStreet,destNumOfBuilding,time,exitDate) VALUES (@name,@phoneNum,@mail,@numOfpassengers,@exitNeighborhood,@exitStreet,@exitNumOfBuilding,@destNeighborhood,@destStreet,@destNumOfBuilding,@time,@exitDate)"
			query = conn.prepareStatement("INSERT INTO " + SQLNAME.TABLE_TRAVELER + "(name,phoneNum,mail,numOfpassengers,exitNeighborhood,exitStreet,exitNumOfBuilding,destNeighborhood,destStreet,destNumOfBuilding,time,exitDate)" 
					+ " VALUES ('" + travel.getName() + "', '" 
					+ travel.getPhoneNum() + "', '" + travel.getMail() 
					+ "', '" + travel.getNumOfpassengers() + "','" + travel.getExitNeighborhood()
					+ "', '" + travel.getExitStreet() + "','" + travel.getExitNumOfBuilding()
					+ "', '" + travel.getDestNeighborhood() + "','" + travel.getDestStreet() + "','" + travel.getDestNumOfBuilding()
					+ "', '" + travel.getTime() + "','" + travel.getExitDate()
					+ "')"); 
			query.executeUpdate(); 
			returnString = "success"; 
			query.close();  

		} catch (Exception e) { 
			e.printStackTrace(); 
			returnString = e.getMessage(); 
		} 

		finally { 
			if (conn != null) 
				conn.close(); 
		} 

		return returnString; 
	} 

	
/*	@Path("/AddTravelingDetailed") 
	@POST 
	@Produces(MediaType.TEXT_PLAIN) 
	@Consumes(MediaType.APPLICATION_JSON) 
	public String AddTravelingDetailed(String name, String phoneNum, String mail, int numOfpassengers, 
			String exitNeighborhood, String exitStreet, int exitNumOfBuilding, 
			String destNeighborhood, String destStreet, int destNumOfBuilding, 
			String time, String exitDate) throws Exception { 

		PreparedStatement query = null; 
		String returnString = null; 
		Connection conn = null; 

		try { 
			conn = getConnection(); 
			// "INSERT INTO Traveler(name,phoneNum,mail,numOfpassengers,exitNeighborhood,exitStreet,exitNumOfBuilding,destNeighborhood,destStreet,destNumOfBuilding,time,exitDate) VALUES (@name,@phoneNum,@mail,@numOfpassengers,@exitNeighborhood,@exitStreet,@exitNumOfBuilding,@destNeighborhood,@destStreet,@destNumOfBuilding,@time,@exitDate)"
			query = conn.prepareStatement("INSERT INTO " + SQLNAME.TABLE_TRAVELER 
					+ " VALUES ('" + name + "', '" + phoneNum + "', '" + mail 
					+ "', '" + numOfpassengers
					+ "','" + exitNeighborhood + "', '" + exitStreet + "','" + exitNumOfBuilding
					+ "', '" + destNeighborhood + "','" + destStreet + "','" + destNumOfBuilding
					+ "', '" + time + "','" + exitDate
					+ "')"); 
			query.executeUpdate(); 
			returnString = "success"; 
			query.close();  

		} catch (Exception e) { 
			e.printStackTrace(); 
			returnString = e.getMessage(); 
		} 

		finally { 
			if (conn != null) 
				conn.close(); 
		} 

		return returnString; 
	} 
*/
	
	@Override
	@Path("/getTravelersList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<traveler> getTravelersList() throws Exception {
		ArrayList<traveler> travelersList = new ArrayList<traveler>();
		PreparedStatement query = null;
		Connection conn = null;
		try
		{
			conn = getConnection();
			query = conn.prepareStatement("SELECT * FROM "
					+ SQLNAME.TABLE_TRAVELER);
			ResultSet rs = query.executeQuery();

			while (rs.next())
			{
				traveler t = new traveler(rs.getString(SQLNAME.KEY_TRAVELER_NAME), 
						rs.getString(SQLNAME.KEY_TRAVELER_NUMBER), rs.getString(SQLNAME.KEY_TRAVELER_MAIL), 
						rs.getInt(SQLNAME.KEY_TRAVELER_NUMOFPASSENGERS), rs.getString(SQLNAME.KEY_TRAVELER_EXIT_NEIGHBORHOOD), 
						rs.getString(SQLNAME.KEY_TRAVELER_EXIT_STREET), rs.getInt(SQLNAME.KEY_TRAVELER_EXIT_NUM_OF_BUILDING), 
						rs.getString(SQLNAME.KEY_TRAVELER_DEST_NEIGHBORHOOD), rs.getString(SQLNAME.KEY_TRAVELER_DEST_STREET), rs.getInt(SQLNAME.KEY_TRAVELER_DEST_NUM_OF_BUILDING), 
						rs.getString(SQLNAME.KEY_TRAVELER_TIME), rs.getString(SQLNAME.KEY_TRAVELER_EXIT_DATE));
				//long careId = rs.getLong(SQLNAME.ID);
				
				travelersList.add(t);
			}
			query.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			if (conn != null)
				conn.close();
		}
		return travelersList;
	}

} 


