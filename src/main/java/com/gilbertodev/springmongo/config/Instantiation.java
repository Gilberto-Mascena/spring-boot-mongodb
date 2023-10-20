package com.gilbertodev.springmongo.config;

import com.gilbertodev.springmongo.domain.Post;
import com.gilbertodev.springmongo.domain.User;
import com.gilbertodev.springmongo.dto.AuthorDTO;
import com.gilbertodev.springmongo.repositories.PostRepository;
import com.gilbertodev.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User Carlos = new User(null, "Carlos Black", "carlos@gmail.com");
        User Jose = new User(null, "Jose Orange", "jose@gmail.com");
        User Rita = new User(null, "Rita Grey", "rita@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob, Carlos, Jose, Rita));

        Post post1 = new Post(null, sdf.parse("20/10/2023"), "Partiu viagen", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("19/10/2023"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
