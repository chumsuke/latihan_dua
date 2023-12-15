package com.example.blog_swagger.service;

import com.example.blog_swagger.models.BlogPost;
import com.example.blog_swagger.repository.BlogPostRepository;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository repository;

    public BlogPost createPost(BlogPost post) {
        return repository.save(post);
    }

    public BlogPost getPostById(Long postId) {
        return repository.findById(postId).orElse(null);
    }

    public List<BlogPost> getAllPosts() {
        return repository.findAll();
    }

    public List<BlogPost> getAllPostsDesc() {
        Sort sort = Sort.by(Sort.Order.desc("id")); // Assuming 'id' is the field to sort
        return repository.findAll(sort);
    }

    public BlogPost updatePost(Long postId, BlogPost updatedPost) {
        BlogPost existingPost = repository.findById(postId).orElse(null);

        if (existingPost != null) {
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setBody(updatedPost.getBody());
            existingPost.setAuthor(updatedPost.getAuthor());
            return repository.save(existingPost);
        }

        return null; // Handle not found scenario
    }

    public void deletePost(Long postId) {
        repository.deleteById(postId);
    }
}
