package com.example.http;

import com.example.model.Name;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.jsoup.Jsoup;//? a rechercher
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

 @Service
public class HttpNames {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();// création de notre RestTemplate qui permet d'envoyer ou
                                                                                // récupérer des données via requêtes HTTP
    private final String BEHIND_THE_NAME_URL = "https://www.behindthename.com";

    public String getHtmlNamesPage (String origin){
        String url = "https://www.behindthename.com/names/usage/" + origin;
        return this.restTemplate.getForObject(url, String.class);//return la récupération de la page html en string
    }

    public List<Name> getNames (String htmlNamesPage){ // TODO : add origin as parameter
        Document doc = Jsoup.parseBodyFragment(htmlNamesPage);//Crée un document a partir de la page html
        List<Element> elements = doc.getElementsByClass("browsename");//
        List<Name> namesList = new ArrayList<>();// List afin de récupérer les noms
        for (Element el : elements){
            Name name = new Name();// instanciation de mon Object
            name.setName(el.getElementsByClass("listname").get(0).text());// récupération du nom
            name.setLink(BEHIND_THE_NAME_URL + el.getElementsByClass("listname").get(0).select("a").attr("href"));// récupération et concaténation du lien vers les infos du nom
            name.setGender(el.getElementsByClass("listgender").get(0).text());// récupration des genres
            name.setDescription(el.getElementsByClass("listusage").get(0).text());
            namesList.add(name);
        }

        return namesList;
    }
}
