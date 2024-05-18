package ru.kpfu.itis.springbootsemestrovka;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import ru.kpfu.itis.springbootsemestrovka.SpringBootSemestrovkaApplication;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootSemestrovkaApplication.class);
    }

}

