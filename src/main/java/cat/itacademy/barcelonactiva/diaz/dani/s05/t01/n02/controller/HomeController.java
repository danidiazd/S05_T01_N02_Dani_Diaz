package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

    @Operation(summary = "Home Page",
            description = "This method returns the home page.")
    @GetMapping({"", "/", "/index"})
    public String index() {
        return "home";
    }
}
