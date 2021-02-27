package planner.service.impl;

import planner.dao.TaskDAO;
import planner.dao.impl.TaskDAOImpl;
import planner.dto.tasks.SaveTaskDTO;
import planner.dto.tasks.UpdateTaskDTO;
import planner.dto.tasks.TaskDTO;
import planner.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    @Override
    public long save(SaveTaskDTO saveTaskDTO) {
        if (saveTaskDTO == null) {
            throw new NullPointerException("Task is NULL");
        }

        TaskDAO taskDAO = new TaskDAOImpl();
        return taskDAO.save(saveTaskDTO);

    }

    @Override
    public void update(UpdateTaskDTO updateTaskDTO, long id) {
        TaskDAO taskDAO = new TaskDAOImpl();
        taskDAO.update(updateTaskDTO, id);
    }

    @Override
    public List<TaskDTO> findAll() {
        TaskDAO taskDAO = new TaskDAOImpl();
        return taskDAO.findAll();
    }

    @Override
    public TaskDTO findById(long id) {
        TaskDAO taskDAO = new TaskDAOImpl();
        return taskDAO.findById(id);
    }

    @Override
    public List<TaskDTO> findByUserId(long userId) {
        final TaskDAO taskDAO = new TaskDAOImpl();
        return taskDAO.findByUserId(userId);
    }

    @Override
    public void delete(long id) {
        final TaskDAO taskDAO = new TaskDAOImpl();
        taskDAO.delete(id);
    }

    @Override
    public void deleteByUserId(long userId) {
        final TaskDAO taskDAO = new TaskDAOImpl();
        taskDAO.deleteByUserId(userId);
    }
}
