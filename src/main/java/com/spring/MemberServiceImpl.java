package com.spring;

import com.Domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao dao;
   //private MemberDaoMybatis memberDao;

    public boolean loginCheck(HttpSession session, Member vo) {
        System.out.println("loginCheck service");
        boolean result=dao.loginCheck(vo);
        if(result){
            Member vo2=viewMember(vo);
            session.setAttribute("id",vo2.getId());
            session.setAttribute("password",vo2.getPassword());
        }
        return result;
     // return false;
    }

    public Member viewMember(Member member) {//return dao.viewMember(member);
        return null;
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }

    public void setMemberDao(MemberDaoMybatis memberDao) {
        //this.memberDao = memberDao;
    }

    public MemberDaoMybatis getMemberDao() {
        //return memberDao;
        return null;
    }
}
