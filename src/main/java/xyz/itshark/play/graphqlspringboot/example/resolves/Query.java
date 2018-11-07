package xyz.itshark.play.graphqlspringboot.example.resolves;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.itshark.play.graphqlspringboot.example.pojo.Hello;
import xyz.itshark.play.graphqlspringboot.example.service.HelloService;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    HelloService helloService;

    public Hello hello() {

        Hello h = new Hello();
        h.setMessage("hello");

        return h;
    }

    public List<Hello> allData() {
        return helloService.getAll();
    }
}
