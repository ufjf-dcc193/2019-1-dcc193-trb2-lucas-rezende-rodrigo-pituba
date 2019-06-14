package br.ufjf.dcc193.trb2lucas_rodrigo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomeController
 */

@Controller
public class HomeController {
    @RequestMapping({ "", "/", "/home.html" })
    public ModelAndView index() {
        System.out.println("AQUI");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.addObject("nome", "Fulano");
        return mv;
    }
}