package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.controller;

import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.dto.CountryWorld;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.services.FlorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("views/flowers")
public class FlorController {

    @Autowired
    FlorService florService;

    @Operation(summary = "List Flowers",
            description = "This method retrieves a list of all flowers.")
    @GetMapping({"/", ""})
    public String listFlower(Model model) {
        List<FlorDTO> florDTOList = florService.getAllFlowers();
        model.addAttribute("titulo", "Lista Flores");
        model.addAttribute("flowers", florDTOList);
        return "views/flowers/list";
    }

    @Operation(summary = "Show Form to Add Flower",
            description = "This method displays a form to add a new flower.")
    @GetMapping("/save")
    public String saveFlower(Model model) {
        Flor flor = new Flor();
        List<CountryWorld> countryWorlds = Arrays.stream(CountryWorld.values()).toList();
        model.addAttribute("titulo", "Agregar Flor");
        model.addAttribute("paises", countryWorlds);
        model.addAttribute("flor", flor);
        return "views/flowers/add";
    }


    @Operation(summary = "Add Flower",
            description = "This method adds a new flower to the system.")
    @PostMapping("/add")
    public String addFlower(@Valid @ModelAttribute Flor flor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<CountryWorld> countryWorlds = Arrays.stream(CountryWorld.values()).toList();
            model.addAttribute("titulo", "Agregar Flor");
            model.addAttribute("paises", countryWorlds);
            model.addAttribute("error", "El campo no puede estar vacio");
            return "views/flowers/add";
        } else {
            FlorDTO florDTO = florService.saveFlower(flor);
            return "redirect:/views/flowers";
        }
    }

    @Operation(summary = "Update a Flower",
            description = "This method updates an existing flower in the system.")
    @GetMapping("/edit/{id}")
    public String updateFlower(@PathVariable("id") Integer flowerId, Model model) {

        Flor flor = florService.getOneFlower(flowerId);
        List<CountryWorld> countryWorldList = Arrays.stream(CountryWorld.values()).toList();

        model.addAttribute("titulo", "Editar flor");
        model.addAttribute("paises", countryWorldList);
        model.addAttribute("flor", flor);
        return "/views/flowers/add";
    }

    @Operation(summary = "Delete a Flower",
            description = "This method deletes a flower from the system.")
    @GetMapping("/delete/{id}")
    public String deleteFlower(@PathVariable("id") Integer flowerId, Model model) {
        florService.deleteFlower(flowerId);
        return "redirect:/views/flowers";
    }
}
