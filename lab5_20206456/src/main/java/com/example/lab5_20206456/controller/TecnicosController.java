package com.example.lab5_20206456.controller;

import com.example.lab5_20206456.entity.Tecnicos;
import com.example.lab5_20206456.repository.TecnicosRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tecnicos")
public class TecnicosController {

    final TecnicosRepository tecnicosRepository;

    public TecnicosController(TecnicosRepository tecnicosRepository) {
        this.tecnicosRepository = tecnicosRepository;
    }

    @GetMapping(value = {""})
    public String listarTecnicos(Model model){
        List<Tecnicos> tecnicosList = tecnicosRepository.findAll();
        model.addAttribute("tecnicosList", tecnicosList);
        return "tecnicos/principal";
    }

    @GetMapping("/new")
    public String nuevoTecnicoFrm(Model model, @ModelAttribute("tecnico") Tecnicos tecnicos) {

        return "tecnicos/editFrm";
    }

    @PostMapping("/save")
    public String guardarTecnico(RedirectAttributes attr, Model model,
                                  @ModelAttribute("tecnico") @Valid Tecnicos tecnicos, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal
            if (tecnicos.getTechnicianID() == 0) {
                attr.addFlashAttribute("msg", "Tecnico creado exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Tecnico actualizado exitosamente");
            }
            tecnicosRepository.save(tecnicos);
            return "redirect:/tecnicos";

        } else {
            return "tecnicos/editFrm";
        }
    }

    @GetMapping("/edit")
    public String editarTecnico(@ModelAttribute("tecnico") Tecnicos tecnicos,
                                      Model model, @RequestParam("id") int id) {

        Optional<Tecnicos> optProduct = tecnicosRepository.findById(id);

        if (optProduct.isPresent()) {
            tecnicos = optProduct.get();
            model.addAttribute("tecnico", tecnicos);
            return "tecnicos/editFrm";
        } else {
            return "redirect:/tecnicos";
        }
    }
}
