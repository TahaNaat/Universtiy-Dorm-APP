package tn.esprit.sae7.service;

import tn.esprit.sae7.entity.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);
}

