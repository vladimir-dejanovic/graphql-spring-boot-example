package xyz.itshark.play.graphqlspringboot.example.resolves;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import xyz.itshark.play.graphqlspringboot.example.pojo.Hello;

@Component
public class Query implements GraphQLQueryResolver {

    public Hello hello() {

        Hello h = new Hello();
        h.setMessage("hello");

        return h;
    }
}
