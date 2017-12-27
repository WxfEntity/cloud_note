package cn.wxf.note.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Note  implements Serializable{
	private static final long serialVersionUID = -1961463179958821612L;

	private  Long id;


	private String userId;

	private String notebookId;

	private String noteId;
	/**
	 * 回收站状态：0
	 * 正常状态：1
	 */

	private Integer statusId=1;

	private String typeId;

	private String title;

	private String body;

	private Timestamp createTime;

	private Timestamp lastTime;


	private Integer watchNumber=0;


	private boolean isBlog =false;

	/**
	 * 分类名
	 */
	private String categoryName;
	/** 评论数**/
	private Integer commentNum;

	private String describtion;

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isBlog() {
		return isBlog;
	}

	public void setBlog(boolean blog) {
		isBlog = blog;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}


	public boolean getIsBlog() {
		return isBlog;
	}

	public void setIsBlog(boolean isBlog) {
		this.isBlog = isBlog;
	}

	public Integer getWatchNumber() {
		return watchNumber;
	}

	public void setWatchNumber(Integer watchNumber) {
		this.watchNumber = watchNumber;
	}

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
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
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
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLastTime() {
		return lastTime;
	}
	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}
	@Override
	public String toString() {
		return "Note [userId=" + userId + ", notebookId=" + notebookId + ", noteId=" + noteId + ", statusId=" + statusId
				+ ", typeId=" + typeId + ", title=" + title + ", body=" + body + ", createTime=" + createTime
				+ ", lastTime=" + lastTime + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Note note = (Note) o;
		if (isBlog != note.isBlog) return false;
		if (id != null ? !id.equals(note.id) : note.id != null) return false;
		if (userId != null ? !userId.equals(note.userId) : note.userId != null) return false;
		if (notebookId != null ? !notebookId.equals(note.notebookId) : note.notebookId != null) return false;
		if (noteId != null ? !noteId.equals(note.noteId) : note.noteId != null) return false;
		if (statusId != null ? !statusId.equals(note.statusId) : note.statusId != null) return false;
		if (typeId != null ? !typeId.equals(note.typeId) : note.typeId != null) return false;
		if (title != null ? !title.equals(note.title) : note.title != null) return false;
		if (body != null ? !body.equals(note.body) : note.body != null) return false;
		if (createTime != null ? !createTime.equals(note.createTime) : note.createTime != null) return false;
		if (lastTime != null ? !lastTime.equals(note.lastTime) : note.lastTime != null) return false;
		return watchNumber != null ? watchNumber.equals(note.watchNumber) : note.watchNumber == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (notebookId != null ? notebookId.hashCode() : 0);
		result = 31 * result + (noteId != null ? noteId.hashCode() : 0);
		result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
		result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (body != null ? body.hashCode() : 0);
		result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
		result = 31 * result + (lastTime != null ? lastTime.hashCode() : 0);
		result = 31 * result + (watchNumber != null ? watchNumber.hashCode() : 0);
		result = 31 * result + (isBlog ? 1 : 0);
		return result;
	}
}
