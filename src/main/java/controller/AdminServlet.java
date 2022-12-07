package controller;

import dao.AdminDAO;
import dao.ProductDAO;
import model.Eyeglasses;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/adminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO;

    public void init() {
        adminDAO = new AdminDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "add":
                showAddEyeglasses(req,res);
                break;
            case "edit":
                showEditEyeglasses(req, res);
                break;
            case "delete":
                showDeleteEyeglasses(req,res);
                break;
            default:
                try {
                    showEyeglassesList(req, res);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void showDeleteEyeglasses(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        Eyeglasses e = this.adminDAO.searchById(id);
        req.setAttribute("eyes", e);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/delete-admin.jsp");
        try {
            dispatcher.forward(req,res);
        } catch (ServletException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void showAddEyeglasses(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("admin/add-admin.jsp");
        dispatcher.forward(req, res);
    }

    private void showEditEyeglasses(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        Eyeglasses e = this.adminDAO.searchById(id);
        req.setAttribute("eyes", e);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/edit-admin.jsp");
        try {
            dispatcher.forward(req, res);
        } catch (ServletException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void showEyeglassesList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        String search = req.getParameter("search");
        List<Eyeglasses> eyeglassesList;
        if (search != null) {
            eyeglassesList = adminDAO.searchNameOrID(search);
        }
        else {
            eyeglassesList = adminDAO.listEyeglasses();
        }
        req.setAttribute("eyes", eyeglassesList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("admin/list-admin.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "add":
                addEyeglasses(req, res);
                break;
            case "edit":
                editEyeglasses(req, res);
                break;
            case "delete":
                deleteEyeglasses(req,res);
                break;
            default:
                try {
                    showEyeglassesList(req, res);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void deleteEyeglasses(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        this.adminDAO.delete(id);
        req.setAttribute("message", "product has been deleted successfully");
        RequestDispatcher dispatcher = req.getRequestDispatcher("admin/delete-admin.jsp");
        try {
            dispatcher.forward(req, res);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addEyeglasses(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int qty = Integer.parseInt(req.getParameter("quantity"));
        String url = "/img/" + req.getParameter("image");

        Eyeglasses e = new Eyeglasses(id,name, price, qty, url);
        this.adminDAO.add(e);
        req.setAttribute("message", "product has been added successfully!");
        RequestDispatcher dispatcher = req.getRequestDispatcher("admin/add-admin.jsp");
        try {
            dispatcher.forward(req, res);
        } catch (ServletException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void editEyeglasses(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int qty = Integer.parseInt(req.getParameter("quantity"));
        String url = "/img/" + req.getParameter("image");
        System.out.println(url);

        Eyeglasses e = new Eyeglasses(name, price, qty, url);
        this.adminDAO.update(id, e);
        req.setAttribute("message", "product has been updated successfully!");
        RequestDispatcher dispatcher = req.getRequestDispatcher("admin/edit-admin.jsp");
        dispatcher.forward(req, res);
    }
}
