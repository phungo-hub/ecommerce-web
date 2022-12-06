package controller;

import dao.ClientDAO;
import model.Account;
import model.Role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req,res);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse res)  {
        res.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Account account = null;
        try {
            account = ClientDAO.checkLogin(username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (account != null) {
            HttpSession session = req.getSession();

            session.setAttribute("account", account);
            if (account.getRole() == Role.USER) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/eyeglasses");
                try {
                    dispatcher.forward(req, res);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (account.getRole() == Role.ADMIN) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin");
                try {
                    dispatcher.forward(req, res);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            try {
                res.sendRedirect("user/login.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
