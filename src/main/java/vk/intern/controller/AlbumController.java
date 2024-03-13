package vk.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import vk.intern.client.ProxyService;
import vk.intern.entity.Album;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static vk.intern.constants.ProxyConstant.API_ALBUM;

@RestController
@RequestMapping(API_ALBUM)
public class AlbumController {

    @Autowired
    private ProxyService<Album> proxyService;

    @GetMapping(
            consumes = APPLICATION_JSON_VALUE,
            path = "/{id}"
    )
    @Cacheable(value = "albums", key = "#id")
    public Album getAlbum(@PathVariable String id) {
        return proxyService.forwardGetRequest("/albums/" + id, Album.class);
    }

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            path = ""
    )
    @CachePut(value = "albums", key = "#result.id")
    public Album postAlbum(@RequestBody Album album) {
        return proxyService.forwardPostRequest("/albums", album, Album.class);
    }

    @PutMapping(
            consumes = APPLICATION_JSON_VALUE,
            path = "/{id}"
    )
    @CachePut(value = "albums", key = "#result.id")
    public void putAlbum(@PathVariable String id, @RequestBody Album album) {
        proxyService.forwardPutRequest("/albums/" + id, album);
    }

    @DeleteMapping(
            consumes = APPLICATION_JSON_VALUE,
            path = "/{id}"
    )
    @CacheEvict(value = "albums", key = "#id")
    public void deleteAlbum(@PathVariable String id) {
        proxyService.forwardDeleteRequest("/albums/" + id);
    }
}
