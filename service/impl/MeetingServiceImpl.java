package planner.service.impl;

import planner.dao.MeetingDAO;
import planner.dao.impl.MeetingDAOImpl;
import planner.dto.meetings.MeetingDTO;
import planner.dto.meetings.SaveMeetingDTO;
import planner.dto.meetings.UpdateMeetingDTO;
import planner.service.MeetingService;

import java.util.List;

public class MeetingServiceImpl implements MeetingService {

    @Override
    public long save(SaveMeetingDTO saveMeetingDTO) {
        if(saveMeetingDTO == null)
            throw new NullPointerException("Meeting is null");

        MeetingDAO meetingDAO = new MeetingDAOImpl();
        return meetingDAO.save(saveMeetingDTO);

    }

    @Override
    public void update(UpdateMeetingDTO updateMeetingDTO, long id) {
        MeetingDAO meetingDAO = new MeetingDAOImpl();
        meetingDAO.update(updateMeetingDTO, id);
    }

    @Override
    public List<MeetingDTO> findAll() {
        MeetingDAO meetingDAO = new MeetingDAOImpl();
        return meetingDAO.findAll();
    }

    @Override
    public MeetingDTO findById(long id) {
        MeetingDAO meetingDAO = new MeetingDAOImpl();
        return meetingDAO.findById(id);
    }

    @Override
    public List<MeetingDTO> findByUserId(long userId) {
        final MeetingDAO meetingDAO = new MeetingDAOImpl();
        return meetingDAO.findByUserId(userId);
    }

    @Override
    public void delete(long id) {
        final MeetingDAO meetingDAO = new MeetingDAOImpl();
        meetingDAO.delete(id);
    }

    @Override
    public void deleteByUserId(long userId) {
        final MeetingDAO meetingDAO = new MeetingDAOImpl();
        meetingDAO.deleteByUserId(userId);
    }
}
