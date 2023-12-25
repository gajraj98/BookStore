package com.BookStore.Service;

import com.BookStore.Dao.MyBookListRepository;
import com.BookStore.Pojo.MyBookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    @Autowired
    private MyBookListRepository myBookListRepository;

    public void save(MyBookList book){
        myBookListRepository.save(book);
    }
    public List<MyBookList> getAllMyBooks(){
        return myBookListRepository.findAll();
    }
    public void deleteById(int id){
        myBookListRepository.deleteById(id);
    }
}
