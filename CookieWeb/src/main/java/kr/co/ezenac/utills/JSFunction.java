package kr.co.ezenac.utills;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

public class JSFunction {

	public static void alertLocation(String msg, String url, JspWriter out) throws IOException {
		String script = "" + "<script>" + "		alert( '" + msg + "');" +"		loacation.href='"+url+"';" + "</script>";

		out.println(script);
	}

	public static void alertBack(String msg, String url, JspWriter out) throws IOException {
		String script = "" + "<script>" + "		alert( '" + msg + "');" + "		history.back();" + "</script>";

		out.println(script);
	}

}