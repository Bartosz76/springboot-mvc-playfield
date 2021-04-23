package bm.app.springbootmvcplayfield.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String getHomePage() {
        return "index.jsp";
    }

    /**
     * A Thymeleaf-like mechanism. HttpServletRequest as @RequestParam
     * for all possible parameters, name-of-parameter with .getParameter
     * + Strings for names (have to be the same as their names in .jsp file.
     * Opening the session and .setAttribute like model.addAttribute.
     */

    @RequestMapping("/insertInput")
    public String insertInput(HttpServletRequest req) {
        int numberOne = Integer.parseInt(req.getParameter("NumberOne"));
        int numberTwo = Integer.parseInt(req.getParameter("NumberTwo"));
        int resultNumber = numberOne + numberTwo;
        HttpSession session = req.getSession();
        session.setAttribute("resultNumber", resultNumber);
        return "result.jsp";
    }
}
