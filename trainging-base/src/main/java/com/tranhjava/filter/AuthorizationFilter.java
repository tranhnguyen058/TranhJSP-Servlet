package com.tranhjava.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranhjava.constant.SystemConstant;
import com.tranhjava.model.UserModel;
import com.tranhjava.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.setContext(filterConfig.getServletContext());
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		String url = req.getRequestURI();
		if (url.startsWith("/admin")) {
			UserModel model = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
			if (model != null) {
				if (model.getRole().getCode().equals(SystemConstant.ADMIN)) {
					chain.doFilter(servletRequest, servletResponse);
				} else if (model.getRole().getCode().equals(SystemConstant.USER)) {
					resp.sendRedirect(
							req.getContextPath() + "/dang-nhap?action=login&message=not_permission&alert=danger");
				}
			} else {
				resp.sendRedirect(
						req.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
			}
		} else {
			chain.doFilter(servletRequest, servletResponse);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

}
