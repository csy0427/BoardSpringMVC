package com.spring;

import com.Domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//login
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired(required=true)
    private MemberServiceImplJpa memberService;

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
        session.setAttribute("id",vo.getId());
        boolean result=memberService.loginCheck(session, vo);
        ModelAndView modelAndView=new ModelAndView();
        String returnView="";
        if(result==true){
            System.out.println("loginCheck.do true string");
            modelAndView.addObject("msg","success");
            session.setAttribute("id",vo.getId());
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
        //session.invalidate();
        return "login";
    }

    @RequestMapping("signupForm.do")
    public String signupForm(){
        System.out.println("signupForm.do");
        return "signupForm";
    }

    @RequestMapping(value = "signup.do", method = RequestMethod.POST)
    public String signup(@ModelAttribute Member vo){
        System.out.println("signup.do");
        System.out.println(vo.getId()+"~~~~~~~~~~~~");
        memberService.signup(vo);
        return "redirect:login.do";
    }

    @ResponseBody
    @RequestMapping(value = "confirmId.do", method = RequestMethod.POST)
    public Member confirmId( @ModelAttribute("id")String id, HttpServletResponse response) throws Exception {
        System.out.println("confirmId.do");
        Member member = memberService.selectAdmin(id);
        //String returnString= (member==null)? "YES":"NO";
        return member;
    }
}
