package controller;

import dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name="insertController",value = "/add")
public class insertController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String salary = req.getParameter("salary");
        String department_id = req.getParameter("department_id");


        Dao dao = new Dao();
        try {
            dao.insertStaff(name,email,address,phoneNumber,salary,department_id);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("managerProduct");
    }
}
