package cn.wxf.note.service;

import cn.wxf.note.utils.PageData;

import java.util.List;
import java.util.Map;

/**
 * Created by TYZ027 on 2017/12/22.
 */

public interface BlogService {
    /**
     * 加载首页blog
     * @return
     */
    PageData findBlogByTime();

    /**
     * 查询博客总数
     * @return
     */
    Integer blogNum();

    /**
     * 下一页
     * @param page
     * @param pageSize
     * @return
     */
    PageData nextPage(Integer page,Integer pageSize);

    /**
     * 最近文章
     * @return
     */
    List<Map<String,Object>> recentBlog();

    List<Map<String,Object>> classifyBlog();
}
