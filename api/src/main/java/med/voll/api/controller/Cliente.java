package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class Cliente {

    @GetMapping
    public String olaMundo() {
        return "Hello World bagacera em Ferraz";
    }
    @GetMapping("/vamo")
    public String Vamo() {
        return "Bagacera doida";
    }
}
