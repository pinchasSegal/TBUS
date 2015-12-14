package entities;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class traveler implements Serializable
{

	private static final long serialVersionUID = -8427259519502367353L;
	
	private String name;
	private String phoneNum;
	private String mail;
	private int numOfpassengers; // מספר נוסעים
	
	private String exitNeighborhood; // שכונת יציאה
	private String exitStreet; // רחוב יציאה
	private int exitNumOfBuilding; // מספר בניין שממנו יוצאים
	

	private String destNeighborhood; // שכונת יעד
	private String destStreet; // רחוב יעד
	private int destNumOfBuilding; // מספר בניין שאליו צריך להגיע
	private String time;// שעה in sql 00:00:00
	private String exitDate;// תאריך יציאה in sql YYYY-MM-DD

	
	
	public traveler(@JsonProperty("name")String name, @JsonProperty("phoneNum")String phoneNum, 
			@JsonProperty("mail")String mail, @JsonProperty("numOfpassengers")int numOfpassengers, 
			@JsonProperty("exitNeighborhood")String exitNeighborhood, @JsonProperty("exitStreet")String exitStreet, @JsonProperty("exitNumOfBuilding")int exitNumOfBuilding, 
			@JsonProperty("destNeighborhood")String destNeighborhood, @JsonProperty("destStreet")String destStreet, @JsonProperty("destNumOfBuilding")int destNumOfBuilding, 
			@JsonProperty("time")String time, @JsonProperty("exitDate")String exitDate)throws Exception
	{
		super();
		if(name.length() > 20)
			throw new Exception("ERROR: name too long");
		// is address are exists?		
		if(numOfpassengers < 1 || numOfpassengers > 4)
			throw new Exception("ERROR: number off passanger illegal");
		if(phoneNum.length() > 10)
			throw new Exception("ERROR: phone number too long");
		if(phoneNum.length() < 9)
			throw new Exception("ERROR: phone number too short");		
		// time
		this.name = name;
		this.phoneNum = phoneNum;
		this.mail = mail;
		this.numOfpassengers = numOfpassengers;
		this.exitNeighborhood = exitNeighborhood;
		this.exitStreet = exitStreet;
		this.exitNumOfBuilding = exitNumOfBuilding;
		this.destNeighborhood = destNeighborhood;
		this.destStreet = destStreet;
		this.destNumOfBuilding = destNumOfBuilding;
		this.time = time;
		this.exitDate = exitDate;
		//this.exitAddress = exitAddress;
		//this.destinationAddress = destinationAddress;
	}
	
	public traveler(traveler t) {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception
	{
		if(name.length() > 20)
			throw new Exception("ERROR: name too long");
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) throws Exception
	{
		if(phoneNum.length() > 10)
			throw new Exception("ERROR: phone number too long");
		if(phoneNum.length() < 9)
			throw new Exception("ERROR: phone number too short");
		this.phoneNum = phoneNum;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getNumOfpassengers() {
		return numOfpassengers;
	}

	public void setNumOfpassengers(int numOfpassengers) throws Exception
	{
		if(numOfpassengers < 1 || numOfpassengers > 4)
			throw new Exception("ERROR: number off passanger illegal");
		this.numOfpassengers = numOfpassengers;
	}

	public String getExitNeighborhood() {
		return exitNeighborhood;
	}

	public void setExitNeighborhood(String exitNeighborhood) {
		this.exitNeighborhood = exitNeighborhood;
	}

	public String getExitStreet() {
		return exitStreet;
	}

	public void setExitStreet(String exitStreet) {
		this.exitStreet = exitStreet;
	}

	public int getExitNumOfBuilding() {
		return exitNumOfBuilding;
	}

	public void setExitNumOfBuilding(int exitNumOfBuilding) {
		this.exitNumOfBuilding = exitNumOfBuilding;
	}

	public String getDestNeighborhood() {
		return destNeighborhood;
	}

	public void setDestNeighborhood(String destNeighborhood) {
		this.destNeighborhood = destNeighborhood;
	}

	public String getDestStreet() {
		return destStreet;
	}

	public void setDestStreet(String destStreet) {
		this.destStreet = destStreet;
	}

	public int getDestNumOfBuilding() {
		return destNumOfBuilding;
	}

	public void setDestNumOfBuilding(int destNumOfBuilding) {
		this.destNumOfBuilding = destNumOfBuilding;
	}

	public String getTime() {
		return time;
	}

	
	public void setTime(String time) {
		this.time = time;
	}

	public String getExitDate() {
		return exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

}