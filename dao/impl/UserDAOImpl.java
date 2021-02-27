package planner.dao.impl;

import planner.config.DatabaseConfig;
import planner.dao.UserDAO;
import planner.dto.users.EditUserDTO;
import planner.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public long save(EditUserDTO editUserDTO) {

        try {
            final Connection connection = DatabaseConfig.connection;

            // створ preparedStatement для модифікації SQL-запиту
            final PreparedStatement preparedStatement = connection.prepareStatement("insert into users(name, address, age) VALUES(?, ?, ?)");
            // тип данних (setString, setInt), індекс - порядковий номер знака питання, який потрібно замінити, значення, яке буде замість знака питання
            preparedStatement.setString(1, editUserDTO.getName());
            preparedStatement.setString(2, editUserDTO.getAddress());
            preparedStatement.setInt(3, editUserDTO.getAge());
            // запуск запиту
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void update(EditUserDTO editUserDTO, long id) {
        // EditUserDTO - обєкт із новими даними для Usera в БД
        // id - ідентифікатор usera, якого потрібно оновити
        // всі данні приходять із класу main через service до DAO
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("update users set name = ?, address = ?, age = ? where id = ?");
            preparedStatement.setString(1, editUserDTO.getName());
            preparedStatement.setString(2, editUserDTO.getAddress());
            preparedStatement.setInt(3, editUserDTO.getAge());
            preparedStatement.setLong(4, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        // список користувачів, який ми будемо заповнювати
        List<User> users = new LinkedList<>();

        try {
            // отримуємо connection - підключення до БД
            final Connection connection = DatabaseConfig.connection;
            // createStatement - завантажуємо браузер, тобто це інструмент, який прийме запит до БД
            // statement - це драйвер, посередник, перекладач між Java i SQL
            final Statement statement = connection.createStatement();
            // statement.executeQuery - робимо запит через SQL, все одно що пошук в google
            // resultSet - це обєкт з результатами, які повернув Statement
            final ResultSet resultSet = statement.executeQuery("select * from users;");

            // resultSet.next() перевіряє, чи ще є елемент в результаті SQL-запиту
            // повертає true, якщо є наст елемент
            // коли немає наступного - false, виходить з while
            while (resultSet.next()) {
                // у кожному заході в while у нас створ новий користувач

                long id = resultSet.getLong("id");
                final String name = resultSet.getString("name");
                final String address = resultSet.getString("address");
                final int age = resultSet.getInt("age");

                // створ обєкт user на основі тих змінних, які повернулися з resultSet
                final User user = new User();
                user.setId(id);
                user.setName(name);
                user.setAddress(address);
                user.setAge(age);

                // користувач додається у список (повт декілька разів в залежності від кількості useriв)
                users.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(long id) {
        try {
            final User user = new User();

            final Connection connection = DatabaseConfig.connection;
            // передаємо в preparedStatement SQL-запит, це наш ПРОВІДНИК в Java, між SQL i Java
            final PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id = ?");
            // змін ? на id, який нам прийшов
            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            // метод next переміщає resultSet в першу позицію зі списку результатів
            // method next повертає boolean
            // якщо в наступній (першій) позиції результатів є значення, тоді ми зайд в if і виконається
            if (resultSet.next()) {
                final long userId = resultSet.getLong("id");
                final String name = resultSet.getString("name");
                final String address = resultSet.getString("address");
                final int age = resultSet.getInt("age");

                user.setId(userId);
                user.setName(name);
                user.setAddress(address);
                user.setAge(age);

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public boolean exists(String name) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("select * from users where name = ?");
            preparedStatement.setString(1, name);
            final ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(long id) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
