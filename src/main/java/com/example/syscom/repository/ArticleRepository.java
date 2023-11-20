package com.example.syscom.repository;

import com.example.syscom.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Integer> {

}
