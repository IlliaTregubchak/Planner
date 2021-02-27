package planner.service;

import planner.dto.tasks.SaveTaskDTO;
import planner.dto.tasks.UpdateTaskDTO;
import planner.dto.tasks.TaskDTO;

import java.util.List;

public interface TaskService {

    // багато полів обєднали в 1 обєкт, щоб код норм виглядав
    // несеш продукти в пакеті
    // task - назва змінної
    // найголовніший клас - моделі
    long save(SaveTaskDTO saveTaskDTO);

    void update(UpdateTaskDTO updateTaskDTO, long id);

    List<TaskDTO> findAll();

    TaskDTO findById(long id);

    List<TaskDTO> findByUserId(long userId);

    void delete(long id);

    void deleteByUserId(long userId);
}
