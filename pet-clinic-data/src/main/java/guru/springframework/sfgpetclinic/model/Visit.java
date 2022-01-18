package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="visits")
public class Visit extends BaseEntity {

    @Column(name="date")
    private LocalDate Date;

    @Column(name="descriptions")
    private String descriptions;

    @ManyToOne
    @JoinColumn(name= "pet_id")
    private Pet pet;

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
