package com.csrm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.csrm.entity.User;
import com.csrm.repository.UserRepository;

@SpringBootApplication
public class CsrmApplication {
    public static void main(String[] args) {
        SpringApplication.run(CsrmApplication.class, args);
    }

    // creates a default admin the first time: admin / admin123
    @Bean
    CommandLineRunner seedAdmin(UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (users.findByUsername("admin").isEmpty()) {
                User a = new User();
                a.username = "admin";
                a.password = encoder.encode("admin123");
                a.role = "ADMIN";
                a.status = "APPROVED";
                users.save(a);
            }
        };
    }
}
