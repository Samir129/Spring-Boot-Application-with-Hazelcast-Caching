package com.example.demo2;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Cacheable("books")
    public String getBookNameByIsbn(String isbn){
        return findBookSlowly(isbn);
    }
    private String findBookSlowly(String isbn){
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        return "This is a random book name";
    }
}

