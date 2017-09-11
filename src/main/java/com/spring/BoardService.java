package com.spring;

import com.Domain.Board;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BoardService {
    @Autowired
    List<Board> list();
    List<String> get(String boardNumber);
    void update(Board board);
    void delete(String boardNumber);
    void add(Board board);
}
