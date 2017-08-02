package test;

import org.junit.Test;

import cn.tedu.note.dao.PostDao;
import cn.tedu.note.entity.Post;

public class PostDaoTest extends testCase{
	@Test
	public void test(){
		PostDao pd = ctx.getBean("postDao", PostDao.class);
		Post post = pd.findPostById(1);
		System.out.println(post);
	}
}
