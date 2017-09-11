package com.spring;

import com.Domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao dao;
    private MemberDaoMybatis memberDao;

    public boolean loginCheck(HttpSession session, Member vo) {
        System.out.println("loginCheck service");
        boolean result=dao.loginCheck(vo);
        if(result){
            Member vo2=viewMember(vo);
            session.setAttribute("id",vo2.getId());
            session.setAttribute("password",vo2.getPassword());
        }
        return result;
    }

    public Member viewMember(Member member) {
        return dao.viewMember(member);
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }

    public void setMemberDao(MemberDaoMybatis memberDao) {
        this.memberDao = memberDao;
    }

    public MemberDaoMybatis getMemberDao() {
        return memberDao;
    }
}
