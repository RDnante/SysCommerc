package com.example.syscom.model;

import com.example.syscom.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Articletest extends Article{
    @Autowired
    ArticleRepository articleRepository;

    public void test() {

    }

}
