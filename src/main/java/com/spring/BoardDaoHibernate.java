package com.spring;

import com.Domain.Board;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BoardDaoHibernate implements BoardDao{

    @Autowired
    SessionFactory sessionFactory;

    public List<Board> list() {
        return getCriteria().list();
    }

    public void add(Board board) {
        getSession().save(board);
    }

  public void delete(String boardnumber) {
      // String query="delete from board "+ "where boardnumber = :boardnumber";
       //getSession().createQuery(query).setParameter("boardnumber",boardnumber);
    }

    public void update(Board board) {
        getSession().update(board);
    }

    public Board get(String boardnumber) {
        return (Board) getCriteria()
                .add(Restrictions.eq("boardnumber", boardnumber))
                .uniqueResult();
    }

    public void increaseViews(String boardNumber) {

    }

    public int numberOfPost() {
        return 0;
    }

    /*
    * spring이 관리하는 session을 쓴다.
    * */
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria getCriteria() {
        //CriteriaBuilder builder=getSession().getCriteriaBuilder();
       // CriteriaQuery criteria= (CriteriaQuery) builder.createQuery(Board.class);
        //criteria.
        //return (Criteria) criteria;
        return getCriteria();
    }
}
