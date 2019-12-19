package mum.edu.data;

import java.util.List;
import java.util.Set;

public interface DataFacade {
	public String findPassword(String name);
	public List<String> getAdvice(String roast);
	public Set<String> getAllKeys();
}
