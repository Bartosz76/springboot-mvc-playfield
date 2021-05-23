package bm.app.springbootmvcplayfield.controllers;

import bm.app.springbootmvcplayfield.models.Macedonian;
import bm.app.springbootmvcplayfield.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String getHomePage() {
        return "index";
    }

    @RequestMapping("/objectPage")
    public String getToObjectsPage() {
        return "objectPage";
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
        return "result";
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
        return "result";
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
        ModelAndView modelAndView = new ModelAndView(); // <-- .setViewName can be basically set here,
        int resultNumber = numberOne * numberTwo;       // just add the page's name in the bracket
        modelAndView.setViewName("result");             // <-- instead of this line of code.
        modelAndView.addObject("resultNumber", resultNumber);
        return modelAndView;
    }

    /**
     * At this stage I am changing the way view files are accessed.
     * ------------------------------------------------------------
     * I can use this if I want to avoid specifying the extension of the view file.
     * (Webapp folder is public and thus anyone can access files there without the
     * need to go through my controller (just the website name + / + the name of the
     * file - it will bypass the controller!)).
     * Instead of adding the extension to the file I want returned, I can specify the
     * path to the file and its extension in application.properties instead.
     */

    /**
     * Below is a very similar way but with... just a Model, not ModelAndView.
     * Instead of Model I could also use ModelMap. If I want a simple object,
     * I should go for Model and if I want data in a map format... ModelMap.
     */

    @RequestMapping("/divide")
    public String divideInput(@RequestParam("NumberOne") int numberOne,
                              @RequestParam("NumberTwo") int numberTwo,
                              Model model) {
        int resultNumber = numberOne / numberTwo;
        model.addAttribute("resultNumber", resultNumber);
        return "result";
    }

    /**
     * Creating an object out of provided input.
     */

    @RequestMapping("/createAPerson")
    public String addAPerson(@RequestParam String firstName,
                             @RequestParam String lastName,
                             Model model) {
        Person person = new Person();
        person.setName(firstName);
        person.setLastName(lastName);
        model.addAttribute("person", person);
        return "resultPerson";
    }

    /**
     * @ModelAttribute way.
     * Below way doesn't even require additional Model. It doesn't even require the name
     * of the parameter to match the one in the .jsp file... and it doesn't even need
     * the @ModelAttribute annotation.
     * The below way is technically working... but it will only give me the surname. It
     * seems to not be able to differentiate between multiple provided values and just
     * takes the last one given.
     * EDIT: It works, but the attribute's name in objectPage.jsp needs to match the
     * variable name in the provided class (I give it just a class as a parameter, so
     * it goes there to determine what is what in the input).
     * I could also add @ModelAttribute before the provided parameter and it would be
     * technically correct, as well as add an additional parameter of Model and
     * .addAttribute to it, like I did in the above method.
     * Perhaps this way here is useful if all provided parameters are of different
     * types so there's no two ways about assigning things to their respective
     * values in the View?
     * EDIT: Nah, just make sure the variables' names match and it'll be fine.
     */

    @RequestMapping("/createAPersonButDifferently")
    public String addAPersonButAnotherWay(Person p) {
        return "resultPerson";
    }

    /**
     * ModelAttribute at method's level.
     * Spring will first call methods with @ModelAttribute before calling any
     * @RequestMapping method. It doesn't matter which method with the @RequestMapping
     * annotation will be called. The model set in @ModelAttribute method will be available.
     * Obviously, I can just add Model as another parameter in particular @RequestMapping
     * method as usual, but that's another way of doing it -> "on a method level".
     */

    @ModelAttribute
    public void modelData(Model model) {
        model.addAttribute("word", "Hedgehog");
    }

    /**
     * ---Differentiating between HTTP methods below.---
     */

    @GetMapping("getMacedonians")
    public String getMacedonians(Model model) {
        List<Macedonian> macedonians = Arrays.asList(
                new Macedonian("Teukos", 24, "Phalangite"),
                new Macedonian("Nikanor", 26, "Hetairoi"),
                new Macedonian("Amyntas", 32, "Hypaspist")
        );
        model.addAttribute("macedonians", macedonians);
        return "resultMacedonian";
    }
}
