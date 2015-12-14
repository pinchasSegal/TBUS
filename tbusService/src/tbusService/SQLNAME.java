package tbusService; 
 
public class SQLNAME{ 
  
 public static final int DATABASE_VERSION = 1; 
 
 public static final String DATABASE_NAME = "tbusdatabase"; 
  
 public static final String TABLE_TRAVELER = "Traveler";
 public static final String TABLE_COLUMNS = "(name,phoneNum,mail,numOfpassengers,exitNeighborhood,exitStreet,exitNumOfBuilding,destNeighborhood,destStreet,destNumOfBuilding,time,exitDate)";
 
 public static final String KEY_TRAVELER_NAME = "name"; 
 public static final String KEY_TRAVELER_NUMBER = "phoneNum"; 
 public static final String KEY_TRAVELER_MAIL = "mail"; 
 public static final String KEY_TRAVELER_NUMOFPASSENGERS = "numOfpassengers"; 
 public static final String KEY_TRAVELER_EXIT_NEIGHBORHOOD = "exitNeighborhood"; 
 public static final String KEY_TRAVELER_EXIT_STREET = "exitStreet";
 public static final String KEY_TRAVELER_EXIT_NUM_OF_BUILDING = "exitNumOfBuilding";
 public static final String KEY_TRAVELER_DEST_NEIGHBORHOOD = "destNeighborhood";
 public static final String KEY_TRAVELER_DEST_STREET = "destStreet";
 public static final String KEY_TRAVELER_DEST_NUM_OF_BUILDING = "destNumOfBuilding"; 
 public static final String KEY_TRAVELER_TIME = "time"; 
 public static final String KEY_TRAVELER_EXIT_DATE = "exitDate"; 
 public static final String KEY_TRAVELER_ID = "id"; 
} 