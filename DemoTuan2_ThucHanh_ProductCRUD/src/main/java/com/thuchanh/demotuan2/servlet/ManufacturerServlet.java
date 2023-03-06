package com.thuchanh.demotuan2.servlet;

import com.thuchanh.demotuan2.dao.ManufacturerDao;
import com.thuchanh.demotuan2.model.Manufacturer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class ManufacturerServlet extends HttpServlet {
    private ManufacturerDao manufacturerDao;

    public void init(){
        manufacturerDao = new ManufacturerDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new-manufacturer":
                    showNewForm(request, response);
                    break;
                case "/insert-manufacturer":
                    insertManufacturer(request, response);
                    break;
                case "/delete-manufacturer":
                    deleteManufacturer(request, response);
                    break;
                case "/edit-manufacturer":
                    showEditForm(request, response);
                    break;
                case "/update-manufacturer":
                    updateManufacturer(request, response);
                    break;
                default:
                    listManufacturer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("manufacturer-form.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Manufacturer existingManufacturer = manufacturerDao.getManufacturer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manufacturer-form.jsp");
        request.setAttribute("manufacturer", existingManufacturer);
        dispatcher.forward(request, response);
    }


    private void listManufacturer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Manufacturer> list = manufacturerDao.getAll();
        request.setAttribute("listManufacturer", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("manufacturer-list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertManufacturer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String contactName = request.getParameter("contactName");
        String contactEmail = request.getParameter("contactEmail");
        String contactPhone = request.getParameter("contactPhone");
        String website = request.getParameter("website");


        Manufacturer newManufacturer = new Manufacturer(name, contactName, contactEmail, contactPhone, website);
        manufacturerDao.create(newManufacturer);
        response.sendRedirect("list-manufacturer");
    }

    private void updateManufacturer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String contactName = request.getParameter("contactName");
        String contactEmail = request.getParameter("contactEmail");
        String contactPhone = request.getParameter("contactPhone");
        String website = request.getParameter("website");

        Manufacturer manufacturer = new Manufacturer(id, name, contactName, contactEmail, contactPhone, website);
        manufacturerDao.update(manufacturer);
        response.sendRedirect("list-manufacturer");
    }

    private void deleteManufacturer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        manufacturerDao.delete(id);
        response.sendRedirect("list-manufacturer");
    }
}
