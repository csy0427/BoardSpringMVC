package com.spring;

import com.Domain.Board;

import java.util.List;

public interface BoardDao {
    List<Board> list();

    void add(Board board);

    void delete(String boardNumber);

    void update(Board board);

    List<String> get(String boardNumber);

    void increaseViews(String boardNumber);

    public int numberOfPost();
}
