package com.example.demo;

import com.example.demo.Service.CatService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoApplication.class, args);

       // CatService catObj = new CatService();
       // catObj.catService("https://cat-fact.herokuapp.com/facts/random");

    }

}
