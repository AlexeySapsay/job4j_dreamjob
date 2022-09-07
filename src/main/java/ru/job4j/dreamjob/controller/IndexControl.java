package ru.job4j.dreamjob.controller;
/**
 * Изучение работы с контрллерами.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControl {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/greetings")
    public String greetings() {
        return "greetingsJava";
    }

    @GetMapping("/tableStatistic")
    public String tableStatistic() {
        return "tableStatistic";
    }
}