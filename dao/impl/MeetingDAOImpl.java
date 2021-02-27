package planner.dao.impl;

import planner.config.DatabaseConfig;
import planner.dao.MeetingDAO;
import planner.dto.meetings.MeetingDTO;
import planner.dto.meetings.SaveMeetingDTO;
import planner.dto.meetings.UpdateMeetingDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MeetingDAOImpl implements MeetingDAO {
    
    @Override
    public long save(SaveMeetingDTO saveMeetingDTO) {
        try {
            final Connection connection = DatabaseConfig.connection;
            // створ preparedStatement для модифікації SQL-запиту
            final PreparedStatement preparedStatement = connection.prepareStatement("insert into meetings(name, description, date, user_id) VALUES(?, ?, ?, ?)");
            // тип данних (setString, setInt), індекс - порядковий номер знака питання, який потрібно замінити, значення, яке буде замість знака питання
            preparedStatement.setString(1, saveMeetingDTO.getName());
            preparedStatement.setString(2, saveMeetingDTO.getDescription());
            preparedStatement.setString(3, saveMeetingDTO.getDate());
            preparedStatement.setLong(4, saveMeetingDTO.getUserId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void update(UpdateMeetingDTO updateMeetingDTO, long id) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("update meetings set name = ?, description = ?, date = ? where id = ?");
            preparedStatement.setString(1, updateMeetingDTO.getName());
            preparedStatement.setString(2, updateMeetingDTO.getDescription());
            preparedStatement.setString(3, updateMeetingDTO.getDate());
            preparedStatement.setLong(4, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MeetingDTO> findAll() {
        List<MeetingDTO> meetings = new LinkedList<>();

        try {
            final Connection connection = DatabaseConfig.connection;
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("select m.id, m.name as name, m.description, m.date, u.name as username from meetings m, users u where m.user_id = u.id;");

            while(resultSet.next()) {
                long id = resultSet.getLong("id");
                final String name = resultSet.getString("name");
                final String description = resultSet.getString("description");
                final String date = resultSet.getString("date");
                final String username = resultSet.getString("username");

                final MeetingDTO meetingDTO = new MeetingDTO();
                meetingDTO.setId(id);
                meetingDTO.setName(name);
                meetingDTO.setDescription(description);
                meetingDTO.setDate(date);
                meetingDTO.setUsername(username);

                meetings.add(meetingDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return meetings;
    }

    @Override
    public MeetingDTO findById(long id) {
        final MeetingDTO meetingDTO = new MeetingDTO();

        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("select m.id, m.name as name, m.description, m.date, u.name as username from meetings m, users u where m.user_id = u.id and m.id = ?;");
            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                final long meetingId = resultSet.getLong("id");
                final String name = resultSet.getString("name");
                final String description = resultSet.getString("description");
                final String date = resultSet.getString("date");
                final String username = resultSet.getString("username");

                meetingDTO.setId(meetingId);
                meetingDTO.setName(name);
                meetingDTO.setDescription(description);
                meetingDTO.setDate(date);
                meetingDTO.setUsername(username);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return meetingDTO;
    }

    @Override
    public List<MeetingDTO> findByUserId(long userId) {
        List<MeetingDTO> meetingsByUser = new LinkedList<>();
        try {
             final Connection connection = DatabaseConfig.connection;
             final PreparedStatement preparedStatement = connection.prepareStatement("select m.id, m.name as name, m.description, m.date, u.name as username from meetings m, users u where m.user_id = u.id and m.user_id = ?;");
             preparedStatement.setLong(1, userId);
             final ResultSet resultSet = preparedStatement.executeQuery();

             while(resultSet.next()) {
                 final MeetingDTO meetingDTO = getMeeting(resultSet);
                 meetingsByUser.add(meetingDTO);
             }

        } catch (SQLException e) {
            e.printStackTrace();
            return meetingsByUser;
        }


        return meetingsByUser;
    }

    @Override
    public void delete(long id) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("delete from meetings where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByUserId(long userId) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("delete from meetings where user_id = ?");
            preparedStatement.setLong(1, userId);
            preparedStatement.execute();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private MeetingDTO getMeeting(ResultSet resultSet) throws SQLException {
        final long id = resultSet.getLong("id");
        final String name = resultSet.getString("name");
        final String description = resultSet.getString("description");
        final String date = resultSet.getString("date");
        final String username = resultSet.getString("username");

        final MeetingDTO meetingDTO = new MeetingDTO();
        meetingDTO.setId(id);
        meetingDTO.setName(name);
        meetingDTO.setDescription(description);
        meetingDTO.setDate(date);
        meetingDTO.setUsername(username);

        return meetingDTO;
    }

}
