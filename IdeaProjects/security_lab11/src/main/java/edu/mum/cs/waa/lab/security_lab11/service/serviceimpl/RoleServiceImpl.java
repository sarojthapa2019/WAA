package edu.mum.cs.waa.lab.security_lab11.service.serviceimpl;

import edu.mum.cs.waa.lab.security_lab11.domain.Role;
import edu.mum.cs.waa.lab.security_lab11.repository.RoleRepository;
import edu.mum.cs.waa.lab.security_lab11.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
