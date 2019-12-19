package edu.mum.cs.ormrelationships.manytomany.serviceimpl;

import java.util.List;

import edu.mum.cs.ormrelationships.manytomany.domain.Role;
import edu.mum.cs.ormrelationships.manytomany.repository.RoleRepository;
import edu.mum.cs.ormrelationships.manytomany.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {

        return roleRepository.findAll();
    }

    @Override
    public Role get(long id) {

        return roleRepository.findById(id).get();
    }

}
