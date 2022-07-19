package com.company.MyLittleGame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String getAdminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/game")
    public String getGames(){
        return "game";
    }

    @GetMapping("/admin/game/add")
    public String addGame(){
        return "gamesAdd";
    }

    @GetMapping("/admin/products")
    public String getProducts(){
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String addProducts(){
        return "productsAdd";
    }
}
