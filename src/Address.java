
import java.util.*;
import java.util.regex.*;

public class Address {
	private String street, house, floorNumber, side, postcode, city;

	
	
	private Address(String _street, String _house, String _floor, String _side, String _postcode, String _city) {
		street = _street;
		house = _house;
		floorNumber = _floor;
		side = _side;
		postcode = _postcode;
		city = _city;
	}

	public static class Builder {
		private String street = "Ukendt vej", house = "", floor = "",
				side = "", postcode = "", city = "";
		public Builder street(String _street)
		{ street = _street; return this; }
		public Builder house(String _house)
		{ house = _house;   return this; }
		public Builder floor(String _floor)
		{ floor = _floor;   return this; }
		public Builder side(String _side)
		{ side = _side;     return this; }
		public Builder postcode(String _postcode)
		{ postcode = _postcode; return this; }
		public Builder city(String _city)
		{ city = _city;     return this; }
		public Address build() {
			return new Address(street, house, floor, side, postcode, city);
		}
	}

	public String street()   { return street; }
	public String house()    { return house; }
	public String floor()    { return floorNumber; }
	public String side()     { return side; }
	public String postcode() { return postcode; }
	public String city()     { return city; }

	// This is new
	static Pattern pat1 = Pattern.compile(
			"([a-zæøåA-ZÆØÅ ]*) ([0-9]*), ([0-9]*). (\\w*), " +
			"([0-9]{4}) ([a-zæøåA-ZÆØÅ ]*)");
	static Pattern pat2 = Pattern.compile(
			"([a-zæøåA-ZÆØÅ ]*) ([0-9]*) ([0-9]*) (\\w*) " +
			"([0-9]{4}) ([a-zæøåA-ZÆØÅ ]*)");
	static Pattern postpat = Pattern.compile(
			".*[ ,.]([0-9]{4})[ ,.].*");

	// This is new
	// Parses user text input as an address using a Pattern object containing regular expressions
	public static Address parse(String s) {
		Matcher m1 = pat1.matcher(s);
		Matcher m2 = pat2.matcher(s);
		Builder b = new Builder();
		if (m1.matches()) {
			b.street(m1.group(1));
			b.house(m1.group(2));
			b.floor(m1.group(3));
			b.side(m1.group(4));
			b.postcode(m1.group(5));
			b.city(m1.group(6));
			return b.build();
		} else if (m2.matches()) {
			b.street(m2.group(1));
			b.house(m2.group(2));
			b.floor(m2.group(3));
			b.side(m2.group(4));
			b.postcode(m2.group(5));
			b.city(m2.group(6));
			return b.build();
		} else {
			return null;
		}
	}
}

// Should validate each field separately and concatenate them finally into a valid address
// This is to minimize user task failures during the process of validating an address given as an input by the user