package cn.tedu.note.dao;

import cn.tedu.note.entity.Note;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("noteDao")
public interface NoteDao {
	List<Map<String, Object>> findNoteByNoteId(String noteId);
	int addNote(Note note);
	int upNotebookIdbyNoteId(@Param("notebookId")String notebookId,@Param("noteId")String noteId);
	List<Map<String, Object>> findNotes(@Param("notebookId")String notebookId,@Param("userId")String userId,@Param("statusId")String statusId);
	int deleteNotes(@Param("ids")String... ids);
	int saveNote(@Param("noteId") String noteId,@Param("body")String body,@Param("title")String title);
	int tombstoneNote(String noteId);
}
