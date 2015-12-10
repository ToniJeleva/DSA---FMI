package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Army {
	private HashMap<String, ArrayList<String>> units; // using strings for
														// soldier identifiers
														// because there are no
														// arithmetical actions
														// with them
	private HashMap<String, ArrayList<String>> soldiers; // example: 12-1,
															// string

	public Army() {
		units = new HashMap<>();
		soldiers = new HashMap<String, ArrayList<String>>();
	}

	public void addingUnit(String news) {
		String[] temp = news.split(" = "); // works fine, tested
		temp[1] = temp[1].substring(1);
		String[] tempSoldiers = temp[1].split("\\D+"); // also fine
		ArrayList<String> soldiers = new ArrayList<String>(
				Arrays.asList(tempSoldiers));
		units.put(temp[0], soldiers);
	}

	public ArrayList<String> searchByUnitName(String unitName) {
		ArrayList<String> soldiersInside = new ArrayList<String>();
		soldiersInside = units.get(unitName);
		return soldiersInside;
	}

	public String searchByIdentifier(String identifier) {
		String unitIncludeIn = "";
		for (String key : units.keySet()) {
			if (units.get(key).contains(identifier)) {
				unitIncludeIn = unitIncludeIn + ", " + key;
			}
		}
		unitIncludeIn = unitIncludeIn.substring(2); // removing leading ,
		return unitIncludeIn;
	}

}
