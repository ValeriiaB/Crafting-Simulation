package com.example.demo;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    ArrayList<Mode> listOfModes = new ArrayList<>();
    public void parsingData() throws IOException {
        Document document = Jsoup.connect("http://pathofexile.gamepedia.com/List_of_int_body_armour_modifiers").userAgent("Mozilla").get();
        Elements elements = document.getElementsByTag("tr");
        Pattern pattern = Pattern.compile("(.+?)Req.\\SLv.\\S(\\d+) (.+)");
        for (Element element : elements) {
            String elementText = element.text();
            if(element.id().contains("mw-customcollapsible-")){
                Matcher matcher = pattern.matcher(elementText);
                Mode mode = new Mode();
                if(matcher.find()) {
                    mode.setName(matcher.group(1).trim());
                    mode.setItemLevel(Integer.valueOf(matcher.group(2)));
                    mode.setEffect(matcher.group(3));
                }
                listOfModes.add(mode);
            }
        }
        listOfModes.stream().forEach(System.out::println);
    }
}
