package edu.mum.cs.ormrelationships.manytomany.service;

import edu.mum.cs.ormrelationships.manytomany.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role get(long id);
}
