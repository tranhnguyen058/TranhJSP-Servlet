package com.tranhjava.admincontroller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranhjava.constant.SystemConstant;
import com.tranhjava.model.NewModel;
import com.tranhjava.paging.PageRequest;
import com.tranhjava.paging.Pageble;
import com.tranhjava.service.ICategoryService;
import com.tranhjava.service.INewService;
import com.tranhjava.sort.Sorter;
import com.tranhjava.utils.FormUtil;
import com.tranhjava.utils.MessageUtil;
@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {
 /**
	 * 
	 */
	private static final long serialVersionUID = 4769859425780814386L;
	
	@Inject
	private INewService newService;
	@Inject
	private ICategoryService categoryService;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	NewModel model =FormUtil.toModel(NewModel.class, req);
	String view ="";
	if(model.getType().equals(SystemConstant.LIST)) {
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
		new Sorter(model.getSortName(), model.getSortBy()));
		model.setListResult(newService.findAll(pageble));
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem()/model.getMaxPageItem()));
		view = "/views/admin/new/list.jsp";
	} else if (model.getType().equals(SystemConstant.EDIT)) {
		if(model.getId() != null) {
			model = newService.findOne(model.getId());
		}
		req.setAttribute("categories", categoryService.findAll());
		view = "/views/admin/new/edit.jsp";
		
		}
	MessageUtil.showMessage(req);
	req.setAttribute(SystemConstant.MODEL, model);
	RequestDispatcher rdDispatcher = req.getRequestDispatcher(view);
	rdDispatcher.forward(req, resp);
	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
