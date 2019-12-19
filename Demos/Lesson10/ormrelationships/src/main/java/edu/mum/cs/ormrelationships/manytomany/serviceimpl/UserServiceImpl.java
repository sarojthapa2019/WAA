package edu.mum.cs.ormrelationships.manytomany.serviceimpl;

import edu.mum.cs.ormrelationships.manytomany.domain.User;
import edu.mum.cs.ormrelationships.manytomany.repository.UserRepository;
import edu.mum.cs.ormrelationships.manytomany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
