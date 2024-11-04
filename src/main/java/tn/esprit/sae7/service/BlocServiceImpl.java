package tn.esprit.sae7.service;

import tn.esprit.sae7.entity.Bloc;
import tn.esprit.sae7.entity.Chambre;
import tn.esprit.sae7.repository.BlocRepository;
import tn.esprit.sae7.repository.ChambreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService {

    @Autowired
    private BlocRepository blocRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow(() -> new RuntimeException("Bloc not found"));
        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);
        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }
        chambreRepository.saveAll(chambres);
        return bloc;
    }
}
