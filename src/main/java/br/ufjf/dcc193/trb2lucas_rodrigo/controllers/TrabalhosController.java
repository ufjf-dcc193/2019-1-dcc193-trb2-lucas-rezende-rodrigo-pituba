package br.ufjf.dcc193.trb2lucas_rodrigo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomeController
 */

@Controller
public class TrabalhosController {
    @RequestMapping({ "/trabalhos" })
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("trabalhos_list");
        return mv;
    }
}