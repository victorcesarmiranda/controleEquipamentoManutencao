package br.com.controleequipamentosmanutencao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class OrdemServicoController {

    @GetMapping("/ordemservico")
    public String ordemServico() {
        return "ordemservico/formulario";
    }

    @GetMapping("pendentes")
    public String pendentes() {
        return "ordemservico/pendentes";
    }

    @GetMapping("iniciadas")
    public String iniciadas() {
        return "ordemservico/iniciadas";
    }

    @GetMapping("finalizadas")
    public String finalizadas() {
        return "ordemservico/finalizadas";
    }
}
