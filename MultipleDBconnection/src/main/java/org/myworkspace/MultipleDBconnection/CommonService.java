package org.myworkspace.MultipleDBconnection;

import org.myworkspace.MultipleDBconnection.Author.Author;
import org.myworkspace.MultipleDBconnection.Author.AuthorRepository;
import org.myworkspace.MultipleDBconnection.Blog.Blog;
import org.myworkspace.MultipleDBconnection.Blog.BlogRepository;
import org.myworkspace.MultipleDBconnection.Reader.Reader;
import org.myworkspace.MultipleDBconnection.Reader.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BlogRepository blogRepository;

    public Reader addReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Blog addBlog(Blog blog) {
        return blogRepository.save(blog);
    }
}
