package edu.mum.cs.ormrelationships.manytomany.formatter;

import java.text.ParseException;
import java.util.Locale;

import edu.mum.cs.ormrelationships.manytomany.domain.Role;
import edu.mum.cs.ormrelationships.manytomany.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;



@Component
public class RoleFormatter implements Formatter<Role> {

	@Autowired
	private RoleService roleService;
	
	@Override
	public String print(Role role, Locale locale) {
		System.out.println("***********");
		return String.valueOf(role.getId());
	}

	@Override
	public Role parse(String text, Locale locale) throws ParseException {
		System.out.println("-----------" + text);
		System.out.println(roleService.get(Long.parseLong(text)).getRole());
		return roleService.get(Long.parseLong(text));
	}

}
