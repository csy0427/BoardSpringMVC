package com.spring;

import com.Domain.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;

@Repository
public class MemberDaoMybatis implements MemberDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public boolean loginCheck(Member member) {
        System.out.println("loginCheck dao");
       String name= (String) sqlSession.selectOne("loginCheck",member);
       System.out.println("loginCheckDao"+name);
       return name==null? false:true;
    }

    public Member viewMember(Member member) {
        return (Member) sqlSession.selectOne("viewMember",member);
    }

    public void logout(HttpSession httpSession) {
    }

}
