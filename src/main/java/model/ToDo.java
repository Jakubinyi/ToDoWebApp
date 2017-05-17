package model;

/**
 * Created by jakubinyi on 2017.05.16..
 */
public class ToDo {

    private String text;
    private ToDoStatus status;
    private Long ID;

    public ToDo(String text, Long ID) {
        this.text = text;
        this.ID = ID;
        this.status = ToDoStatus.NEW;
    }

    public ToDo(String text, Long ID, ToDoStatus status) {
        this.text = text;
        this.ID = ID;
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ToDoStatus getStatus() {
        return status;
    }

    public void setStatus(ToDoStatus status) {
        this.status = status;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
