import java.util.*;
import java.io.*;

public class Model 
	extends Observable
	implements Iterable<Address> {
	private List<Address>
		addresses = new ArrayList<Address>();

	public Model(String filename) {
		try (BufferedReader input =
				new BufferedReader(new FileReader(filename))) {
			for (String line = input.readLine() ; line != null ;
					line = input.readLine()) {
				Address addr = Address.parse(line);
				if (addr != null) addresses.add(addr);
				else System.err.println(line + " does not parse");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Iterator<Address> iterator() {
		return addresses.iterator();
	}
}

