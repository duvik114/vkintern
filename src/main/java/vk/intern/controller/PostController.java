package vk.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import vk.intern.client.ProxyService;
import vk.intern.entity.Post;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static vk.intern.constants.ProxyConstant.API_POST;

@RestController
@RequestMapping(API_POST)
public class PostController {

    @Autowired
    private ProxyService<Post> proxyService;

    @GetMapping(
            consumes = APPLICATION_JSON_VALUE,
            path = "/{id}"
    )
    @Cacheable(value = "posts", key = "#id")
    public Post getPost(@PathVariable String id) {
        return proxyService.forwardGetRequest("/posts/" + id, Post.class);
    }

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            path = ""
    )
    @CachePut(value = "posts", key = "#result.id")
    public Post postPost(@RequestBody Post post) {
        return proxyService.forwardPostRequest("/posts", post, Post.class);
    }

    @PutMapping(
            consumes = APPLICATION_JSON_VALUE,
            path = "/{id}"
    )
    @CachePut(value = "posts", key = "#result.id")
    public void putPost(@PathVariable String id, @RequestBody Post post) {
        proxyService.forwardPutRequest("/posts/" + id, post);
    }

    @DeleteMapping(
            consumes = APPLICATION_JSON_VALUE,
            path = "/{id}"
    )
    @CacheEvict(value = "posts", key = "#id")
    public void deletePost(@PathVariable String id) {
        proxyService.forwardDeleteRequest("/posts/" + id);
    }
}
