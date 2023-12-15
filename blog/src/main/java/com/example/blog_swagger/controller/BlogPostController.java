package com.example.blog_swagger.controller;

import com.example.blog_swagger.models.BlogPost;
import com.example.blog_swagger.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {
    @Autowired
    private BlogPostService service;

    @PostMapping
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost post) {
        BlogPost createdPost = service.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @RequestMapping("/desc")
    public ResponseEntity<List<BlogPost>> getAllPostsDesc() {
        List<BlogPost> posts = service.getAllPostsDesc();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<BlogPost> getPostById(@PathVariable Long postId) {
        BlogPost post = service.getPostById(postId);

        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllPosts() {
        List<BlogPost> posts = service.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<BlogPost> updatePost(@PathVariable Long postId, @RequestBody BlogPost updatedPost) {
        BlogPost post = service.updatePost(postId, updatedPost);

        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        service.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
