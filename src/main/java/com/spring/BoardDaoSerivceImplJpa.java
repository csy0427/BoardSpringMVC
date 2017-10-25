package com.spring;

import com.Domain.Board;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class BoardDaoSerivceImplJpa implements BoardService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(HttpRequest.class);

    @Autowired
    private BoardDaoJpa boardDao;

    Calendar calendar;

    public List<Board> list() {
        return boardDao.findAll();
    }

    public Board get(String boardNumber) {
        Board board= boardDao.findOne(boardNumber);
        boardDao.save(board);
        return boardDao.findOne(boardNumber);
    }

    public void increaseViews(Board board){
        board.setViews(String.valueOf(Integer.parseInt(board.getViews())+1));
        boardDao.save(board);
    }

    public void update(Board board) {
        System.out.println(board.toString());
        boardDao.save(board);
    }

    public void delete(String boardNumber) {
        boardDao.delete(boardNumber);
    }

    public void add(Board board) {
        System.out.println("jpa board add");
        board.setViews("0");
        board.setBoardnumber(getBoardnumber());
        boardDao.save(board);
    }

    public String getBoardnumber(){
        calendar= Calendar.getInstance();
        String boarnumber= String.valueOf(calendar.get(Calendar.YEAR))+ String.valueOf(calendar.get(Calendar.MONTH))+
                String.valueOf(calendar.get(Calendar.DATE))+String.valueOf(calendar.get(Calendar.MILLISECOND));
        return boarnumber;
    }
}
