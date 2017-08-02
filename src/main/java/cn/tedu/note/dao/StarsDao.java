package cn.tedu.note.dao;

import cn.tedu.note.entity.Stars;

public interface StarsDao {
	Stars findStarsByUserId(String userId);
	int addStras(Stars stars);
	int updateStars(Stars stars);
}
