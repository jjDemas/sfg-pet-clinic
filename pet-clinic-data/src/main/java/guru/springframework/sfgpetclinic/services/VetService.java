package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public class VetService {

    Vet findById(Long Id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
