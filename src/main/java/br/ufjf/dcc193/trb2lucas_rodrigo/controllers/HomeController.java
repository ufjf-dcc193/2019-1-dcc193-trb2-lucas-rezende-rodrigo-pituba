package br.ufjf.dcc193.trb2lucas_rodrigo.controllers;

import br.ufjf.dcc193.trb2lucas_rodrigo.models.Avaliador;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AreaRepository;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AvaliadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * HomeController
 */

@Controller
public class HomeController {
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private AvaliadorRepository avaliadorRepository;

    @RequestMapping({ "", "/", "/home.html" })
    public ModelAndView index() {
        Area area = new Area();
        area.setNome("Português");
        areaRepository.save(area);
        area.setNome("Biológicas");
        areaRepository.save(area);
        area.setNome("Humanas");
        areaRepository.save(area);
        area.setNome("Matemática");
        Integer id = areaRepository.save(area).getId();
        area.setId(id);
        Avaliador avaliador = new Avaliador();
        avaliador.getAreas().add(area);
        avaliador.setNomeCompleto("Rodrigo Pituba de Souza");
        avaliador.setEmail("rodrigopitubasouza@gmail.com");
        avaliador.setSenha("123456");
        avaliadorRepository.save(avaliador);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.addObject("nome", "Fulano");
        return mv;
    }
}