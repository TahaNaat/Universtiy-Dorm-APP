package tn.esprit.sae7.restController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sae7.entity.Bloc;
import tn.esprit.sae7.service.IBlocService;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {

    private final IBlocService blocService;

    @PostMapping("/chambres")
    public Bloc assignRoomsToBloc(@RequestBody Map<String, Object> request) {
        long idBloc = ((Number) request.get("idBloc")).longValue();
        List<Long> numChambre = (List<Long>) request.get("numChambre");

        return blocService.affecterChambresABloc(numChambre, idBloc);
    }
}
