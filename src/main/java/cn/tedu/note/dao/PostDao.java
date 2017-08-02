package cn.tedu.note.dao;

import org.springframework.stereotype.Repository;

import cn.tedu.note.entity.Post;
@Repository
public interface PostDao {
	Post findPostById(Integer id);
}
