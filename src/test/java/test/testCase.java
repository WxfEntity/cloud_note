package test;

import cn.tedu.note.dao.NoteBookDao;
import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.dao.PersonDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.Note;
import cn.tedu.note.entity.Person;
import cn.tedu.note.entity.User;
import cn.tedu.note.service.NoteBookService;
import cn.tedu.note.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class testCase {
	ClassPathXmlApplicationContext ctx;
	@Before
	public void before(){
		ctx = new ClassPathXmlApplicationContext("conf/spring-mvc.xml","conf/spring-mybatis.xml","conf/spring-service.xml");
		
	}
	@After
	public void closeCtx(){
		
	}
	
	@Test
	public void test1(){
		UserDao dao = ctx.getBean("userDao", UserDao.class);
		User user=dao.findByName("Demo");
		System.out.println(user);
	}
	@Test
	public void test2(){
		UserService us = ctx.getBean("userService", UserService.class);

		User user = us.login("zhouj", "55587a910882016321201e6ebbc9f595");
		System.out.println(user);
	}
	@Test
	public void test4(){
		UserService us = ctx.getBean("userService", UserService.class);
		User user = us.regist("zhangjie", "runtu", "123456", "123456");
		System.out.println(user);
	}
	@Test
	public void test3(){
		UserDao dao = ctx.getBean("userDao", UserDao.class);
		User u = new User();
		String id = UUID.randomUUID().toString();
		u.setId(id);
		u.setName("wuzhihui");
		u.setPassword("nihaoa");
		u.setNick("");
		u.setToken("");
		int i = dao.addUser(u);
		System.out.println(i);
	}
	@Test
	public void test5(){
		NoteBookDao dao = ctx.getBean("noteBookDao", NoteBookDao.class);
		String userId="39295a3d-cc9b-42b4-b206-a2e7fab7e77c";
		List<Map<String, Object>> list = dao.findNoteBookByUserId(userId);
		for(Map<String, Object> map:list){
			System.out.println(map);
		}
	}
	@Test
	public void test6(){
		UserDao dao = ctx.getBean("userDao", UserDao.class);
		User user = dao.findById("03590914-a934-4da9-ba4d-b41799f917d1");
		System.out.println(user);
	}
	@Test
	public void test7(){
		NoteBookDao dao = ctx.getBean("noteBookDao", NoteBookDao.class);
		String notebookId="516f6f4f-eaa3-4c76-84ff-530b92c7f64d";
		List<Map<String, Object>> list = dao.findNoteByNotebookId(notebookId);
		for(Map<String, Object> map:list){
			System.out.println(map);
		}
	}
	@Test
	public void test8(){
		NoteDao dao = ctx.getBean("noteDao", NoteDao.class);
		List<Map<String, Object>> list = dao.findNoteByNoteId("046b0110-67f9-48c3-bef3-b0b23bda9d4e");
		for(Map<String, Object> map:list){
			System.out.println(map);
		}
	}
	@Test
	public void test9(){
		NoteDao dao = ctx.getBean("noteDao", NoteDao.class);
		String userId="39295a3d-cc9b-42b4-b206-a2e7fab7e77c";
		String notebookId="4b86d1f9-6345-4532-bc50-ee86442f004b";
		String noteId=UUID.randomUUID().toString();
		System.out.println(noteId);
		String statusId="1";
		String typeId="";
		String title="打死你个丑傻逼fsdf";
		String body="";
		String createTime=String.valueOf(System.currentTimeMillis());
		String lastTime=String.valueOf(System.currentTimeMillis());
		Note note = new Note();
		note.setBody(body);
		note.setCreateTime(createTime);
		note.setLastTime(lastTime);
		note.setNotebookId(notebookId);
		note.setNoteId(noteId);
		note.setStatusId(statusId);
		note.setTitle(title);
		note.setTypeId(typeId);
		note.setUserId(userId);
		int i = dao.addNote(note);
		System.out.println(i);
	}
	@Test
	public void test10(){
		NoteDao dao = ctx.getBean("noteDao", NoteDao.class);
		String notebookId="4b86d1f9-6345-4532-bc50-ee86442f004b";
		String noteId="01da5d69-89d5-4140-9585-b559a97f9cb0";
		int i = dao.upNotebookIdbyNoteId(notebookId, noteId);
		System.out.println(i);
	}
	@Test
	public void test11(){
		NoteBookDao dao = ctx.getBean("noteBookDao", NoteBookDao.class);
		List<Map<String, Object>> list=dao.NotebookList();
		for(Map<String, Object> map:list){
			System.out.println(map);
		}
	}
	@Test
	public void test12(){
//		NoteService us = ctx.getBean("noteService", NoteService.class);
//		String userId="39295a3d-cc9b-42b4-b206-a2e7fab7e77c";
//		int stars=3;
//		boolean b = us.addStras(userId, stars);
//		System.out.println(b);
		String s= "java";
		int a = s.indexOf('v');
		System.out.println(a);
	}
	@Test
	public void test13(){
		NoteDao dao = ctx.getBean("noteDao", NoteDao.class);
		String noteId1="13e57ce4-f302-498d-a0b2-df9697dc6941";
		String noteId2="148800c2-885d-41be-bd9a-581763138074";
		String[] noteIds= {noteId1,noteId2};
		int i = dao.deleteNotes(noteIds);
		System.out.println(i);;
	}
	
	@Test
	public void test14(){
		NoteBookService ns = ctx.getBean("noteBookService", NoteBookService.class);
		String userId="39295a3d-cc9b-42b4-b206-a2e7fab7e77c";
		List<Map<String, Object>> list = ns.listNotebooks(userId, 0);
		for(Map<String, Object> map:list){
			System.out.println(map);
		}
		
	}
	@Test
	public void test15(){
		PersonDao pd = ctx.getBean("personDao", PersonDao.class);
		Person person = new Person(null,"tom");
		System.out.println(person);
		int n = pd.addPerson(person);
		
		System.out.println(n);
		System.out.println(person);
	}
	@Test
	public void test16(){
		UserService us = ctx.getBean("userService", UserService.class);
		String userId="48595f52-b22c-4485-9244-f4004255b972";
		String password ="123123";
		String newPassword="123456";
		String finalPassword="123456";
		int i =us.changePwd(userId,password,newPassword,finalPassword);
		System.out.println(i);
	}
	@Test
	public void test17(){
		NoteBookDao dao = ctx.getBean("noteBookDao", NoteBookDao.class);
		String noteBookId = UUID.randomUUID().toString();
		Timestamp createTime = new Timestamp(System.currentTimeMillis());
		String userId ="524f7440-7283-4b2d-8af5-4a67570e892e";
		String name="试一下的笔记";
		Integer i = dao.addNoteBook(userId,noteBookId,name,createTime);
	}
}
