package cn.wxf.note.service.Impl;

import cn.wxf.note.dao.BlogDao;
import cn.wxf.note.dao.NoteBookDao;
import cn.wxf.note.service.BlogService;
import cn.wxf.note.utils.PageData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by TYZ027 on 2017/12/22.
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService{
    @Value("#{jdbc.userId}")
    private String userId;

    @Value("#{jdbc.pageSize}")
    private int pageSize;
    @Resource
    private BlogDao blogDao;
    @Resource
    private NoteBookDao noteBookDao;
    public PageData findBlogByTime() {
        PageData pageData=new PageData();
        List<Map<String, Object>> list = blogDao.findBlogBytime(userId,0,5);
        Integer countNum = blogDao.blogNum(userId);
        Integer pageNum = countNum/5;
        pageData.setData(list);
        pageData.setPage(1);
        pageData.setTotalPage(pageNum);
        pageData.setTotal(countNum);
        return pageData;
    }
    public Integer blogNum(){
        Integer countNum = blogDao.blogNum(userId);
        Integer pageNum = countNum/5;
        return pageNum;
    }

    public PageData nextPage(Integer page,Integer pageSize) {
        PageData pageData = new PageData();
        List<Map<String, Object>> list = blogDao.findBlogBytime(userId,(page-1)*pageSize,pageSize);
        Integer countNum = blogDao.blogNum(userId);
        Integer pageNum = countNum/5;
        pageData.setData(list);
        pageData.setPage(page);
        pageData.setTotalPage(pageNum);
        pageData.setTotal(countNum);
        return pageData;
    }

    public List<Map<String, Object>> recentBlog() {
        PageData pageData = new PageData();
        List<Map<String, Object>> list = blogDao.findBlogBytime(userId,0,4);

        return list;
    }

    public List<Map<String, Object>> classifyBlog() {
        List<Map<String, Object>> list = noteBookDao.findNoteBookByUserId(userId);
        return list;
    }
}
