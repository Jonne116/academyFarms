package dev.academy.academyFarms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/iii")
public class HomeController {
    @GetMapping
    public String index() {
        return "index";
    }
}
