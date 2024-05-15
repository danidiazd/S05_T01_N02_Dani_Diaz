package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.repository.FlorRepository;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.services.exceptions.FlorList;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.services.exceptions.FlorNoCreada;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.services.exceptions.FlorNoID;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.services.exceptions.FlorNula;
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
        try {
            return convertToDTO(florRepository.save(flor));
        } catch (RuntimeException e) {
            throw new FlorNoCreada();
        }
    }


    @Override
    public FlorDTO saveFlower(Flor flor) {
        if (flor.getPk_FlorID() == null) {
            return addFlower(flor);
        } else {
            try {
                Optional<Flor> optionalFlor = florRepository.findById(flor.getPk_FlorID());
                Flor updateFlor = optionalFlor.get();
                updateFlor.setPk_FlorID(flor.getPk_FlorID());
                updateFlor.setNameFlor(flor.getNameFlor());
                updateFlor.setPaisFlor(flor.getPaisFlor());
                return convertToDTO(florRepository.save(updateFlor));
            } catch (RuntimeException e) {
                throw new FlorNula();
            }
        }
    }

    @Override
    public boolean deleteFlower(Integer id) {
        try {
            Optional<Flor> optionalFlor = florRepository.findById(id);
            if (optionalFlor.isPresent()) {
                florRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (RuntimeException e) {
            throw new FlorNoID(id);
        }
    }

    @Override
    public FlorDTO getOneFlowerDTO(Integer id) {
        try {
            return convertToDTO(florRepository.findById(id).orElse(null));
        } catch (Exception e) {
            throw new FlorNoID(id);
        }
    }

    @Override
    public Flor getOneFlower(Integer id) {
        try {
            return florRepository.findById(id).orElse(null);
        } catch (RuntimeException e) {
            throw new FlorNoID(id);
        }
    }

    @Override
    public List<FlorDTO> getAllFlowers() {
        try {
            List<Flor> florList = florRepository.findAll();
            List<FlorDTO> florDTOList = florList.stream().map(this::convertToDTO).toList();
            return florDTOList;
        } catch (RuntimeException e) {
            throw new FlorList();
        }
    }

    private  FlorDTO convertToDTO(Flor flor) {
        return new FlorDTO(flor.getPk_FlorID(), flor.getNameFlor(), flor.getPaisFlor());
    }
}
