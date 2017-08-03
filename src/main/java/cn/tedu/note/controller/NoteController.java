package cn.tedu.note.controller;

import cn.tedu.note.entity.Note;
import cn.tedu.note.service.NoteException;
import cn.tedu.note.service.NoteIdNotFoundException;
import cn.tedu.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/note")
public class NoteController extends AbstractController{
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/select.do")
	@ResponseBody
	public JsonResult note(String noteId){
		List<Map<String, Object>> list =noteService.Note(noteId);
		return  new JsonResult(list);
	}
	
	@RequestMapping("/addNote.do")
	@ResponseBody
	public JsonResult addNote(String title, String userId, String notebookId){
		Note note = noteService.addnote(title, userId, notebookId);
		return new JsonResult(note);
		
	}
	@RequestMapping("/upNotebook.do")
	@ResponseBody
	public JsonResult showNotebook(String notebookId,String noteId){
		noteService.moveNote(notebookId, noteId);
		
		return new JsonResult(0);
		
	}
	@RequestMapping("/saveNote.do")
	@ResponseBody
	public JsonResult saveNote(String noteId,String body,String title){
		noteService.saveNote(noteId,body,title);
		return new JsonResult(0);
	}

	@RequestMapping("/deleteNote.do")
	@ResponseBody
	public JsonResult deleteNote(String noteId){
		noteService.tombstoneNote(noteId);
		return new JsonResult(0);
	}
	@RequestMapping("/showTrashNote.do")
	@ResponseBody
	public JsonResult showTrash(String userId){
		List<Map<String, Object>> list = noteService.showTrash(userId);
		return new JsonResult(list);
	}
	@ExceptionHandler(NoteException.class)
	@ResponseBody
	public JsonResult NoteException(NoteException e){
		e.printStackTrace();
		
		return new JsonResult(7,e);
		
	}
	
	
	@ExceptionHandler(NoteIdNotFoundException.class)
	@ResponseBody
	public JsonResult NoteIdException(NoteIdNotFoundException e){
		e.printStackTrace();
		return new JsonResult(6,e);
		
	}
}
