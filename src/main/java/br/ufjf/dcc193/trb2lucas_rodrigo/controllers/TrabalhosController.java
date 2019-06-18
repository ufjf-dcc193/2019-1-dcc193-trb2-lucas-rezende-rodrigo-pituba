package br.ufjf.dcc193.trb2lucas_rodrigo.controllers;

import br.ufjf.dcc193.trb2lucas_rodrigo.IdLogin;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Trabalho;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AreaRepository;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AvaliadorRepository;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.TrabalhoRepository;
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
@RequestMapping({ "/trabalhos" })
public class TrabalhosController {

    @Autowired
    private TrabalhoRepository trabalhoRepository;
    @Autowired
    private AvaliadorRepository avaliadorRepository;
    @Autowired
    private AreaRepository areaRepository;

    @GetMapping
    public ModelAndView getTodosTrabalhos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("trabalhos_list");
        mv.addObject("trabalhos", trabalhoRepository.findAll());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        Trabalho trabalho = new Trabalho();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("trabalhos_form.html");
        mv.addObject("trabalho",trabalho);
        mv.addObject("opcoes",areaRepository.findAll());
        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("trabalhos_form.html");
        mv.addObject("trabalho",trabalhoRepository.findById(id));
        mv.addObject("opcoes",areaRepository.findAll());
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public RedirectView excluir(@PathVariable Integer id) {
        Trabalho atividade = trabalhoRepository.getOne(id);
        trabalhoRepository.delete(atividade);
        return new RedirectView("/trabalhos/");
    }

    @PostMapping(value = "/manter.html")
    public ModelAndView manter(@Valid Trabalho trabalho, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("trabalhos_form");
            mv.addObject("trabalho", trabalho);
            mv.addObject("opcoes",areaRepository.findAll());
            return mv;
        }
        trabalhoRepository.save(trabalho);
        mv.setViewName("redirect:");
        return mv;
    }

}