package cn.wxf.note.controller;

import cn.wxf.note.service.BlogService;
import cn.wxf.note.service.NoteService;
import cn.wxf.note.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by TYZ027 on 2017/12/22.
 */
@Controller
@RequestMapping("/blog")
public class BlogController extends AbstractController{
    @Resource
    private BlogService blogService;
    @Resource
    private NoteService noteService;

    @RequestMapping("/index.do")
    public String loadFtl(Model model, HttpServletRequest request){
        PageData pageData = blogService.findBlogByTime();
        Integer pageNum = blogService.blogNum();
        model.addAttribute("pageData",pageData);
        model.addAttribute("totalPage",pageData.getTotalPage());
        model.addAttribute("page",pageData.getPage());
        model.addAttribute("total",pageData.getTotal());
        List<Map<String, Object>> recentList = blogService.recentBlog();
        model.addAttribute("recentList",recentList);
        model.addAttribute("baseurl",request.getContextPath());
        return "myBlog.ftl";
    }
    @RequestMapping("/next.do")
    public String nextPage(Model model,@RequestParam("page")Integer page, @RequestParam("pageSize")Integer pageSize,HttpServletRequest request){
        PageData pageData = blogService.nextPage(page,pageSize);
        Integer pageNum = blogService.blogNum();
        model.addAttribute("pageData",pageData);
        model.addAttribute("totalPage",pageData.getTotalPage());
        model.addAttribute("page",pageData.getPage());
        model.addAttribute("total",pageData.getTotal());
        List<Map<String, Object>> recentList = blogService.recentBlog();
        model.addAttribute("recentList",recentList);
        model.addAttribute("baseurl",request.getContextPath());
        return "myBlog.ftl";
    }
    @RequestMapping("/detail.do")
    public String detail(Model model,@RequestParam("noteId")String noteId ,HttpServletRequest request){
        List<Map<String,Object>> list = noteService.Note(noteId);
        Map<String,Object> data = list.get(0);
        model.addAttribute("title",data.get("title"));
        model.addAttribute("body",data.get("body"));
        List<Map<String, Object>> recentList = blogService.recentBlog();
        model.addAttribute("recentList",recentList);
        model.addAttribute("baseurl",request.getContextPath());
        return "blogDetail.ftl";
    }
    @RequestMapping("/classify.do")
    public String classify(){
        return null;
    }
}
