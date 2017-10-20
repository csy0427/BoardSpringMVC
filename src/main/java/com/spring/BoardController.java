package com.spring;

import com.Domain.Board;
import com.Domain.Member;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(HttpRequest.class);

    @Autowired
    private BoardService boardService;

    @RequestMapping(value="/")
    public String test(){
        return "index";
    }

    @RequestMapping(value = "list.do")
    public ModelAndView list(HttpSession httpSession) throws Exception{
        List<Board> tmpBoardList = boardService.list();
        httpSession.setAttribute("boardList",tmpBoardList);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("list");
        modelAndView.addObject("boardList",tmpBoardList);
        return modelAndView;
    }

    @RequestMapping(value = "read.do",method = RequestMethod.GET)
    public ModelAndView get(@RequestParam String boardnumber, HttpSession httpSession){
        Board tmpPost=boardService.get(boardnumber);
        boardService.increaseViews(tmpPost);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("read");
        httpSession.setAttribute("post",tmpPost);
        modelAndView.addObject("post",tmpPost);
        modelAndView.addObject("file",httpSession.getAttribute("file"));
        return modelAndView;
    }

    @RequestMapping(value = "updateForm.do")
    public String updateForm(@ModelAttribute Board board) throws Exception{
        return "/board/updateForm";
    }

    @RequestMapping(value = "update.do",method = RequestMethod.POST)
    public String update(@ModelAttribute Board board, HttpSession session) throws Exception{
        System.out.println("update method called**********");
        System.out.println(board.toString());
        boardService.update(board);
        return "redirect:list.do";
    }

    @RequestMapping(value= "delete.do")
    public String delete (@RequestParam String boardnumber,HttpSession session){
        String realId=boardService.get(boardnumber).getId();
        //권한 확인...
        if(session.getAttribute("id").equals(realId)){
            System.out.println("delete controller");
            boardService.delete(boardnumber);
        }
        return "redirect:list.do";
    }

    @RequestMapping(value = "write.do", method = RequestMethod.GET)
    public String write(@ModelAttribute Board board, @ModelAttribute Member member, HttpSession httpSession){
        return "/board/writeForm";
    }

    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    public String add(@ModelAttribute Board board, HttpSession httpSession){
        board.setId((String) httpSession.getAttribute("id"));
        boardService.add(board);
        //File savingFile= new File();
        return "redirect:list.do";
    }

    @RequestMapping(value = "upload.do", method = RequestMethod.GET)
    public String fileForm(){
       return "test";
    }

    @RequestMapping(value = "upload.do")
    public String fileUp(MultipartHttpServletRequest multi,HttpSession httpSession) {
        System.out.println("fileUp method called");
        // 저장 경로 설정
        String root = multi.getSession().getServletContext().getRealPath("/");
        String path = root+"resources/file/";

        String newFileName = ""; // 업로드 되는 파일명

        File dir = new File(path);

        if(!dir.isDirectory()){
            dir.mkdir();
        }

        Iterator<String> files = multi.getFileNames();
        while(files.hasNext()){
            String uploadFile = files.next();

            MultipartFile mFile = multi.getFile(uploadFile);
            String fileName = mFile.getOriginalFilename();
            System.out.println("실제 파일 이름 : " +fileName);
            newFileName = System.currentTimeMillis()+"."
                    +fileName.substring(fileName.lastIndexOf(".")+1);

            try {
                mFile.transferTo(new File(path+newFileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        httpSession.setAttribute("file",multi);
        System.out.println("id : " + multi.getParameter("id"));
        System.out.println("pw : " + multi.getParameter("pw"));

        return "/board/writeForm";
    }
}
