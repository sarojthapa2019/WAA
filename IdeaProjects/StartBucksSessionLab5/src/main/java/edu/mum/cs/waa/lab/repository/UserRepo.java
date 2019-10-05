package edu.mum.cs.waa.lab.repository;

import edu.mum.cs.waa.lab.domain.User;

import java.util.List;

public interface UserRepo {
    List<User> getAllUsers();
    String findPassword(String name);
}
