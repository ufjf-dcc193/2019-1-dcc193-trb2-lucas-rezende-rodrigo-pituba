package br.ufjf.dcc193.trb2lucas_rodrigo.controllers;

import br.ufjf.dcc193.trb2lucas_rodrigo.IdLogin;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Avaliador;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AreaRepository;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AvaliadorRepository;
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
@RequestMapping({ "/avaliadores" })
public class AvaliadoresController {

    @Autowired
    private AvaliadorRepository avaliadorRepository;

    @Autowired
    private AreaRepository areaRepository;

    @GetMapping
    public ModelAndView getTodosAvaliadores() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("avaliadores_list");
        mv.addObject("avaliadores", avaliadorRepository.findAll());
        mv.addObject("login", IdLogin.idLogin);
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        Avaliador avaliador = new Avaliador();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("avaliadores_form");
        mv.addObject("avaliador",avaliador);
        mv.addObject("opcoes",areaRepository.findAll());
        mv.addObject("login",IdLogin.idLogin);
        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("avaliadores_form");
        mv.addObject("avaliador",avaliadorRepository.findById(id));
        mv.addObject("opcoes",areaRepository.findAll());
        mv.addObject("login",IdLogin.idLogin);
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public RedirectView excluir(@PathVariable Integer id) {
        Avaliador atividade = avaliadorRepository.getOne(id);
        avaliadorRepository.delete(atividade);
        return new RedirectView("/avaliadores/");
    }

    @PostMapping(value = "/manter.html")
    public ModelAndView manter(@Valid Avaliador avaliador, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("avaliadores_form");
            mv.addObject("avaliador", avaliador);
            mv.addObject("opcoes",areaRepository.findAll());
            mv.addObject("login",IdLogin.idLogin);
            return mv;
        }
        avaliadorRepository.save(avaliador);
        mv.addObject("login",IdLogin.idLogin);
        mv.setViewName("redirect:");
        return mv;
    }

}