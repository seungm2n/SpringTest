package kr.co.ezenstation;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = { "/req/loginform.do", "/req/loginform2.do" }, method = { RequestMethod.GET })
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/requestMessage/loginForm");
		return mav;
	}

	@RequestMapping(value = "/req/login.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		// request line
		String requestLine = request.getMethod(); // GET 또는 POST
		requestLine += " " + request.getRequestURI(); // /ezenweb/requestmessage

		String queryString = request.getQueryString(); // year=2022&month=10&day=13
		requestLine += queryString == null ? "" : "?" + queryString;
		requestLine += " " + request.getProtocol();
		System.out.println(requestLine);

		Enumeration<String> e = request.getHeaderNames();

		while (e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name + " : " + request.getHeader(name));
		}

		// request body -- POST 방식 일 때만 해당, GET은 body 가 없음
		final int CONTENT_LENGTH = request.getContentLength();
		System.out.println("CONTENT_LENGTH : " + CONTENT_LENGTH);

		if (CONTENT_LENGTH > 0) {
			try {
				request.setCharacterEncoding("utf-8");
				mav.setViewName("/requestMessage/result");

				String userId = request.getParameter("userID");
				String userName = request.getParameter("userName");

				mav.addObject("userId", userId);
				mav.addObject("userName", userName);
				
				System.out.println();
				System.out.println("userId = " + userId + "userName = " + userName);

			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

		}

		return mav;
	}
}
