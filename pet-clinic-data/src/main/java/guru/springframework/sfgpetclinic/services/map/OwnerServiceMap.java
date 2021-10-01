package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeMapService petTypeMapService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeMapService petTypeMapService, PetService petService) {
        this.petTypeMapService = petTypeMapService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        Owner savedOwner = null;
        if(object != null){
            if(object.getPets() != null) {
                for (Pet pet : object.getPets()) {
                    if(pet.getPetType() != null) {
                        if(pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeMapService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is Required");
                    }
                    if(pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }

                }
            }
            savedOwner = super.save(object);
        }
        return savedOwner;
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
