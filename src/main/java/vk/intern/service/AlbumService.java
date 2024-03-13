package vk.intern.service;

import org.springframework.stereotype.Service;
import vk.intern.entity.Album;

@Service
public class AlbumService {
    public Album proxyGet(Long id) {
        return new Album(); //todo
    }

    public void proxyPost(Long id) {
    }

    public void proxyPut(Long id) {
    }

    public void proxyDelete(Long id) {
    }
}
