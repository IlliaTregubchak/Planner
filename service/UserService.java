package planner.service;

import planner.dto.users.EditUserDTO;
import planner.model.User;

import java.util.List;

public interface UserService {

    long save(EditUserDTO user);

    void update(EditUserDTO editUserDTO, long id);

    List<User> findAll();

    User findById(long id);

    boolean exists(String name);

    void delete(long id);
}









