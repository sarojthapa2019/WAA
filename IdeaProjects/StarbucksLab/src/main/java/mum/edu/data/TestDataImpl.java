package mum.edu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Implements Singleton Pattern
public class TestDataImpl implements DataFacade {

	private static final Database data = new Database();
 
	// Private constructor. Prevents instantiation from other classes.
	private TestDataImpl() {
		
	}

	// eager init'ed singleton...
	public final static TestDataImpl INSTANCE = new TestDataImpl();

	public String findPassword (String name ) {
 		String expectedPassword = data.getPassword(name);
		return expectedPassword;
	}
	public List<String> getAdvice(String roast) { 
		return data.getAdvice(roast);
	}

	public Set<String> getAllKeys() {
		return data.getAllAdvices();
	}
}



