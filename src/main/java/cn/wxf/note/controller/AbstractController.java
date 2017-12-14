package cn.wxf.note.controller;


import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class AbstractController {

	public AbstractController() {
		super();
	}
	protected Logger log = LoggerFactory.getLogger(getClass());
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult handleException(Exception e) {
		e.printStackTrace();
		return new JsonResult(e);
	}

}