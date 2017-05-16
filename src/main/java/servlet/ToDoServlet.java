package servlet;

import dao.MemoryToDoDao;
import dao.ToDoDao;
import model.ToDo;
import model.ToDoStatus;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jakubinyi on 2017.05.16..
 */
@WebServlet("/todo")
public class ToDoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // addToDo
        //ToDoDao dao = (ToDoDao) request.getSession().getAttribute("dao.ToDoDao");

        String text = request.getParameter("text");

        ToDoDao toDoDao = (ToDoDao) request.getSession(true).getAttribute("tododao");

        toDoDao.addToDo(text);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // getAllToDos, getToDoByStatus (new, in-progress, done), getToDoByID???
        String status = request.getParameter("status");
        ToDoDao toDoDao;

        if (request.getSession(true).getAttribute("tododao") == null) {
            toDoDao = new MemoryToDoDao();
            request.getSession(true).setAttribute("tododao", toDoDao);
        } else {
            toDoDao = (ToDoDao) request.getSession(true).getAttribute("tododao");
        }

        JSONObject jsonObject = new JSONObject();

        for (ToDo toDo : toDoDao.getAllToDos()) {
            if (status.equals("onload") || status.equals("all")) {
                jsonObject.put(String.valueOf(toDo.getID()), toDo.getText());
            } else if(status.equals("done")) {
                if(toDo.getStatus().equals(ToDoStatus.DONE)){
                    jsonObject.put(String.valueOf(toDo.getID()), toDo.getText());
                }
            } else if(status.equals("inprogress")) {
                if(toDo.getStatus().equals(ToDoStatus.INPROGRESS)){
                    jsonObject.put(String.valueOf(toDo.getID()), toDo.getText());
                }
            }else if(status.equals("new")) {
                if(toDo.getStatus().equals(ToDoStatus.NEW)){
                    jsonObject.put(String.valueOf(toDo.getID()), toDo.getText());
                }
            }
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(jsonObject);
    }

   /* protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // updateToDo, markToDoAs
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // deleteToDo

        // todos/{id}
        String uri = request.getRequestURI();
        int index = uri.lastIndexOf('/');

        Long ID = Long.valueOf(uri.substring(index + 1));

        ToDoDao todoDao = MemoryToDoDao.INSTANCE;
        todoDao.deleteToDo(ID);
    }*/
}
