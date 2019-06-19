package br.ufjf.dcc193.trb2lucas_rodrigo.controllers;

import br.ufjf.dcc193.trb2lucas_rodrigo.DTO.TrabalhoDTO;
import br.ufjf.dcc193.trb2lucas_rodrigo.IdLogin;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.EnumStatus;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Revisao;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Avaliador;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Trabalho;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.RevisaoRepository;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AvaliadorRepository;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.RevisaoRepository;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping({ "/revisao" })
public class RevisaoController {

    @Autowired
    private RevisaoRepository revisaoRepository;
    @Autowired
    private TrabalhoRepository trabalhoRepository;
    @Autowired
    private AvaliadorRepository avaliadorRepository;

    @GetMapping("/avaliar/{id}")
    public ModelAndView avaliar(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        Revisao revisao = new Revisao();
        mv.setViewName("revisao_form");
        mv.addObject("revisao",revisao);
        mv.addObject("trabalho",trabalhoRepository.findById(id).get());
        return mv;
    }

    @GetMapping("/editar/{id}/{id2}")
    public ModelAndView editar(@PathVariable Integer id,@PathVariable Integer id2) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("revisao_form");
        mv.addObject("revisao",revisaoRepository.findById(id2).get());
        mv.addObject("trabalho",trabalhoRepository.findById(id).get());
        return mv;
    }

    @PostMapping(value = "/manter.html/{id}")
    public ModelAndView manter(@PathVariable Integer id, @Valid Revisao revisao, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("revisao_form");
            mv.addObject("revisao", revisao);
            mv.addObject("trabalho",trabalhoRepository.findById(id).get());
            return mv;
        }
        revisao.setAvaliador(avaliadorRepository.getOne(IdLogin.idLogin));
        revisao.setTrabalho(trabalhoRepository.findById(id).get());
        revisaoRepository.save(revisao);
        mv.setViewName("redirect:/");
        return mv;
    }
}