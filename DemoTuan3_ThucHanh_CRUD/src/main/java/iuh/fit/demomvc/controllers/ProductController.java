package iuh.fit.demomvc.controllers;

import iuh.fit.demomvc.entities.Manufacturer;
import iuh.fit.demomvc.entities.Product;
import iuh.fit.demomvc.services.ManufacturerService;
import iuh.fit.demomvc.services.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ProductService productService = new ProductService();
        ManufacturerService manufacturerService = new ManufacturerService();
        HttpSession session = request.getSession(true);
        switch (action){
            case "management_product_view":
                List<Product> ls = productService.getAll();
                session.setAttribute("products",ls);



                response.sendRedirect("management-product-view.jsp");
                break;
            case "add_product_view":
                List<Manufacturer> lsManu = manufacturerService.getAll();
                session.setAttribute("maunfactories",lsManu);
                response.sendRedirect("add-product-view.jsp");
                break;
            case "add_product":
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                String manufacturerId = request.getParameter("manufacturer");
                Manufacturer manufacturer = manufacturerService.getManufacturerById(manufacturerId);
                Product product = new Product(name,description,manufacturer);
                productService.save(product);
                response.sendRedirect("ProductController?action=management_product_view");
                break;
            case "delete_product":
                String id = request.getParameter("id");
                productService.delete(id);
                response.sendRedirect("ProductController?action=management_product_view");
                break;
            case "update_product_view":
                String idSel = request.getParameter("id");
                Product productSel = productService.getProductById(idSel);
                session.setAttribute("ProductUpdate",productSel);

                List<Manufacturer> lsManu1 = manufacturerService.getAll();
                session.setAttribute("maunfactories",lsManu1);

                response.sendRedirect("update-product-view.jsp");
                break;
            case "update_product":
                String id1 = request.getParameter("id");

                String name1 = request.getParameter("name");
                String description1 = request.getParameter("description");
                String manufacturerId1 = request.getParameter("manufacturer");
                Manufacturer manufacturer1 = manufacturerService.getManufacturerById(manufacturerId1);

                Product product1 = new Product(name1,description1,manufacturer1);


                productService.update(id1,product1);
                response.sendRedirect("ProductController?action=management_product_view");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
