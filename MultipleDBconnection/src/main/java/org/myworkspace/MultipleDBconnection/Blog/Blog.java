package org.myworkspace.MultipleDBconnection.Blog;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "blogs")
public class Blog {
    @Id
    private String id;
    private String title;
    private String content;
}
