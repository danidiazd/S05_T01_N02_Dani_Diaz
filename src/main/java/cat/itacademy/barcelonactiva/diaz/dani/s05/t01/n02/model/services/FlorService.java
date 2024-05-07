package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlorService implements IFlorService {

    @Autowired
    private FlorRepository florRepository;

    @Override
    public FlorDTO addFlower(Flor flor) {
        return convertToDTO(florRepository.save(flor));
    }


    @Override
    public FlorDTO saveFlower(Flor flor) {
        if (flor.getPk_FlorID() == null) {
            return addFlower(flor);
        } else {
            Optional<Flor> optionalFlor = florRepository.findById(flor.getPk_FlorID());
            Flor updateFlor = optionalFlor.get();
            updateFlor.setPk_FlorID(flor.getPk_FlorID());
            updateFlor.setNameFlor(flor.getNameFlor());
            updateFlor.setPaisFlor(flor.getPaisFlor());
            return convertToDTO(florRepository.save(updateFlor));
        }
    }

    @Override
    public boolean deleteFlower(Integer id) {
        Optional<Flor> optionalFlor = florRepository.findById(id);
        if (optionalFlor.isPresent()) {
            florRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public FlorDTO getOneFlowerDTO(Integer id) {
        return convertToDTO(florRepository.findById(id).orElse(null));
    }

    @Override
    public Flor getOneFlower(Integer id) {
        return florRepository.findById(id).orElse(null);
    }

    @Override
    public List<FlorDTO> getAllFlowers() {
        List<Flor> florList = florRepository.findAll();
        List<FlorDTO> florDTOList = florList.stream().map(this::convertToDTO).toList();
        return florDTOList;
    }

    private  FlorDTO convertToDTO(Flor flor) {
        return new FlorDTO(flor.getPk_FlorID(), flor.getNameFlor(), flor.getPaisFlor());
    }
}
