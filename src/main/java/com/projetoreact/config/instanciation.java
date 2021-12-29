package com.projetoreact.config;

import com.projetoreact.entities.category;
import com.projetoreact.repositories.categoryRepository;
import com.projetoreact.repositories.projectRepository;
import org.springframework.boot.CommandLineRunner;

public class instanciation implements CommandLineRunner {

    private categoryRepository cat;

    private projectRepository pro;

    public instanciation(categoryRepository cat, projectRepository pro){
        this.cat=  cat;
        this.pro = pro;
    }


    @Override
    public void run(String... args) throws Exception {

        category cat = new category("testando");
        this.cat.save(cat);



    }
}
