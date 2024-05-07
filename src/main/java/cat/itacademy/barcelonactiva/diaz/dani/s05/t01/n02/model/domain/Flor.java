package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Flor")
public class Flor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_FlorID;

    @Column(name = "Nombre")
    private String nameFlor;

   @Column(name = "Pais")
    private String paisFlor;


   public Flor(){}

    public Flor(String nameFlor, String paisFlor) {
       this.nameFlor = nameFlor;
       this.paisFlor = paisFlor;
    }

    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNameFlor() {
        return nameFlor;
    }

    public void setNameFlor(String nameFlor) {
        this.nameFlor = nameFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }
}
