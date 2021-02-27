package planner.dao.factory;

import planner.dao.MeetingDAO;
import planner.dao.TaskDAO;
import planner.dao.UserDAO;
import planner.dao.impl.MeetingDAOImpl;
import planner.dao.impl.TaskDAOImpl;
import planner.dao.impl.UserDAOImpl;

public class DAOFactory implements AbstractDAOFactory {

    public static DAOFactory daoFactory;

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
            return daoFactory;
        }
        return daoFactory;
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public TaskDAO getTaskDAO() {
        return new TaskDAOImpl();
    }

    @Override
    public MeetingDAO getMeetingDAO() {
        return new MeetingDAOImpl();
    }
}
