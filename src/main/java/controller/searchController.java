package controller;

import dao.Dao;
import model.Staff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name ="searchController", value = "/search")
public class searchController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            search(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("txt");
        Dao dao = new Dao();
        List<Staff> list = dao.searchStaffByName(name);
        req.setAttribute("ListProduct", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
        dispatcher.forward(req, resp);
    }
}
