package com.spring;

import com.Domain.Board;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface BoardService {
    @Autowired
    List<Board> list();
    Board get(String boardNumber);
    void update(Board board);
    void delete(String boardNumber);
    void add(Board board);
    void increaseViews(Board board);
    void saveFile(Map<String, Object> map, HttpServletRequest request);
}
