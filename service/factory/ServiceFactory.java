package planner.service.factory;

import planner.service.MeetingService;
import planner.service.TaskService;
import planner.service.UserService;
import planner.service.impl.MeetingServiceImpl;
import planner.service.impl.TaskServiceImpl;
import planner.service.impl.UserServiceImpl;

public class ServiceFactory implements AbstractServiceFactory {

    private static ServiceFactory serviceFactory;

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
            return serviceFactory;
        }
        return serviceFactory;
    }

    @Override
    public UserService getUserService() {
        return new UserServiceImpl();
    }

    @Override
    public TaskService getTaskService() {
        return new TaskServiceImpl();
    }

    @Override
    public MeetingService getMeetingService() {
        return new MeetingServiceImpl();
    }
}
