package br.ufjf.dcc193.trb2lucas_rodrigo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomeController
 */

@Controller
public class AvaliadoresController {
    @RequestMapping({ "/valiadores" })
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("avaliadores_list");
        mv.addObject("nome", "Fulano");
        mv.addObject("senha", "1234");
        return mv;
    }
}