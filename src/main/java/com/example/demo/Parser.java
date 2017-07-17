package com.example.demo;


import java.io.IOException;


public interface Parser {
    String SITE = "http://pathofexile.gamepedia.com/";
    void parsingData(String url) throws IOException;
}
