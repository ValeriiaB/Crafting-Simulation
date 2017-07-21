package com.example.demo;


import com.example.demo.EnumClasses.ActionTypeEnum;
import com.example.demo.EnumClasses.ModeTypeEnum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserFirstVersion implements Parser {

    Map<ModeTypeEnum, ArrayList<Mode>> listOfModesGroupByType = new HashMap<>();
    static final String SITE = "http://pathofexile.gamepedia.com/";

    public void parsingData(String url) throws IOException {
        Document document = Jsoup.connect(SITE + url).userAgent("Mozilla").get();
        Elements elements = document.getElementsByTag("div");
        Set<String> temporaryTypesSet = new HashSet<String>(Arrays.asList("Prefix", "Suffix", "Corrupted"));
        for (Element element : elements ) {
            if(!element.getElementsByTag("span").isEmpty() && temporaryTypesSet.contains(element.getElementsByTag("span").get(0).id())){
                ModeTypeEnum key = ModeTypeEnum.valueOf(element.getElementsByTag("span").get(0).id().toUpperCase());
                ArrayList<Mode> listOfModes = new ArrayList<>();
                Elements tableRows = element.getElementsByTag("tr");
                for(Element row : tableRows){
                    if(row.id().contains("mw-customcollapsible-")){
                        Mode mode = new Mode();
                        if(!row.text().contains(",")) {
                            modeBuilder(row.text(), mode);
                        }
                        else{
                            String rowContent[] = row.text().split(",");
                            modeBuilder(rowContent[0], mode);
                            Pattern patternForChild = Pattern.compile("\\w*\\W*(\\d+)-(\\d+)\\)(.*)");
                            Matcher matcher = patternForChild.matcher(rowContent[1]);
                            if(matcher.find()){
                                mode.setMinValueChild(Integer.valueOf(matcher.group(1)));
                                mode.setMaxValueChild(Integer.valueOf(matcher.group(2)));
                                mode.setEffectChild(matcher.group(3));
                            }
                        }
                        mode.setModeTypeEnum(key);
                        listOfModes.add(mode);
                    }
                }
                listOfModesGroupByType.put(key, listOfModes);
            }
        }
 }

    private void modeBuilder(String rowContent, Mode mode){
        Pattern pattern = Pattern.compile("(.+?)Req\\W*Lv\\.\\W*(\\d+)\\s\\w*\\W*(\\d+)-(\\d+)\\)(.*)");
        Matcher matcher = pattern.matcher(rowContent);
        if (matcher.find()) {
            mode.setName(matcher.group(1).trim());
            mode.setItemLevel(Integer.valueOf(matcher.group(2)));
            mode.setMinValue(Integer.valueOf(matcher.group(3)));
            mode.setMaxValue(Integer.valueOf(matcher.group(4)));
            mode.setEffect(matcher.group(5));
            if (mode.getEffect().contains("increase"))
                mode.setActionTypeEnum(ActionTypeEnum.INCREASE);
            else if (mode.getEffect().contains("+"))
                mode.setActionTypeEnum(ActionTypeEnum.ADD);
            else
                mode.setActionTypeEnum(ActionTypeEnum.DEFAULT);
        }
    }
}
