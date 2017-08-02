package cn.tedu.note.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.service.NoteBookService;
import cn.tedu.note.service.NotebookIdNotFoundException;
@RequestMapping("/notebook")
@Controller
public class NotebookController extends AbstractController {
	@Resource
	private NoteBookService noteBookService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult list(String userId){
			List<Map<String, Object>> list = noteBookService.listNotebooks(userId);	
		return new JsonResult(list);
	}
	@RequestMapping("/note.do")
	@ResponseBody
	public JsonResult noteTitle(String notebookId){
		List<Map<String, Object>> list = noteBookService.listNote(notebookId);
		return new JsonResult(list);
	}
	
	@ExceptionHandler(NotebookIdNotFoundException.class)
	@ResponseBody
	public JsonResult NotebookIdException(NotebookIdNotFoundException e){
		e.printStackTrace();
		return new JsonResult(5,e);
	}
	@RequestMapping("/page.do")
	@ResponseBody
	public JsonResult list(String userId,String page){
		Integer paged = Integer.valueOf(page);
			List<Map<String, Object>> list = noteBookService.listNotebooks(userId,paged);	
		return new JsonResult(list);
	}
}
