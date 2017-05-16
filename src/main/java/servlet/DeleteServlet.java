package servlet;

import dao.MemoryToDoDao;
import dao.ToDoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jakubinyi on 2017.05.16..
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long ID = Long.valueOf(request.getParameter("id"));

        ToDoDao toDoDao = (ToDoDao) request.getSession(true).getAttribute("tododao");

        toDoDao.deleteToDo(ID);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
