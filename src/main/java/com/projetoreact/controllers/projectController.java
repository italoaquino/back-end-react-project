package com.projetoreact.controllers;

import com.projetoreact.entities.category;
import com.projetoreact.entities.project;
import com.projetoreact.services.categoryService;
import com.projetoreact.services.projectService;
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
@RequestMapping(value = "/v1/project")
public class projectController {

    private projectService service;
    private categoryService catservice;

    public projectController(projectService service, categoryService catservice){
        this.service = service;
        this.catservice = catservice;
    }
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping(value = "")
    public ResponseEntity<List<project>> findAll(){
        List<project> projectList = this.service.findAll();
        return new ResponseEntity<>( projectList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping(value = "{id}")
    public ResponseEntity<project> findById(Long id){
        project project = this.service.findById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addnewProject(@Valid @RequestBody project project){
        this.service.addProject(project.getName(), project.getPrice(), project.getCategory().getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PutMapping(value = "{id}")
    public ResponseEntity<Void> update(@Valid @PathVariable Long id,  @RequestBody project project){
        this.service.update(id, project.getName(), project.getPrice(), project.getCategory());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id ){
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
