package com.spring;

import com.Domain.Board;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BoardDaoMybatis implements BoardDao {

    @Autowired
  //  private SqlSessionTemplate sqlSession;

    public List<Board> list() {
        System.out.println("list dao");
       // List<Board> tmpList=sqlSession.selectList("list");
        //return tmpList;
        return null;
    }

    public void add(Board board) {
        System.out.println("add dao");
        //sqlSession.selectOne("add",board);
    }

    public void delete(String boardNumber) {
        System.out.println("delete dao");
       // sqlSession.selectOne("delete",boardNumber);
        updateBoardnumberWhenDelete(boardNumber);
    }

    public void update(Board board) {
        System.out.println("udpate dao");
        //sqlSession.selectOne("update",board);
    }

    public Board get(String boardnumber) {
        System.out.println("get dao");
      //  Board post=(Board)sqlSession.selectOne("get",boardnumber);
        increaseViews(boardnumber);
        //return post;
        return null;
    }

    public void increaseViews(String boardnumber) {
        System.out.println("increaseViews dao");
      //  int views=Integer.parseInt((String) sqlSession.selectOne("getViews",boardnumber))+1;
        Board board=new Board();
        board.setBoardnumber(boardnumber);
        //board.setViews(String.valueOf(views));
        //sqlSession.selectOne("increase",board);
    }

    public int numberOfPost(){
        System.out.println("numberOfPost dao");
       // int number=sqlSession.selectOne("count");
        return 0;
    }
    public void updateBoardnumberWhenDelete(String boardnumber){
        int boardnum=Integer.parseInt(boardnumber);
        int totalnum=numberOfPost();
        Board board=new Board();
        for(int i=boardnum+1;i<=totalnum;i++){
            board.setBoardnumber(String.valueOf(i));
            board.setViews(String.valueOf(i-1));
           // sqlSession.selectOne("updateBoardnumber",board);
         }
    }
}