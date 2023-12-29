package com.orderCraftSpringApp.controller;

import com.orderCraftSpringApp.entities.Client;
import com.orderCraftSpringApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("client", new Client());
        return "/client-form";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") String id, Model model) {
        Client client = clientService.getClient(Long.parseLong(id));
        model.addAttribute("client", client);
        return "/client-form";
    }

    @PostMapping("/insert")
    public String insertClient(@ModelAttribute("client") Client client) {
        clientService.addClient(client);
        return "redirect:/Client/list";
    }

    @PostMapping("/update")
    public String updateClient(@RequestParam("id") String id, @ModelAttribute("client") Client client) {
        clientService.updateClient(Long.parseLong(id), client);
        return "redirect:/Client/list";
    }

    @GetMapping("/delete")
    public String deleteClient(@RequestParam("id") String id) {
        clientService.deleteClient(Long.parseLong(id));
        return "redirect:/Client/list";
    }

    @GetMapping({"/", "/list"})
    public String listClients(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("listClient", clients);
        return "/client-list";
    }
}