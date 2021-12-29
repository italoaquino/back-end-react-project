package com.projetoreact.services;

import com.projetoreact.entities.category;
import com.projetoreact.exception.ObjectNotFound;
import com.projetoreact.repositories.categoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryService {

    private categoryRepository repository;

    public categoryService(categoryRepository repository){
        this.repository = repository;
    }

    public List<category> findAll(){
        return this.repository.findAll();
    }

    public category findById(Long id){
        return this.repository.findById(id).orElseThrow(() -> new ObjectNotFound("Objeto nao encontrado"));
    }

    public void addCategory(String name){
        category cat = new category();
        cat.setName(name);
        repository.save(cat);
    }

    public void update(Long id, String name){
        category cat = this.repository.findById(id).orElseThrow(() -> new ObjectNotFound("Objeto nao encontrado"));
        cat.setName(name);
        this.repository.save(cat);
    }

    public void delete(Long id){
       category cat = this.repository.findById(id).orElseThrow(() -> new ObjectNotFound("Objeto nao encontrado"));
       this.repository.delete(cat);
    }

}
