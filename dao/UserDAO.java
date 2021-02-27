package planner.dao;

import planner.dto.users.EditUserDTO;
import planner.model.User;

import java.util.List;

public interface UserDAO {

    long save(EditUserDTO editUserDTO);

    void update(EditUserDTO editUserDTO, long id);

    List<User> findAll();

    User findById(long id);

    boolean exists(String name);

    void delete(long id);
}
