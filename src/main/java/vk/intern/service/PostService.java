package vk.intern.service;

import org.springframework.stereotype.Service;
import vk.intern.entity.Post;

@Service
public class PostService {
    public Post proxyGet(Long id) {
        return new Post(); //todo
    }

    public void proxyPost(Long id) {
    }

    public void proxyPut(Long id) {
    }

    public void proxyDelete(Long id) {
    }
}
