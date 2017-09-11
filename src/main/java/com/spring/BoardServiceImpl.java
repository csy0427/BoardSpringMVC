package com.spring;

import com.Domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDao boardDao;

    public List<Board> list() {
        System.out.println("BoardService list");
        return boardDao.list();
    }

    public List<String> get(String boardNumber) {
        System.out.println("BoardService get");
        return boardDao.get(boardNumber);
    }

    public void update(Board board) {
        System.out.println("BoardService update");
        boardDao.update(board);
    }

    public void delete(String boardNumber) {
        System.out.println("BoardService delete");
        boardDao.delete(boardNumber);
    }

    public void add(Board board) {
        System.out.println("BoardService add");
        board.setViews("0");
        board.setBoardnumber(String.valueOf(numberOfPost()));
        System.out.println(board.getTitle()+board.getContent()+"***************");
        boardDao.add(board);
    }
    public void increaseViews(String boardNumber){
        System.out.println("BoardService increaseCount");
        Board board=new Board();
        boardDao.increaseViews(boardNumber);
    }

    public int numberOfPost(){
        System.out.println("numberOfPost dao");
        int number=boardDao.numberOfPost();
        return number;
    }
}
