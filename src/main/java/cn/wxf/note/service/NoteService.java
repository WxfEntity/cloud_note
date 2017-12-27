package cn.wxf.note.service;

import cn.wxf.note.entity.Note;

import java.util.List;
import java.util.Map;

public interface NoteService {
	/**
	 * 加载笔记本列表
	 * @param noteId
	 * @return
	 * @throws NoteIdNotFoundException
	 */
	List<Map<String, Object>> Note(String noteId) throws NoteIdNotFoundException;
	/**
	 * 添加笔记本
	 * @param title
	 * @param userId
	 * @param notebookId
	 * @return
	 * @throws NoteException
	 */
	Note addnote(String title, String userId, String notebookId)throws NoteException;
	void moveNote(String notebookId,String noteId)throws NoteException;
	int deleteNotes(String... noteIds)throws NoteException;
	boolean addStras(String userId,int stars);
	void saveNote(String noteId,String body,String title)throws NoteException;
	void tombstoneNote(String noteId) throws NoteException;
	List<Map<String,Object>> showTrash(String userId)throws NoteException;
	List<Map<String,Object>> searchNote(String userId,String searchTxt);
}
