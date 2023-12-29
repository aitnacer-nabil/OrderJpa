package com.orderCraftSpringApp.controller;

import com.orderCraftSpringApp.entities.Commande;
import com.orderCraftSpringApp.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Commande")
public class CommandeController {
    private CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("commande", new Commande());
        return "commande-form";
    }

    @GetMapping("/edit")
    public String showEditFormCommande(@RequestParam("id") String id, Model model) {
        Commande commande = commandeService.getCommandeById(Long.parseLong(id));
        model.addAttribute("commande", commande);
        return "commande-form";
    }

    @GetMapping("/delete")
    public String deleteClient(@RequestParam("id") String id) {
        commandeService.deleteCommande(Long.parseLong(id));
        return "redirect:/Commande/list";
    }

    @GetMapping
    public String listCommandes(Model model) {
        List<Commande> commandes = commandeService.getAllCommandes();
        model.addAttribute("commandes", commandes);
        return "commande-list";
    }

    @PostMapping("/add")
    public String addCommande(@ModelAttribute("commande") Commande commande) {
//        commandeService.addCommande(commande);
        return "redirect:/Commande/list";
    }

    @PostMapping("/status")
    public String changeStatutCommande(@RequestParam("commandeId") String commandeId, @RequestParam("statut") String statut) {
        if(commandeService.changeStatutCommande(Long.parseLong(commandeId), statut)){
            return "redirect:/Commande/list";
        } else {
            return "Error";
        }
    }
}