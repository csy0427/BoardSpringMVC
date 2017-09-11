package com.spring;

import com.Domain.Board;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDaoMybatis implements BoardDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<Board> list() {
        System.out.println("list dao");
        List<Board> tmpList=sqlSession.selectList("list");
        System.out.println(tmpList.get(0).getTitle()+"...................");
        return tmpList;
    }

    public void add(Board board) {
        System.out.println("add dao");
        sqlSession.selectOne("add",board);
    }

    public void delete(String boardNumber) {
        System.out.println("delete dao");
        sqlSession.selectOne("add",boardNumber);
    }

    public void update(Board board) {
        System.out.println("udpate dao");
        sqlSession.selectOne("update",board);
    }

    public List<String> get(String boardNumber) {
        System.out.println("get dao");
        List<String> post=sqlSession.selectOne("get",boardNumber);
        return post;
    }

    public void increaseViews(String boardNumber) {
        System.out.println("increaseViews dao");
        Board board=new Board();
        sqlSession.selectOne("increase",board);
    }

    public int numberOfPost(){
        System.out.println("numberOfPost dao");
        int number=sqlSession.selectOne("count");
        System.out.println(number);
        return number;
    }
}
