package first;

public class FrontBookkeeper61778 implements IFrontBookkeeper {
	private Army myArmy = new Army();

	@Override
	public String updateFront(String news) {
		String[] temp = news.split(" ");
		if (news.contains("show")) {
			if (temp.length == 3) {
				// System.err.println(myArmy.searchByIdentifier(temp[2]));
				return myArmy.searchByIdentifier(temp[2]);
			} else {
				// System.err.println(myArmy.searchByUnitName(temp[1]));
				return myArmy.searchByUnitName(temp[1]).toString();
			}

		} else if (news.contains("died")) {
			return null;
		} else if (news.contains("attached")) {
			// <-adding to new division, detaching from previous
			return null;
		} else {
			myArmy.addingUnit(news);
			return null;
		}

	}

}
