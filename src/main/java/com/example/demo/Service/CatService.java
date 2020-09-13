package com.example.demo.Service;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CatService {
    /**
     *
     * @param url_streng til kattehjemmeside
     * @return data fra hjemmeside som object
     */
    public CatFact catService(String url_streng) throws IOException
    {
        //Choose what API to consume
        URL catURL = new URL(url_streng);
        //Instantiate a Buffered Reader to consume the InputStream from the URL
        BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
        //Map the data from Json to an object
        CatFact data = new Gson().fromJson(inputFromCatURL, CatFact.class);
        //Close the BufferedReader
        inputFromCatURL.close();

        //System.out.println(data.toString());

        return data;
    }


}