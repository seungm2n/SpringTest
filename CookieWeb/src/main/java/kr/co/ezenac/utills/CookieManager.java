package kr.co.ezenac.utills;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {

	public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime) {

		Cookie cookie = new Cookie(cName, cValue); // 쿠키 생성
		cookie.setPath("/"); // 경로 설정
		cookie.setMaxAge(cTime); // 유지 기간
		response.addCookie(cookie); // 응답 헤더에 추가
	}

	// 쿠키 이름 삭제
	public static void deleteCookie(HttpServletResponse response, String cName) {
		makeCookie(response, cName, "", 0);
	}

	// 특정 이름의 쿠키를 찾아서 그 값을 반환함.
	public static String readCookie(HttpServletRequest request, String cName) {
		String cookieValue = "";

		Cookie[] cookies = request.getCookies(); // 요청 헤더의 모든 쿠키 열기
		if (cookies != null) {
			for (Cookie c : cookies) {
				String cookieName = c.getName(); // 쿠키 이름
				if (cookieName.equals(cName)) {
					cookieValue = c.getValue();
				}
			}
		}
		return cookieValue;
	}
}
