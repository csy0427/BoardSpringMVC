package com.spring;

import com.Domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpSession;

//login
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired(required=true)
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
     public String test(){
        return "menu";
    }

    @RequestMapping("login.do")
    public String login(){
        return "login";
    }

    @RequestMapping("loginCheck.do")
    public String loginCheck(@ModelAttribute Member vo, HttpSession session){
        System.out.println("loginCheck.do string");
        boolean result=memberService.loginCheck(session, vo);
        ModelAndView modelAndView=new ModelAndView();
        String returnView="";
        if(result==true){
            System.out.println("loginCheck.do true string");
            modelAndView.addObject("msg","success");
            returnView="home";
        }
        else{
            System.out.println("loginCheck.do false string");
            modelAndView.addObject("msg","failure");
            returnView="login";
        }
        return returnView;
    }

    @RequestMapping("logout.do")
    public String logout(HttpSession session){
        memberService.logout(session);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","logout");
        return "login";
    }
}
