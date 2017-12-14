package cn.wxf.note.dao;

import org.springframework.stereotype.Repository;

import cn.wxf.note.entity.Post;
@Repository
public interface PostDao {
	Post findPostById(Integer id);
}
