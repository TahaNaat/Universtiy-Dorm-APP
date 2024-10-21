package tn.esprit.sae7.service;

import tn.esprit.sae7.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite(long idUniversite);
}
