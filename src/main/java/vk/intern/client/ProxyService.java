package vk.intern.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vk.intern.entity.BaseEntity;

@Service
public class ProxyService<T extends BaseEntity> {

    private final RestTemplate restTemplate;
    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    @Autowired
    public ProxyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public T forwardGetRequest(String path, Class<T> clazz) {
        return restTemplate.getForObject(baseUrl + path, clazz);
    }

    public T forwardPostRequest(String path, T body, Class<T> clazz) {
        return restTemplate.postForObject(baseUrl + path, new HttpEntity<>(body), clazz);
    }

    public void forwardPutRequest(String path, T body) {
        restTemplate.put(baseUrl + path, new HttpEntity<>(body));
    }

    public void forwardDeleteRequest(String path) {
        restTemplate.delete(baseUrl + path);
    }
}
