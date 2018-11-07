package xyz.itshark.play.graphqlspringboot.example.resolves;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.itshark.play.graphqlspringboot.example.pojo.Hello;
import xyz.itshark.play.graphqlspringboot.example.service.HelloService;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    HelloService service;

    public Hello add(String message) {
        return service.add(message);
    }
}
