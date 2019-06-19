package br.ufjf.dcc193.trb2lucas_rodrigo.controllers;

import br.ufjf.dcc193.trb2lucas_rodrigo.IdLogin;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Area;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Avaliador;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AreaRepository;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AvaliadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * HomeController
 */

@Controller
public class HomeController {
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private AvaliadorRepository avaliadorRepository;

    @RequestMapping({ "", "/", "/home.html","pagina-inicial" })
    public ModelAndView index() {
        List<Area> areas = areaRepository.findAll();
        if(areas.size() == 0) {
            Area area = new Area();
            area.setNome("Português ");
            areaRepository.save(area);
            area = new Area();
            area.setNome("Biológicas ");
            areaRepository.save(area);
            area = new Area();
            area.setNome("Humanas ");
            areaRepository.save(area);
            area = new Area();
            area.setNome("Matemática ");
            areaRepository.save(area);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.addObject("nome", "Fulano");
        mv.addObject("login", IdLogin.idLogin);
        return mv;
    }
}