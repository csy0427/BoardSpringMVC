package com.spring;

import com.Domain.Member;

import javax.servlet.http.HttpSession;

public interface MemberService {
    public boolean loginCheck(HttpSession session, Member vo);
    public Member viewMember(Member member);
    public void logout(HttpSession session);
}
