package com.spring;

import com.Domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;


public class MemberDaoMybatis implements MemberDao {

    @Autowired
  //  private SqlSessionTemplate sqlSession;

    public boolean loginCheck(Member member) {
        System.out.println("loginCheck dao");
      // String name= (String) sqlSession.selectOne("loginCheck",member);
      // System.out.println("loginCheckDao"+name);
       //return name==null? false:true;
        return false;
    }

    public Member viewMember(Member member) {
        //return (Member) //sqlSession.selectOne("viewMember",member);
        return null;
    }

    public void logout(HttpSession httpSession) {
    }

}
