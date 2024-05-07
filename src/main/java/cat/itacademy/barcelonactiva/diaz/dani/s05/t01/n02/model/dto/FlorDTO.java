package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.dto;

import lombok.Data;

@Data
public class FlorDTO {

    private Integer pk_FlorID;

    private String nameFlor;

    private String paisFlor;
    private String tipoFlor;


    public FlorDTO(){}
    public FlorDTO(Integer pk_FlorID, String nameFlor, String paisFlor){
        this.pk_FlorID = pk_FlorID;
        this.nameFlor = nameFlor;
        this.paisFlor = paisFlor;
        this.tipoFlor = checkCountry(paisFlor);
    }
    public String checkCountry(String countryFlower) {
        for (CountryEU country : CountryEU.values()) {
            if (countryFlower.equalsIgnoreCase(country.name())) {
                return "EU";
            }
        }
        return "NOT EU";
    }
}
