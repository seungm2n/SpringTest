package kr.co.hugeleap;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice("kr.co.hugeleap.sub") // 지정된 패키지에서 발생한 예외만 처리
//@ControllerAdvice								//모든 컨트롤러에서 발생하는 예외를 다 처리하게 됨(모든 패키지에 적용)
public class SharedCatcher {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		System.out.println("catcher() in ExceptionController2.ezen()");
		System.out.println("m = " + m.getAttribute("msg"));
		
		m.addAttribute("ex", ex);			// 예외 정보가 모델에 담겨서 뷰에 전달됨
		return "error"; 
	}

	 @ExceptionHandler({ NullPointerException.class, FileNotFoundException.class})
	public String chatcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}

}
