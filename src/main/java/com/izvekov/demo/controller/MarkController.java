package com.izvekov.demo.controller;

import com.izvekov.demo.dao.MarkJdbc;
import com.izvekov.demo.model.Mark;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarkController {

    private final MarkJdbc markJdbc;

    public MarkController(MarkJdbc markJdbc) {
        this.markJdbc = markJdbc;
    }

    @GetMapping("/mark/{id}")
    public Mark getMark(@PathVariable int id) {
        Mark mark = markJdbc.get(id);
        return mark;
    }

    @GetMapping("/mark/show_all")
    public List<Mark> showAll() {
        return markJdbc.showAll();
    }
}
