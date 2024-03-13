package vk.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import vk.intern.client.ProxyService;
import vk.intern.entity.User;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static vk.intern.constants.ProxyConstant.API_USER;

@RestController
@RequestMapping(API_USER)
public class UserController {

    @Autowired
    private ProxyService<User> proxyService;

    @GetMapping(
            consumes = APPLICATION_JSON_VALUE,
            path = "/{id}"
    )
    @Cacheable(value = "users", key = "#id")
    public User getUser(@PathVariable String id) {
        return proxyService.forwardGetRequest("/users/" + id, User.class);
    }

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            path = ""
    )
    @CachePut(value = "users", key = "#result.id")
    public User postUser(@RequestBody User user) {
        return proxyService.forwardPostRequest("/users", user, User.class);
    }

    @PutMapping(
            consumes = APPLICATION_JSON_VALUE,
            path = "/{id}"
    )
    @CachePut(value = "users", key = "#result.id")
    public void putUser(@PathVariable String id, @RequestBody User user) {
        proxyService.forwardPutRequest("/users/" + id, user);
    }

    @DeleteMapping(
            consumes = APPLICATION_JSON_VALUE,
            path = "/{id}"
    )
    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(@PathVariable String id) {
        proxyService.forwardDeleteRequest("/users/" + id);
    }
}
