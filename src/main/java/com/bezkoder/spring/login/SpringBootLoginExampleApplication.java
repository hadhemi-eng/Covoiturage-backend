package com.bezkoder.spring.login;

import com.bezkoder.spring.login.models.Role;
import com.bezkoder.spring.login.service.AccountService;
import com.bezkoder.spring.login.utils.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringBootLoginExampleApplication implements CommandLineRunner {
    @Resource
    StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLoginExampleApplication.class, args);
    }

//    @Bean
//    CommandLineRunner start(AccountService accountService) {
//        return args -> {
//            accountService.save(new Role("PASSAGER"));
//            accountService.save(new Role("CONDUCTEUR"));
//
//            accountService.save(new Role("ADMIN"));
//        };
//    }

    public void run(String... args) throws Exception {

//         storageService.deleteAll();
//         storageService.init();
    }

    @Bean
//instentiation bech enjm n'executiha men ba3d
    BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }
}
