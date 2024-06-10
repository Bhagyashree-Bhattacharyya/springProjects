package org.myworkspace.MultipleDBconnection.Blog;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "org.myworkspace.MultipleDBconnection.Blog")
public class BlogDbConfig extends AbstractMongoClientConfiguration {

    @Value("${blog.datasource.uri}")
    private String mongoUri;

    @Override
    protected String getDatabaseName() {
        return "MultiDb_blog";  // Change this to your database name
    }

    @Bean
    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}

