package br.ufjf.dcc193.trb2lucas_rodrigo.controllers;

import br.ufjf.dcc193.trb2lucas_rodrigo.IdLogin;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Area;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AreaRepository;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AvaliadorRepository;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.TrabalhoRepository;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;


@Controller
@RequestMapping({ "/areas" })
public class AreaController {

    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private TrabalhoRepository trabalhoRepository;
    @Autowired
    private AvaliadorRepository avaliadorRepository;

    @GetMapping("/minhas-areas")
    public ModelAndView getMinhasAreas() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("minhas_areas");
        mv.addObject("areas",avaliadorRepository.findById(IdLogin.idLogin).get().getAreas());
        mv.addObject("id",IdLogin.idLogin);
        return mv;
    }

}