package ru.scratty.bostongene2.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.scratty.bostongene2.entity.User;
import ru.scratty.bostongene2.repository.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class DataInit implements ApplicationRunner {

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.count() == 0) {
            User user = new User("Имя", "Фамилия",
                    df.parse("2019-02-27"), " email@email.com",
                    passwordEncoder.encode("pass"));

            userRepository.save(user);
        }
    }
}
