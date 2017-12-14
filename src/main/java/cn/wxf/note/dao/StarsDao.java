package cn.wxf.note.dao;

import cn.wxf.note.entity.Stars;

public interface StarsDao {
	Stars findStarsByUserId(String userId);
	int addStras(Stars stars);
	int updateStars(Stars stars);
}
