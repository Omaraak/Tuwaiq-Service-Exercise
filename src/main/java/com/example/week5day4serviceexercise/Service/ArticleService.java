package com.example.week5day4serviceexercise.Service;

import com.example.week5day4serviceexercise.Model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleService {
    ArrayList<Article> articles = new ArrayList<Article>();

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public boolean updateArticle(String id, Article article) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId().equals(id)) {
                articles.set(i, article);
                return true;
            }
        }
        return false;
    }

    public boolean deleteArticle(String id) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId().equals(id)) {
                articles.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean publishArticle(String id) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId().equals(id)) {
                articles.get(i).setPublished(true);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Article> getPublishedArticles() {
        ArrayList<Article> publishedArticles = new ArrayList<>();
        for (Article article : publishedArticles) {
            if (article.isPublished()) {
                publishedArticles.add(article);
            }
        }
        return publishedArticles;
    }

    public ArrayList<Article> getArticlesByCategory(String category) {
        ArrayList<Article> articlesByCategory = new ArrayList<>();
        for (Article article : articles) {
            if (article.getCategory().equalsIgnoreCase(category)) {
                articlesByCategory.add(article);
            }
        }
        return articlesByCategory;
    }
}
