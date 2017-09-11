package com.spring;


import com.Domain.Member;

import javax.servlet.http.HttpSession;

public interface MemberDao {
    public boolean loginCheck(Member vo);
    public Member viewMember(Member member);
    public void logout(HttpSession httpSession);
}
