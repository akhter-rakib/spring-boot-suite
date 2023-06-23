package com.rakib.blogapps.controller

import com.rakib.blogapps.model.Article
import com.rakib.blogapps.repository.ArticleRepository
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/articles")
class ArticleController(private val articleRepository: ArticleRepository) {

    @GetMapping
    fun getAllArticles(): List<Article> {
        return articleRepository.findAll()
    }

    @PostMapping
    fun saveArticle(@Valid @RequestBody article: Article) {
        articleRepository.save(article)
    }

    @GetMapping("/{id}")
    fun getArticleById(@PathVariable(value = "id") articleId: Long): ResponseEntity<Article> {
        return articleRepository.findById(articleId).map { articleId ->
            ResponseEntity.ok(articleId)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun updateArticleById(
        @PathVariable(value = "id") articleId: Long, @Valid @RequestBody article: Article
    ): ResponseEntity<Article> {
        return articleRepository.findById(articleId).map { existingArticle ->
            val updatedArticle: Article = existingArticle
                .copy(title = article.title, content = article.content)
            ResponseEntity.ok().body(articleRepository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())
    }
}