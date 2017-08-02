package cn.tedu.note.entity;

import java.io.Serializable;

public class Note  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1961463179958821612L;
	private String userId;
	private String notebookId;
	private String noteId;
	/**
	 * 回收站状态：0
	 * 正常状态：1
	 */
	private String statusId;
	private String typeId;
	private String title;
	private String body;
	private String createTime;
	private String lastTime;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNotebookId() {
		return notebookId;
	}
	public void setNotebookId(String notebookId) {
		this.notebookId = notebookId;
	}
	public String getNoteId() {
		return noteId;
	}
	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	@Override
	public String toString() {
		return "Note [userId=" + userId + ", notebookId=" + notebookId + ", noteId=" + noteId + ", statusId=" + statusId
				+ ", typeId=" + typeId + ", title=" + title + ", body=" + body + ", createTime=" + createTime
				+ ", lastTime=" + lastTime + "]";
	}
	
}
