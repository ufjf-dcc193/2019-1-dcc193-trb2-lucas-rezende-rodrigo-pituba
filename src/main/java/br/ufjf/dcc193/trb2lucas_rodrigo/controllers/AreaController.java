package br.ufjf.dcc193.trb2lucas_rodrigo.controllers;

import br.ufjf.dcc193.trb2lucas_rodrigo.DTO.TrabalhoDTO;
import br.ufjf.dcc193.trb2lucas_rodrigo.IdLogin;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Area;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Avaliador;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.EnumStatus;
import br.ufjf.dcc193.trb2lucas_rodrigo.models.Revisao;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.*;
import br.ufjf.dcc193.trb2lucas_rodrigo.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping({ "/areas" })
public class AreaController {

    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private RevisaoRepository revisaoRepository;
    @Autowired
    private AvaliadorRepository avaliadorRepository;
    @Autowired
    private TrabalhoRepository trabalhoRepository;

    @GetMapping("/minhas-areas")
    public ModelAndView getMinhasAreas() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("minhas_areas");
        mv.addObject("areas",avaliadorRepository.findById(IdLogin.idLogin).orElse(new Avaliador()).getAreas());
        mv.addObject("id",IdLogin.idLogin);
        return mv;
    }

    @GetMapping("/ver-trabalhos.html/{id}")
    public ModelAndView getTrabalhosPorArea(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("trabalhos_por_area");
        Area area = areaRepository.findById(id).orElse(new Area());
        List<TrabalhoDTO> trabalhoDTOList = revisaoRepository.findTrabalhosAvaliados(area);
        trabalhoDTOList.addAll(revisaoRepository.findTrabalhosNaoAvaliados(area));
        for (TrabalhoDTO trabalhoDTO : trabalhoDTOList) {
            trabalhoDTO.setRevisoes(revisaoRepository.findAllByTrabalho(trabalhoRepository.findById(trabalhoDTO.getId()).get()));
            for (Revisao revisao: trabalhoDTO.getRevisoes()) {
                if(revisao.getAvaliador().getId() == IdLogin.idLogin) {
                    trabalhoDTO.setMinhaRevisao(true);
                    trabalhoDTO.setRevisao(revisao);
                }
            }
        }
        mv.addObject("trabalhos", trabalhoDTOList);
        mv.addObject("area", area.getNome());
        return mv;
    }

}