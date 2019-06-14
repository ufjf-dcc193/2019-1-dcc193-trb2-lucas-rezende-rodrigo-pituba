package br.ufjf.dcc193.trb2lucas_rodrigo.controllers;

import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AvaliadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomeController
 */

@Controller
public class AvaliadoresController {

    @Autowired
    private AvaliadorRepository avaliadorRepository;

    @RequestMapping({ "/avaliadores" })
    public ModelAndView getTodosAvaliadores() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("avaliadores_list");
        mv.addObject("avaliadores", avaliadorRepository.findAll());
        mv.addObject("nome", "Fulano");
        mv.addObject("senha", "1234");
        return mv;
    }
}