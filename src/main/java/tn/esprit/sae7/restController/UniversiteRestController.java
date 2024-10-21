package tn.esprit.sae7.restController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sae7.entity.Universite;
import tn.esprit.sae7.service.IUniversiteService;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

    private final IUniversiteService universiteService;

    @PostMapping("/affecterFoyer")
    public Universite affecterFoyerAUniversite(@RequestParam long idFoyer, @RequestParam String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }
    @PostMapping("/desaffecterFoyer")
    public Universite desaffecterFoyerAUniversite(@RequestParam long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}
