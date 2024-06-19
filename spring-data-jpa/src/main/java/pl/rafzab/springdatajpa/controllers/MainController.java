package pl.rafzab.springdatajpa.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rafzab.springdatajpa.services.SpringDataJpaService;

@RestController
public class MainController {

    @Autowired
    private SpringDataJpaService springDataJpaService;

    @GetMapping("/test")
    public String test() {
        springDataJpaService.test();
        return "END";
    }

}
