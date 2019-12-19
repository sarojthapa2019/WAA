package edu.mum.cs.ormrelationships.onetoone.service;

import java.util.List;

import edu.mum.cs.ormrelationships.onetoone.domain.Phone;
import edu.mum.cs.ormrelationships.onetoone.repository.PhoneRepository;
import edu.mum.cs.ormrelationships.onetoone.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	PhoneRepository phoneRepository;

	public List<Phone> getAll() {
		return Util.iterableToCollection(phoneRepository.findAll());
	}

	public Phone save(Phone phone) {
		return phoneRepository.save(phone);
	}

}
