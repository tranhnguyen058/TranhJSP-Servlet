package com.tranhjava.utils;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	public static void showMessage(HttpServletRequest req) {
		if (req.getParameter("message")!= null) {
			String messageResponse = "";
			String alert ="";
			String message = req.getParameter("message");
			if(message.equals("insert_success")) {
				messageResponse = "Insert Success";
				alert = "success";
			} else if (message.equals("update_success")) {
				messageResponse = "Update Success";
				alert = "success";
			} else if (message.equals("delete_success")) {
				messageResponse = "Delete Success";
				alert = "success";
			} else if (message.equals("error_system")) {
				messageResponse = "Error System";
				alert = "danger";
			}
			req.setAttribute("messageResponse", messageResponse);
			req.setAttribute("alert", alert);
		}
		
	}
}
