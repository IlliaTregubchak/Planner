package planner.dao.impl;

import planner.config.DatabaseConfig;
import planner.dao.TaskDAO;
import planner.dto.tasks.SaveTaskDTO;
import planner.dto.tasks.UpdateTaskDTO;
import planner.dto.tasks.TaskDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    @Override
    public long save(SaveTaskDTO saveTaskDTO) {

        try {
            final Connection connection = DatabaseConfig.connection;
            // створ preparedStatement для модифікації SQL-запиту
            final PreparedStatement preparedStatement = connection.prepareStatement("insert into tasks(name, description, date, status, user_id) VALUES(?, ?, ?, ?, ?)");
            // тип данних (setString, setInt), індекс - порядковий номер знака питання, який потрібно замінити, значення, яке буде замість знака питання
            preparedStatement.setString(1, saveTaskDTO.getName());
            preparedStatement.setString(2, saveTaskDTO.getDescription());
            preparedStatement.setString(3, saveTaskDTO.getDate());
            preparedStatement.setBoolean(4, saveTaskDTO.isStatus());
            preparedStatement.setLong(5, saveTaskDTO.getUserId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void update(UpdateTaskDTO updateTaskDTO, long id) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("update tasks set name = ?, description = ?, date = ?, status = ? where id = ?");
            preparedStatement.setString(1, updateTaskDTO.getName());
            preparedStatement.setString(2, updateTaskDTO.getDescription());
            preparedStatement.setString(3, updateTaskDTO.getDate());
            preparedStatement.setBoolean(4, updateTaskDTO.isStatus());
            preparedStatement.setLong(5, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TaskDTO> findAll() {

        List<TaskDTO> tasks = new LinkedList<>();

        try {
            final Connection connection = DatabaseConfig.connection;
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("select t.id, t.name as name, t.description, t.date, t.status, u.name as username from tasks t, users u where t.user_id = u.id;");

            while(resultSet.next()) {
                final TaskDTO taskDTO = getTask(resultSet);
                tasks.add(taskDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    @Override
    public TaskDTO findById(long id) {
        final TaskDTO taskDTO = new TaskDTO();
        try {
            final Connection connection = DatabaseConfig.connection;
            // створ preparedStatement для модифікації SQL-запиту
            final PreparedStatement preparedStatement = connection.prepareStatement("select t.id, t.name as name, t.description, t.date, t.status, u.name as username from tasks t, users u where t.user_id = u.id and t.id = ?;");
            // тип данних (setString, setInt), індекс (1) - порядковий номер знака питання, який потрібно замінити, значення, яке буде замість знака питання
            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return getTask(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskDTO;
    }

    @Override
    public List<TaskDTO> findByUserId(long userId) {
        List<TaskDTO> tasksByUser = new LinkedList<>();

        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("select t.id, t.name as name, t.description, t.date, t.status, u.name as username from tasks t, users u where t.user_id = u.id and t.user_id = ?;");
            preparedStatement.setLong(1, userId);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                final TaskDTO taskDTO = getTask(resultSet);
                tasksByUser.add(taskDTO);
            }

        } catch(SQLException e) {
            e.printStackTrace();
            return tasksByUser;
        }

        return tasksByUser;
    }

    @Override
    public void delete(long id) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("delete from tasks where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByUserId(long userId) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("delete from tasks where user_id = ?");
            preparedStatement.setLong(1, userId);
            preparedStatement.execute();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private TaskDTO getTask(ResultSet resultSet) throws SQLException {
        final long id = resultSet.getLong("id");
        final String name = resultSet.getString("name");
        final String description = resultSet.getString("description");
        final String date = resultSet.getString("date");
        final boolean status = resultSet.getBoolean("status");
        final String username = resultSet.getString("username");

        final TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(id);
        taskDTO.setName(name);
        taskDTO.setDescription(description);
        taskDTO.setDate(date);
        taskDTO.setStatus(status);
        taskDTO.setUsername(username);
        return taskDTO;
    }
}