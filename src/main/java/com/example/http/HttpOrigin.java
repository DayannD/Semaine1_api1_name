package com.example.http;

import com.example.model.Origin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class HttpOrigin {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    public String getHtmlPageOrigin(){
        String url = "https://www.behindthename.com/names/list.php";
        return this.restTemplate.getForObject(url, String.class);
    }

    public List<Origin> getOrigin(String htmlOrigin){
        Document doc = Jsoup.parseBodyFragment(htmlOrigin);
        List<Element> elements = doc.getElementsByClass("usagelist");
        List<Origin> origins = new ArrayList<>();
        for (Element el: elements){
            List<Element> divlist = el.select("div");
            for (Element div: divlist){
                List<Element> ullist = div.select("ul > li > a");
                for (Element origine: ullist){
                    Element ethnic = origine.parent().parent().parent();
                    Elements origineEthnic = ethnic.select("h3");
                    Origin origin = new Origin();
                    origin.setOriginGroup(origineEthnic.get(0).text());
                    origin.setEthnicGroup(origine.text());
                    System.err.println(origine.text() + " de " + origineEthnic.text());
                    origins.add(origin);
                }
            }
        }
        return null;
    }
}
