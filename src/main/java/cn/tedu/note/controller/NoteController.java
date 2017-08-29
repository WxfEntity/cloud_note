package cn.tedu.note.controller;

import cn.tedu.note.entity.Note;
import cn.tedu.note.service.NoteException;
import cn.tedu.note.service.NoteIdNotFoundException;
import cn.tedu.note.service.NoteService;
import cn.tedu.note.utils.XwpfTUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

	/**
	 * 下载功能
	 * @param noteId
	 * @param response
	 * @return
	 */
	@RequestMapping("/downloadNote.do")
	@ResponseBody
	public JsonResult download(String noteId,HttpServletResponse response) throws IOException {
		try {
			System.out.print("212222");
			List<Map<String, Object>> list =noteService.Note(noteId);
			Map<String,Object> map= list.get(0);
			XwpfTUtil xwpfTUtil = new XwpfTUtil();
			XWPFDocument doc;
			InputStream is = getClass().getClassLoader().getResourceAsStream("note.docx");
			doc = new XWPFDocument(is);
			xwpfTUtil.replaceInPara(doc,map);
			OutputStream os = response.getOutputStream();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition","attachment;filename="+"笔记"+".docx");
			doc.write(os);
			xwpfTUtil.close(os);
			xwpfTUtil.close(is);
			return new JsonResult(0);
		}catch (IOException e){

			return new JsonResult(1);
		}


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
