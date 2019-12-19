package edu.mum.cs.ormrelationships.onetoone.service;

import edu.mum.cs.ormrelationships.onetoone.domain.Phone;

import java.util.List;



public interface PhoneService {

	public List<Phone> getAll();

	public Phone save(Phone phone);

}
