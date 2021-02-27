package planner.dao;

import planner.dto.meetings.MeetingDTO;
import planner.dto.meetings.SaveMeetingDTO;
import planner.dto.meetings.UpdateMeetingDTO;

import java.util.List;

public interface MeetingDAO {

    long save(SaveMeetingDTO saveMeetingDTO);

    void update(UpdateMeetingDTO updateMeetingDTO, long id);

    List<MeetingDTO> findAll();

    MeetingDTO findById(long id);

    List<MeetingDTO> findByUserId(long userId);

    void delete(long id);

    void deleteByUserId(long userId);
}
