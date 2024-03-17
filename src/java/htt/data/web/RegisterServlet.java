package htt.data.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import htt.data.dao.Database;
import htt.data.model.User;
import htt.utils.API;
import jakarta.servlet.http.HttpServletRequest;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Register Page");
        req.getRequestDispatcher("./views/register.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String err_email = "", err_phone = "", err_repassword = "";
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        boolean err = false;
        String Email_Regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        String Phone_Regex = "^\\d{10}$";
        //email validate
        if (!email.matches(Email_Regex)) {
            err_email = "Email is invalid";
            req.getSession().setAttribute("err_email", err_email);
            err = true;
        } else {
            err_email = "";
            req.getSession().removeAttribute("err_email");
        }
        //phone validate
        if (!phone.matches(Phone_Regex)) {
            err_phone = "Numberphone has 10 digits";
            req.getSession().setAttribute("err_phone", err_phone);
            err = true;
        } else {
            err_phone = "";
            req.getSession().removeAttribute("err_phone");
        }
        // Compare password & repassword
        if (!repassword.matches(password)) {
            err_repassword = "Repassword not match";
            req.getSession().setAttribute("err_repassword", err_repassword);
            err = true;
        } else {
            err_repassword = "";
            req.removeAttribute("err_repassword");
        }

        if (err) {
            resp.sendRedirect("register");
        } else {
            if (Database.getUserDao().findUser(email) != null || Database.getUserDao().findUser(phone) != null) {
                req.getSession().setAttribute("exist_user", "User has already existed");
                resp.sendRedirect("register");
            } else {
                Database.getUserDao().insertUser(name, email, phone, API.getMd5(password));
                User user = Database.getUserDao().findUser(email);
                req.getSession().setAttribute("user", user);
                req.getSession().removeAttribute("exist_user");
                resp.sendRedirect("home");
            }
        }
    }
}


