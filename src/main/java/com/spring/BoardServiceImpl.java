package com.spring;

import com.Domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDao boardDao;

    public List<Board> list() {
        System.out.println("BoardService list");
        return boardDao.list();
    }

    public Board get(String boardNumber) {
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
        boardDao.add(board);
    }

    public void increaseViews(Board board) {

    }

    public void saveFile(Map<String, Object> map, HttpServletRequest request) {

    }

    public void save(MultipartFile file) {

    }

    public int numberOfPost(){
        System.out.println("numberOfPost dao");
        int number=boardDao.numberOfPost();
        return number;
    }
}
