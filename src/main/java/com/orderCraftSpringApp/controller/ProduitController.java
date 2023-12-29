package com.orderCraftSpringApp.controller;

import com.orderCraftSpringApp.entities.Produit;
import com.orderCraftSpringApp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Produit")
public class ProduitController {
    private ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("produit", new Produit());
        return "produit-form";
    }

    @GetMapping("/delete")
    public String deleteProduit(@RequestParam("id") String id) {
        produitService.deleteProduit(Long.parseLong(id));
        return "redirect:/Produit/list";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") String id, Model model) {
        Produit produit = produitService.getProduitById(Long.parseLong(id));
        model.addAttribute("produit", produit);
        return "produit-form";
    }

    @GetMapping
    public String listProduits(Model model) {
        List<Produit> produits = produitService.getAllProduits();
        model.addAttribute("listProduits", produits);
        return "produit-list";
    }

    @PostMapping("/insert")
    public String insertProduit(@ModelAttribute("produit") Produit produit) {
        produitService.addProduit(produit);
        return "redirect:/Produit/list";
    }

    @PostMapping("/update")
    public String updateProduit(@ModelAttribute("produit") Produit produit) {
        produitService.updateProduit(produit);
        return "redirect:/Produit/list";
    }
}