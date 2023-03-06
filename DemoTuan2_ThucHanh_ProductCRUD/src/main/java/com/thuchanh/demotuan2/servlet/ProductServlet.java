package com.thuchanh.demotuan2.servlet;

import com.thuchanh.demotuan2.dao.ManufacturerDao;
import com.thuchanh.demotuan2.dao.ProductDao;
import com.thuchanh.demotuan2.model.Manufacturer;
import com.thuchanh.demotuan2.model.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDao productDao;
    private ManufacturerDao manufacturerDao;

    public void init(){
        productDao = new ProductDao();
        manufacturerDao = new ManufacturerDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("request");

        try {
            switch (action) {
                case "/new-product":
                    showNewForm(request, response);
                    break;
                case "/insert-product":
                    insertProduct(request, response);
                    break;
                case "/delete-product":
                    deleteProduct(request, response);
                    break;
                case "/edit-product":
                    showEditForm(request, response);
                    break;
                case "/update-product":
                    updateProduct(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productDao.getProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);
    }


    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> list = productDao.getAll();
        request.setAttribute("listProduct", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-product.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String manId = request.getParameter("manId");

        Manufacturer manufacturer = manufacturerDao.getManufacturer(Integer.parseInt(manId));

        Product newProduct = new Product(name, description, manufacturer);
        productDao.create(newProduct);
        response.sendRedirect("list-product");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String manId = request.getParameter("manId");

        Manufacturer manufacturer = manufacturerDao.getManufacturer(Integer.parseInt(manId));

        Product product = new Product(id, name, description, manufacturer);
        productDao.update(product);
        response.sendRedirect("list-product");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDao.delete(id);
        response.sendRedirect("list-product");
    }
}
