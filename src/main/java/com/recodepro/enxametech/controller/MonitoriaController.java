package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.model.Monitoria;
import com.recodepro.enxametech.repository.MonitoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/monitoria")
public class MonitoriaController {

    @Autowired
    private MonitoriaRepository monitoriaRepository;

   @GetMapping("/listar")
    public ModelAndView listarMonitorias() {
       ModelAndView mv = new ModelAndView("monitoria/listarMonitorias");
       mv.addObject("monitorias", monitoriaRepository.findAll());
       return mv;
   }

   @GetMapping("/agendar")
    public ModelAndView agendarMonitoria() {
       ModelAndView mv = new ModelAndView("monitoria/agendarMonitoria");
       mv.addObject("monitoria", new Monitoria());
       return mv;
   }

   @PostMapping("/agendar")
   public ModelAndView salvarMonitoria(Monitoria monitoria) {
       long id = monitoria.getId_monitoria();
       ModelAndView mv = new ModelAndView("redirect:/monitoria/" + id);
       monitoriaRepository.save(monitoria);
       return mv;
   }

   @GetMapping("/{id}/excluir")
    public ModelAndView excluir (@PathVariable long id) {
       ModelAndView mv = new ModelAndView("redirect:/monitoria");
       monitoriaRepository.deleteById(id);
       return mv;
   }

}
