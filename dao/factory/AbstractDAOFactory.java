package planner.dao.factory;

import planner.dao.MeetingDAO;
import planner.dao.TaskDAO;
import planner.dao.UserDAO;

public interface AbstractDAOFactory {

    UserDAO getUserDAO();

    TaskDAO getTaskDAO();

    MeetingDAO getMeetingDAO();
}
