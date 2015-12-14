package tbusService;

import java.util.ArrayList;

import entities.traveler;

public interface DB {
	public abstract String AddTraveling(traveler travel) throws Exception;
	public abstract ArrayList<traveler> getTravelersList() throws Exception;
	
}
