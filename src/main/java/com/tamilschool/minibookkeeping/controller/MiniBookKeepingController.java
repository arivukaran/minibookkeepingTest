package com.tamilschool.minibookkeeping.controller;

import com.tamilschool.minibookkeeping.dto.Book;
import com.tamilschool.minibookkeeping.model.ClassMaster;
import com.tamilschool.minibookkeeping.repo.ClassMasterRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class MiniBookKeepingController {
    private static final Logger logger = LogManager.getLogger(MiniBookKeepingController.class);

    @Autowired
    private ClassMasterRepo classMasterRepo;

    @GetMapping("/fetch")
    public List fetchBookDetails() {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book();
        book1.setBookId(1001);
        book1.setBookName("Java learning");
        book1.setAuthor("Don");
        book1.setBookCost(29.99f);
        book1.setPublisherName("Chennai112");

        Book book2 = new Book();
        book2.setBookId(1002);
        book2.setBookName("Pyhton learning");
        book2.setAuthor("Don");
        book2.setBookCost(10.99f);
        book2.setPublisherName("Chennai1223");

        Book book3 = new Book();
        book3.setBookId(1002);
        book3.setBookName("Pyhton learning");
        book3.setAuthor("Don");
        book3.setBookCost(10.99f);
        book3.setPublisherName("Chennai223");


        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        return bookList;
    }

    @GetMapping("/insert")
    public String insertBookDetails() {
        try {
            ClassMaster classMaster = new ClassMaster();
            classMaster.setId(1);
            classMaster.setName("Suresh");
            classMasterRepo.save(classMaster);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "saved!";
    }
    @GetMapping("/addName")
    @ResponseBody
    public String insertName(@RequestParam String name) {
        try {
            ClassMaster classMaster = new ClassMaster();
            classMaster.setName(name);
            classMasterRepo.save(classMaster);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "saved!";
    }
    @GetMapping("/list")
    public List<ClassMaster> fetchAll() {
        return (List<ClassMaster>) classMasterRepo.findAll();
    }
    @GetMapping("/fetchById/{id}")
    public Optional<ClassMaster> fetchById(@PathVariable String id) {
    logger.info("I am inside fetchById {} ", id );
        return classMasterRepo.findById(Integer.parseInt(id));
    }
    @DeleteMapping("/delete")
    public String deleteBookDetail() {
        return "Welcome !!";
    }
}
