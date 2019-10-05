package edu.mum.cs.waa.lab.service.impl;

import edu.mum.cs.waa.lab.repository.UserRepo;
import edu.mum.cs.waa.lab.repository.impl.UserRepoImpl;
import edu.mum.cs.waa.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public String findPassword(String name) {
        return userRepo.findPassword(name);
    }
}
