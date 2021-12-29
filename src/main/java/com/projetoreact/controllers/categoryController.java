package com.projetoreact.controllers;

import com.projetoreact.entities.category;
import com.projetoreact.services.categoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/category")
public class categoryController {

    private categoryService service;

    public categoryController(categoryService service){
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping(value = "")
    public ResponseEntity<List<category>> findAll(){
        List<category> cat =  this.service.findAll();
        return new ResponseEntity<>(cat ,HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping(value = "{id}")
    public ResponseEntity<category> findById(@PathVariable Long id){
        category cat = this.service.findById(id);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addNew(@Valid @RequestBody category cat){
        this.service.addCategory(cat.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PutMapping(value = "{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody category cat, @PathVariable Long id){
        this.service.update(id, cat.getName());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
