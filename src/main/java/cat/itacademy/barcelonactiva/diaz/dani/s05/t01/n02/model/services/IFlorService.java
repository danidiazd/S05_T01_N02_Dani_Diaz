package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.domain.Flor;

import java.util.List;

public interface IFlorService {

    FlorDTO addFlower(Flor flor);

    FlorDTO saveFlower(Flor flor);

    boolean deleteFlower(Integer id);

    FlorDTO getOneFlowerDTO(Integer id);

    Flor getOneFlower(Integer id);

    List<FlorDTO> getAllFlowers();
}
