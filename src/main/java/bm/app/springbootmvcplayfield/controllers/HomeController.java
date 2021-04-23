package bm.app.springbootmvcplayfield.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String getHomePage() {
        return "index.jsp";
    }
}
