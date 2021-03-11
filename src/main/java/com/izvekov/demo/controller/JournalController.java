package com.izvekov.demo.controller;

import com.izvekov.demo.dao.JournalJdbc;
import com.izvekov.demo.model.Journal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JournalController {

    private final JournalJdbc journalJdbc;

    public JournalController(JournalJdbc journalJdbc) {
        this.journalJdbc = journalJdbc;
    }

    @GetMapping("/journal/{id}")
    public Journal getJournal(@PathVariable int id) {
        Journal journal = journalJdbc.get(id);
        return journal;
    }
}
