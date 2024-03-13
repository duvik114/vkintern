package vk.intern.service;

import org.springframework.stereotype.Service;
import vk.intern.entity.User;

@Service
public class UserService {
    public User proxyGet(Long id) {
        return new User(); //todo
    }

    public void proxyPost(Long id) {
    }

    public void proxyPut(Long id) {
    }

    public void proxyDelete(Long id) {
    }
}
