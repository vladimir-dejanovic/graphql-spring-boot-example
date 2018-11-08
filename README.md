# GraphQL example implemented with Spring Boot

This is simple example of GraphQL API implemented in Java with Spring Boot, and relaying on it's magic :)

There is example of implementation of **Query** and **Subscription**.

## Dependencies

### GraphQL

For GraphQL dependency added 

```
        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphql-java</artifactId>
            <version>8.0</version>
        </dependency>
        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphql-java-tools</artifactId>
            <version>5.0.0</version>
        </dependency>
```

### GraphQL Spring Boot integration

To connect GraphQL and Spring Boot added this dependency

```
        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphql-spring-boot-starter</artifactId>
            <version>5.0.2</version>
        </dependency>
```

### GraphiQL "out of the box"

In order to get GraqhiQL, UI for testing local version of GraphQL API added this dependency

```
        <dependency>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphiql-spring-boot-starter</artifactId>
            <version>5.0.2</version>
        </dependency>

```

For GraphiQL hit http://localhost:8080/graphiql, when you start application


## Query implementation

Query implementation is almost exactly the same like all other my examples of Query. Only difference is annotation **@Component** at top.
For full code just open  [Query.java](https://github.com/vladimir-dejanovic/graphql-spring-boot-example/blob/master/src/main/java/xyz/itshark/play/graphqlspringboot/example/resolves/Query.java)

Query example in GraphiQL 
```
query {
  allData {
    message
  }
}
```

## Mutation implementation

Mutation implementation is almost exactly the same like all other my examples of Mutation. Only difference is annotation **@Component** at top.
For full code just open  [Mutation.java](https://github.com/vladimir-dejanovic/graphql-spring-boot-example/blob/master/src/main/java/xyz/itshark/play/graphqlspringboot/example/resolves/Mutation.java)

Mutation example in GraphiQL
```
mutation {
  add(message:"Hello") {
    message
  }
}
```

after mutation you can run query again and check if all worked as intended.

## Subscription implementation

Subscription implementation is done using RXJava and by implementing **GraphQLSubscriptionResolver**

For full code example check  [Subscription.java](https://github.com/vladimir-dejanovic/graphql-spring-boot-example/blob/master/src/main/java/xyz/itshark/play/graphqlspringboot/example/resolves/Subscription.java)
 
Subscription **can be** tested from GraphiQL.

Subscription example in GraphiQL
```
subscription {
  data {
    message
  }
}
```