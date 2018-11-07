package xyz.itshark.play.graphqlspringboot.example.service;

import org.springframework.stereotype.Service;
import xyz.itshark.play.graphqlspringboot.example.pojo.Hello;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService {

    private List<Hello> list = new ArrayList();


    public List<Hello> getAll() {
        return list;
    }

    public Hello add(String message) {

        Hello hello = new Hello();
        hello.setMessage(message);

        list.add(hello);

        return hello;
    }
}
