package tn.esprit.sae7.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.sae7.entity.Foyer;
import tn.esprit.sae7.entity.Universite;
import tn.esprit.sae7.repository.IFoyerRepository;
import tn.esprit.sae7.repository.IUniversiteRepository;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {

    private final IUniversiteRepository universiteRepository;
    private final IFoyerRepository foyerRepository;

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer not found"));

        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);

        universite.setFoyer(foyer);

        foyer.setUniversite(universite);

        universiteRepository.save(universite);

        return universite;
    }
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université not found"));

        Foyer foyer = universite.getFoyer();

        if (foyer != null) {
            universite.setFoyer(null);

            foyer.setUniversite(null);

            universiteRepository.save(universite);

            foyerRepository.save(foyer);
        } else {
            throw new RuntimeException("No Foyer is associated with this Universite.");
        }

        return universite;
    }
}
