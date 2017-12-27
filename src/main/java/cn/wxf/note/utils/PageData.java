package cn.wxf.note.utils;

import cn.wxf.note.service.*;

import java.io.Serializable;
import java.util.List;


public class PageData implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final int SUCCESS=0;
	private static final int ERROR=1;

	private int stata;
	private String message;
	private List data=null;
	private int total=0;
	private int page=0;

	private int totalPage;

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageData(Throwable e) {
		this.stata=ERROR;
		this.message=e.getMessage();
	}
	public PageData(List data) {
		this.stata=SUCCESS;
		this.data=data;
	}
	public PageData(String error) {
		this.stata=ERROR;
		this.message=error;
	}
	public PageData() {


	}
	public PageData(int i, UserNotFoundException e) {
		this.stata=i;
		this.message = e.getMessage();
	}
	public PageData(int i, PasswordException e) {
		this.stata=i;
		this.message = e.getMessage();
	}
	public PageData(int i, UserNameException e) {
		this.stata=i;
		this.message = e.getMessage();
	}
	public PageData(int i, NotebookIdNotFoundException e) {
		this.stata=i;
		this.message = e.getMessage();
	}

	public PageData(int i, NoteIdNotFoundException e) {
		this.stata=i;
		this.message = e.getMessage();
	}
	public PageData(int i, NoteException e) {
		this.stata=i;
		this.message = e.getMessage();
	}
	public int getStata() {
		return stata;
	}
	public void setStata(int stata) {
		this.stata = stata;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult{" +
				"stata=" + stata +
				", message='" + message + '\'' +
				", data=" + data +
				", total=" + total +
				", page=" + page +
				'}';
	}

}
