package dao;

import model.ToDo;
import model.ToDoStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jakubinyi on 2017.05.16..
 */
public class MemoryToDoDao implements ToDoDao{

    long toDoCount = 0;
    public static final Map<Long, ToDo> toDoMap = new HashMap<>();
    public static final ToDoDao INSTANCE = new MemoryToDoDao();

    @Override
    public void addToDo(String text) {
        toDoMap.put(toDoCount, new ToDo(text, toDoCount++));
    }

    @Override
    public void deleteToDo(Long ID) {
        toDoMap.remove(ID);
    }

    @Override
    public void updateToDo(Long ID, String text) {
        toDoMap.get(ID).setText(text);
    }

    @Override
    public void markToDoAs(Long ID, ToDoStatus status) {
        toDoMap.get(ID).setStatus(status);
    }

    @Override
    public List<ToDo> getAllToDos() {
        return new ArrayList<ToDo>(toDoMap.values());
    }

    @Override
    public ToDo getToDoByID(Long ID) {
        return toDoMap.get(ID);
    }

    @Override
    public List<ToDo> getToDoByStatus(ToDoStatus status) {
        ArrayList<ToDo> selectedToDos = new ArrayList<>();

        for (ToDo toDo : toDoMap.values()) {
            if(toDo.getStatus().equals(status)) {
                selectedToDos.add(toDo);
            }
        }
        return selectedToDos;
        //return toDoMap.values().stream().filter((ToDo toDo) -> toDo.getStatus().equals(status)).collect(Collectors.toList());
        //return toDoMap.values().stream().filter((ToDo toDo) -> { return toDo.getStatus().equals(status); }).collect(Collectors.toList());
    }
}
