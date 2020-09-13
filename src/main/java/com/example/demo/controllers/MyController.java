package com.example.demo.controllers;


import com.example.demo.Service.CatFact;
import com.example.demo.Service.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    List<CatFact> arrCatService = new ArrayList<CatFact>();


    @GetMapping("/")
    @ResponseBody
    public String welcome()
    {
        return "Hej her kan du få katte facts";
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String getSingleCatFact() throws IOException
    {
        CatService catObj = new CatService();

        return catObj.catService("https://cat-fact.herokuapp.com/facts/random").toString();
    }

    @GetMapping("/getTenSortByDate")
    @ResponseBody
    public String getTenCatFacts() throws IOException
    {
        CatService catObj = new CatService();

        //indsætter 10 kat-facts i arraylist
        for(int i =0; i<10; i++)
        {
            arrCatService.add(catObj.catService("https://cat-fact.herokuapp.com/facts/random"));
        }

        //Sortere kat-facts efter create dato (lambda funktion)
        arrCatService.sort((CatFact s1, CatFact s2)->s2.getCreatedAt().compareTo(s1.getCreatedAt()));

        return arrCatService.toString();
    }

    @GetMapping("/contains")
    @ResponseBody
    public String containsCharXnumberOfTimes(@RequestParam String charr, int amount) throws IOException
    {
        String tempString;

        CatService catObj = new CatService();

        //henter cat tekst fra cat-fact
        tempString = catObj.catService("https://cat-fact.herokuapp.com/facts/random").getText();

        //Til test: 3 c'er -> http://localhost:8080/contains?charr=c&amount=3
        //tempString ="gtgtgtgcjujucujujujc";

        //tæller hvor mange gange specificeret char går igen, dette er en Spring metode
        int count = StringUtils.countOccurrencesOf(tempString, charr);

        //Vælger output til hjemmeside afhængig om kriterier er opfyldt
        if(count==amount)
        {
            return tempString;
        }
        else
        {
            return "Bedre held næste gang";
        }
    }



}