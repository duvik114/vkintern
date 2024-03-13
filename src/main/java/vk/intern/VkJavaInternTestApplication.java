package vk.intern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "vk.intern.repository")
public class VkJavaInternTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(VkJavaInternTestApplication.class, args);
    }

}
