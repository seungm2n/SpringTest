package kr.co.ezensignup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController2 {

//	@RequestMapping(value = "/register/add2", method = {RequestMethod.GET,RequestMethod.POST}) // 신규회원 가입 화면
//	@RequestMapping(value = "/register/add2")
	@GetMapping(value = "/register/add2")
	public String register() {
		return "registerForm"; // /webapp/WEB-INF/views/RegisterForm.jsp
	}

//	@RequestMapping(value = "/register/save2")
	@PostMapping(value = "/register/save2")
	public String save(User user, Model m) throws UnsupportedEncodingException {
		//1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("아이디를 잘 못 입력헀습니다.", "utf-8");
			return "redirect:/register/add2?msg="+msg;
		}
		return "registerInfo";
	}

private boolean isValid(User user) {
	// 현재 유효하지 못하게 false로 설정
	return false;
}
}
