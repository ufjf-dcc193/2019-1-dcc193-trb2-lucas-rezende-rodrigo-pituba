package br.ufjf.dcc193.trb2lucas_rodrigo.controllers;

import br.ufjf.dcc193.trb2lucas_rodrigo.IdLogin;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Area;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Avaliador;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Revisao;
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

import javax.validation.Valid;
import java.util.List;

/**
 * HomeController
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AvaliadorRepository avaliadorRepository;

    @GetMapping
    public ModelAndView index() {
        Avaliador avaliador = new Avaliador();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login_form");
        mv.addObject("avaliador", avaliador);
        mv.addObject("loginInvalido", false);
        mv.addObject("login",IdLogin.idLogin);
        return mv;
    }

    @PostMapping(value = "/acessar.html")
    public ModelAndView manter(@Valid Avaliador avaliador, BindingResult binding) {
        ModelAndView mv = new ModelAndView();

        Avaliador avaliadorCadastrado = avaliadorRepository.findByEmailAndSenha(avaliador.getEmail(),avaliador.getSenha());
        if(avaliadorCadastrado != null) {
            IdLogin.idLogin = avaliadorCadastrado.getId();

        mv.addObject("login",IdLogin.idLogin);
        mv.setViewName("redirect:/");
        return mv;
        } else {
            mv.setViewName("login_form");
            mv.addObject("avaliador", avaliador);
            mv.addObject("loginInvalido", true);
            mv.addObject("login",IdLogin.idLogin);
            return mv;
        }
    }

    @GetMapping("/sair")
    public ModelAndView sair() {
        Avaliador avaliador = new Avaliador();
        ModelAndView mv = new ModelAndView();
        IdLogin.idLogin = 0;
        mv.addObject("login",IdLogin.idLogin);
        mv.setViewName("redirect:/");
        return mv;
    }
}