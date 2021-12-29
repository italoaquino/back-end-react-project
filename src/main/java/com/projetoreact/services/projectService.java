package com.projetoreact.services;

import com.projetoreact.entities.category;
import com.projetoreact.entities.project;
import com.projetoreact.exception.ObjectNotFound;
import com.projetoreact.repositories.categoryRepository;
import com.projetoreact.repositories.projectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class projectService {

    private projectRepository repo;

    private categoryRepository repocat;

    public projectService(projectRepository repo, categoryRepository repocat){
        this.repo = repo;
        this.repocat = repocat;
    }

    public List<project> findAll(){
        return this.repo.findAll();
    }

    public project findById(Long id){
        return this.repo.findById(id).orElseThrow(() -> new ObjectNotFound("project nao encontrado"));
    }

    public void addProject(String name, Double price, Long categoryId){

        category cat = this.repocat.findById(categoryId).orElseThrow(() -> new ObjectNotFound("Categoria nao encontrada"));

        project pro = new project();
        pro.setName(name);
        pro.setPrice(price);
        pro.setCategory(cat);
        this.repo.save(pro);
    }

    public void update(Long id, String name, Double price, category category){
        project pro = this.repo.findById(id).orElseThrow(() -> new ObjectNotFound("project nao encontrado"));
        pro.setName(name);
        pro.setPrice(price);
        pro.setCategory(category);
        this.repo.save(pro);
    }

    public void delete(Long id){
        project pro = this.repo.findById(id).orElseThrow(() -> new ObjectNotFound("project nao encontrado"));
        this.repo.delete(pro);
    }
}
