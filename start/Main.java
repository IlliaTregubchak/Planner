package planner.start;

import planner.config.DatabaseConfig;
import planner.dto.meetings.MeetingDTO;
import planner.dto.meetings.SaveMeetingDTO;
import planner.dto.meetings.UpdateMeetingDTO;
import planner.dto.tasks.SaveTaskDTO;
import planner.dto.tasks.TaskDTO;
import planner.dto.tasks.UpdateTaskDTO;
import planner.dto.users.EditUserDTO;
import planner.model.User;
import planner.service.MeetingService;
import planner.service.TaskService;
import planner.service.UserService;
import planner.service.impl.MeetingServiceImpl;
import planner.service.impl.TaskServiceImpl;
import planner.service.impl.UserServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DatabaseConfig.connect();

//            userAction();
//           taskAction();
           meetingAction();

        DatabaseConfig.close();
    }

    private static void userAction() {
        // створ екземпляр класу userService
        UserService userService = new UserServiceImpl();

//        final User user = userService.findById(99);
//
//        System.out.println(user);
        // створ екземпляр класу SaveUserDTO
//        final EditUserDTO editUserDTO = new EditUserDTO();

        // поля, які треба передати в базу данних
//        editUserDTO.setAddress("Long Str 25");
//        editUserDTO.setAge(75);
//        editUserDTO.setName("Alfred Lambert");
//
//        final long id = userService.save(editUserDTO);
//        System.out.println(id);

//        System.out.println("BEFORE");
//        List<User> users = userService.findAll();
//
//        for (User elem : users) {
//            System.out.println(elem.toString());
//        }
//
//        editUserDTO.setName("Evelyn");
//        editUserDTO.setAddress("High Ave 14");
//        editUserDTO.setAge(24);
//
//        userService.update(editUserDTO, 7);
//
//        System.out.println("AFTER");
//        users = userService.findAll();
//
//        for (User elem : users) {
//            System.out.println(elem.toString());
//        }

 //       userService.delete(4);

        final boolean exists = userService.exists("bhhbhbh");
        if (!exists) {
//            save()
        }
        System.out.println(exists);

    }

    private static void taskAction() {
        TaskService taskService = new TaskServiceImpl();
        // створ instance класу SaveTaskDTO
//        final SaveTaskDTO saveTaskDTO = new SaveTaskDTO();
//        // заповнюємо його для збереження в БД
//        saveTaskDTO.setName("Clean teeth");
//        saveTaskDTO.setDescription("Every day");
//        saveTaskDTO.setDate("01.01.2020");
//        saveTaskDTO.setStatus(true);
//        saveTaskDTO.setUserId(5);
//        // передаємо обєкт для збереження
//        final long id2 = taskService.save(saveTaskDTO);
//        System.out.println(id2);

        // зверт до findAll, витягуємо всі tasks з БД
//        final List<TaskDTO> tasks = taskService.findAll();
//
//        for (TaskDTO elem: tasks) {
//            System.out.println(elem.toString());
//        }


//        final UpdateTaskDTO updateTaskDTO = new UpdateTaskDTO();
//        // передаємо ті поля, які хочемо змінювати в метод update
//        updateTaskDTO.setName("crack password for IDEA");
//        updateTaskDTO.setDescription("google for it");
//        updateTaskDTO.setDate("02.09.2020");
//        updateTaskDTO.setStatus(true);
//
//        taskService.update(updateTaskDTO, 5);

//        final TaskDTO taskDTO = taskService.findById(9);
//        System.out.println(taskDTO);

//        final List<TaskDTO> tasksByUser = taskService.findByUserId(2);
//        for (TaskDTO elem : tasksByUser) {
//            System.out.println(elem.toString());
//        }


        System.out.println();

    }

    private static void meetingAction() {
        MeetingService meetingService = new MeetingServiceImpl();

//        final SaveMeetingDTO saveMeetingDTO = new SaveMeetingDTO();
//
//        saveMeetingDTO.setName("decrease auctions price");
//        saveMeetingDTO.setDescription("methodological approaches to reducing auction's prices");
//        saveMeetingDTO.setDate("05.01.2020");
//        saveMeetingDTO.setUserId(4);
//
//        final long id3 = meetingService.save(saveMeetingDTO);
//        System.out.println(id3);
//
//        final List<MeetingDTO> meetings = meetingService.findAll();
//
//        for (MeetingDTO elem: meetings) {
//            System.out.println(elem.toString());
//        }
//
//        final UpdateMeetingDTO updateMeetingDTO = new UpdateMeetingDTO();
//
//        updateMeetingDTO.setName("Sanitize office");
//        updateMeetingDTO.setDescription("Every day");
//        updateMeetingDTO.setDate("01.01.2020");
//
//        meetingService.update(updateMeetingDTO, 6);

//        final MeetingDTO meetingDTO = meetingService.findById(5);
//        System.out.println(meetingDTO);

//        final List<MeetingDTO> meetingsByUser = meetingService.findByUserId(3);
//        for (MeetingDTO elem : meetingsByUser) {
//            System.out.println(elem.toString());
//        }

        meetingService.delete(10);
    }

}
