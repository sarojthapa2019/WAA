package edu.mum.cs.waa.lab.repository.impl;

import edu.mum.cs.waa.lab.domain.User;
import edu.mum.cs.waa.lab.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class UserRepoImpl implements UserRepo {
    private static HashMap<String, String> users = new HashMap();


    static {
        users.put("Dave", "111");
        users.put("Steve", "222");
        users.put("Ralph", "333");

    }



    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public String findPassword(String name) {
        return (String) users.get(name);
    }

}
