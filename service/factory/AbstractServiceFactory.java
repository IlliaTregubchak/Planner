package planner.service.factory;

import planner.service.MeetingService;
import planner.service.TaskService;
import planner.service.UserService;

public interface AbstractServiceFactory {

    UserService getUserService();

    TaskService getTaskService();

    MeetingService getMeetingService();
}
