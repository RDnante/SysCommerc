package com.example.syscom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.syscom.model.Article;
import com.example.syscom.repository.ArticleRepository;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public Article getArticleByIdArticle(Integer idArticle)throws Exception{
        try {
            return articleRepository.findById(idArticle).get();
        } catch (Exception e) {
            throw new Exception("Error getArticleByIdArticle");
            // TODO: handle exception
        }
    }
}
