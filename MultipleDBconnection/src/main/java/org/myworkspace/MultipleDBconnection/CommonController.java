package org.myworkspace.MultipleDBconnection;

import org.myworkspace.MultipleDBconnection.Author.Author;
import org.myworkspace.MultipleDBconnection.Blog.Blog;
import org.myworkspace.MultipleDBconnection.Reader.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CommonController {

    @Autowired
    private CommonService service;

    @PostMapping("/addReader")
    public Reader addReader(@RequestBody Reader reader){
        return service.addReader(reader);
    }

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author){
        return service.addAuthor(author);
    }

    @PostMapping("/addBlog")
    public Blog addBlog(@RequestBody Blog blog){
        return service.addBlog(blog);
    }
}
