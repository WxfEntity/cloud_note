package cn.wxf.note.entity;



import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by TYZ027 on 2017/11/28.
 */

public class BlogDiscuss implements Serializable{

    private Integer id;


    private String noteId;


    private Timestamp createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer replyId;


    private Integer LikeTimes;

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getLikeTimes() {
        return LikeTimes;
    }

    public void setLikeTimes(Integer likeTimes) {
        LikeTimes = likeTimes;
    }
}
