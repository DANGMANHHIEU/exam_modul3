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

@WebServlet(name = "LoadEditController",value = "loadStaffEdit")

public class LoadEditController extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
                detail(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
            String id = req.getParameter("staffId");
            Dao dao = new Dao();
            Staff getProducByID = dao.getStaffByID(id);

            req.setAttribute("detail", getProducByID);
            RequestDispatcher dispatcher = req.getRequestDispatcher("Edit.jsp");
            dispatcher.forward(req, resp);
        }
    }


