package dao;

import model.ToDo;
import model.ToDoStatus;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubinyi on 2017.05.16..
 */
public class DBToDoDao implements ToDoDao {

    Connection connection = ConnectionUtil.getConnection(ConnectionUtil.DatabaseName.BFA);

    @Override
    public void addToDo(String text) {

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `ToDo`(`status`, `text`) VALUES ('NEW','" + text + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteToDo(Long ID) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM `ToDo` WHERE id=" + ID + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateToDo(Long ID, String text) {

    }

    @Override
    public void markToDoAs(Long ID, ToDoStatus status) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE `ToDo` SET status='" + status.name() + "' WHERE id=" + ID + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ToDo getToDoByID(Long ID) {
        return null;
    }

    @Override
    public List<ToDo> getAllToDos() {

        List<ToDo> doneList = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `ToDo` ");
            while (resultSet.next()) {
                doneList.add(new ToDo(resultSet.getString("text"),
                    (long) resultSet.getInt("id"),
                    ToDoStatus.valueOf(resultSet.getString("status"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doneList;
    }

    @Override
    public List<ToDo> getToDoByStatus(ToDoStatus status) {
        List<ToDo> doneList = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `ToDo` WHERE status='" + status.name() + "';");
            while (resultSet.next()) {
                doneList.add(new ToDo(resultSet.getString("text"),
                    (long) resultSet.getLong("id"),
                    ToDoStatus.valueOf(resultSet.getString("status"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doneList;
    }
}
