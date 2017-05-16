package dao;

import model.ToDo;
import model.ToDoStatus;

import java.util.List;

/**
 * Created by jakubinyi on 2017.05.16..
 */
public interface ToDoDao {

    void addToDo(String text);

    void deleteToDo(Long ID);

    void updateToDo(Long ID, String text);

    void markToDoAs(Long ID, ToDoStatus status);

    ToDo getToDoByID(Long ID);

    List<ToDo> getAllToDos();

    List<ToDo> getToDoByStatus(ToDoStatus status);
}
