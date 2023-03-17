package iuh.fit.demomvc.controllers;

import iuh.fit.demomvc.entities.Manufacturer;
import iuh.fit.demomvc.services.ManufacturerService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManufacturerController", value = "/ManufacturerController")
public class ManufacturerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ManufacturerService manufacturerService = new ManufacturerService();
        HttpSession session = request.getSession(true);
        switch (action){
            case "management_factory_view":
                List<Manufacturer> ls = manufacturerService.getAll();
                session.setAttribute("maunfactories",ls);
                response.sendRedirect("management-factory-view.jsp");
                break;
            case "add_manufacturer_view":
                response.sendRedirect("add-manufacturer-view.jsp");
                break;
            case "add_manufacturer":
                String name = request.getParameter("name");
                String contact = request.getParameter("contact");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String website = request.getParameter("website");
                Manufacturer manufacturer = new Manufacturer(name,contact,email,phone,website);
                manufacturerService.save(manufacturer);
                response.sendRedirect("ManufacturerController?action=management_factory_view");
                break;
            case "delete_user":
                String id = request.getParameter("id");
                manufacturerService.delete(id);
                response.sendRedirect("ManufacturerController?action=management_factory_view");
                break;
            case "update_manufactory_view":
                String idSel = request.getParameter("id");
                Manufacturer manufacturerSel = manufacturerService.getManufacturerById(idSel);
                session.setAttribute("ManuUpdate",manufacturerSel);
                response.sendRedirect("update-manufacturer-view.jsp");
                break;
            case "update_manufacturer":
                String id1 = request.getParameter("id");

                String name1 = request.getParameter("name");
                String contact1 = request.getParameter("contact");
                String email1 = request.getParameter("email");
                String phone1 = request.getParameter("phone");
                String website1 = request.getParameter("website");
                Manufacturer manufacturer1 = new Manufacturer(name1,contact1,email1,phone1,website1);
                manufacturerService.update(id1,manufacturer1);
                response.sendRedirect("ManufacturerController?action=management_factory_view");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
