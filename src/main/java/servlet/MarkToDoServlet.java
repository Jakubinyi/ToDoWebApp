package servlet;

import dao.MemoryToDoDao;
import dao.ToDoDao;
import model.ToDoStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jakubinyi on 2017.05.16..
 */
@WebServlet("/mark")
public class MarkToDoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long ID = Long.valueOf(request.getParameter("id"));
        String status = request.getParameter("status");

        ToDoDao toDoDao = (ToDoDao) request.getSession(true).getAttribute("tododao");

        if (status.equals("new")) {
            toDoDao.markToDoAs(ID, ToDoStatus.NEW);
        } else if (status.equals("inprogress")) {
            toDoDao.markToDoAs(ID, ToDoStatus.INPROGRESS);
        } else {
            toDoDao.markToDoAs(ID, ToDoStatus.DONE);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
