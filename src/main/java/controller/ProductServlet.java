package controller;

import dao.ClientDAO;
import dao.ProductDAO;
import model.Eyeglasses;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/eyeglasses")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        try {
            switch (action) {
                case "view":
                    showViewEyeglasses(req, res);
                    break;
                default:
                    showAllEyeglasses(req, res);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void showViewEyeglasses(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        String id = req.getParameter("id");
        Eyeglasses e = productDAO.selectEyeglasses(id);
        req.setAttribute("eyeglasses", e);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/view.jsp");
        dispatcher.forward(req, res);
    }

    private void showAllEyeglasses(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        String search = req.getParameter("search");
        List<Eyeglasses> eyeglasses;
        if (search == null) {
            eyeglasses = productDAO.listAllEyeglasses();
        } else {
            eyeglasses = productDAO.searchNameOrID(search);
        }
        req.setAttribute("eyeglasses", eyeglasses);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        try {
            switch (action) {
                case "":
                    showAllEyeglasses(req, res);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
