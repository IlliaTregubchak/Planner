package planner.service;

import planner.dto.meetings.MeetingDTO;
import planner.dto.meetings.SaveMeetingDTO;
import planner.dto.meetings.UpdateMeetingDTO;
import planner.dto.tasks.SaveTaskDTO;
import planner.dto.tasks.TaskDTO;

import java.util.List;

public interface MeetingService {
    // ставимо курсор на червоне, потім Alt+ENTER, Import Class
    long save (SaveMeetingDTO saveMeetingDTO);

    void update(UpdateMeetingDTO updateMeetingDTO, long id);

    List<MeetingDTO> findAll();

    MeetingDTO findById(long id);

    List<MeetingDTO> findByUserId(long userId);

    void delete(long id);

    void deleteByUserId(long userId);
}
