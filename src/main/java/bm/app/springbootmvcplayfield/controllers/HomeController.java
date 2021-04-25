package bm.app.springbootmvcplayfield.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/add")
    public String addInput(HttpServletRequest req) {
        int numberOne = Integer.parseInt(req.getParameter("NumberOne"));
        int numberTwo = Integer.parseInt(req.getParameter("NumberTwo"));
        int resultNumber = numberOne + numberTwo;
        HttpSession session = req.getSession();
        session.setAttribute("resultNumber", resultNumber);
        return "result.jsp";
    }

    /**
     * A similar method, but using @RequestParam this time -> no need for
     * parsing the HttpServletRequest input. HttpSession is being introduced
     * as a parameter.
     * Important -> EITHER @RequestParam HAS to be followed by exactly the same names
     * in the brackets as Strings of the parameter variables as those in .jsp file OR
     * the parameter names have to be the same as those used in .jsp file.
     * Going for the second option below.
     */

    @RequestMapping("/substract")
    public String substractInput(@RequestParam int NumberOne,
                                 @RequestParam int NumberTwo,
                                 HttpSession session) {
        int resultNumber = NumberOne - NumberTwo;
        session.setAttribute("resultNumber", resultNumber);
        return "result.jsp";
    }

    /**
     * ModelAndView way does not require any other parameter than those required for
     * the business logic. Model -> for the date and View -> for the view part. Again,
     * either add the same name as used in .jsp to @RequestParam in brackets or have
     * the given parameter have the same name.
     * Going for the first option below.
     */

    @RequestMapping("/multiply")
    public ModelAndView multiplyInput(@RequestParam("NumberOne") int numberOne,
                                      @RequestParam("NumberTwo") int numberTwo) {
        ModelAndView modelAndView = new ModelAndView();
        int resultNumber = numberOne * numberTwo;
        modelAndView.setViewName("result.jsp");
        modelAndView.addObject("resultNumber", resultNumber);
        return modelAndView;
    }
}
