package planner.service.impl;

import planner.dao.UserDAO;
import planner.dao.impl.UserDAOImpl;
import planner.dto.users.EditUserDTO;
import planner.model.User;
import planner.service.MeetingService;
import planner.service.TaskService;
import planner.service.UserService;
import planner.service.factory.ServiceFactory;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public long save(EditUserDTO user) {
        if (user == null) {
            throw new NullPointerException("User is NULL");
        }


        // save to file

        UserDAO userDAO = new UserDAOImpl();
        return userDAO.save(user);
        // send email
    }

    @Override
    public void update(EditUserDTO editUserDTO, long id) {
        UserDAO userDAO = new UserDAOImpl();
        userDAO.update(editUserDTO, id);
    }

    @Override
    public List<User> findAll() {
        UserDAO userDAO = new UserDAOImpl();
        return userDAO.findAll();
    }

    @Override
    public User findById(long id) {
        UserDAO userDAO = new UserDAOImpl();
        final User user = userDAO.findById(id);
        if (user == null) {
            throw new NullPointerException("Помилка, перевірте правильність введених даних та спробуйте ще раз))");
        }
        return user;
    }

    @Override
    public boolean exists(String name) {
        final UserDAO userDAO = new UserDAOImpl();
        final boolean exists = userDAO.exists(name);
        if(exists == true) {
            throw new RuntimeException("User with this name already exists");
        }
        return exists;
    }

    @Override
    public void delete(long id) {
        final ServiceFactory serviceFactory = ServiceFactory.getInstance();
        final TaskService taskService = serviceFactory.getTaskService();
        taskService.deleteByUserId(id);

        final MeetingService meetingService = serviceFactory.getMeetingService();
        meetingService.deleteByUserId(id);

        final UserDAO userDAO = new UserDAOImpl();
        userDAO.delete(id);
    }
}
