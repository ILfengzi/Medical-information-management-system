package com.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Orderform;
import com.dao.IOrderformDao;
import com.factory.DaoFactory;

/**
 * Servlet implementation class AgencyServlet
 */
@WebServlet("/OrderformServlet")
public class OrderformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderformServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		action(request, response);
	}
	
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("method");
		System.out.println("action:" + action);
		System.out.println("come in action()");
		if ("add".equals(action)) {
			add(request, response);
		} else if ("list".equals(action)) {
			list(request, response);
		} else if ("delete".equals(action)) {
			delete(request, response);
		} else if ("find".equals(action)) {
			find(request, response);
		} else if ("update".equals(action)) {
			update(request, response);
		} else if ("orderformupdate".equals(action)) {
			orderformupdate(request, response);
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Orderform orderform = new Orderform();
		String ono = request.getParameter("ono");
		System.out.println("���");
		
		orderform.setCno(request.getParameter("cno"));
		orderform.setAno(request.getParameter("ano"));
		orderform.setMno(request.getParameter("mno"));
		orderform.setSymptom(request.getParameter("symptom"));

		IOrderformDao orderformDao = DaoFactory.getOrderformDaoInstance();
		orderformDao.update(ono, orderform);

		List<Orderform> list = orderformDao.findAll();

		// ����session
		HttpSession session = request.getSession();
		session.setAttribute("orderformList", list);

		request.getRequestDispatcher("orderform/orderformAdmin").forward(request, response);
		// response.sendRedirect("user/userUpdate.jsp");

	}

	private void orderformupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderform = request.getParameter("name");
		request.setAttribute("orderform", DaoFactory.getOrderformDaoInstance().findByOrderformId(orderform));
		request.getRequestDispatcher("orderform/orderformUpdate.jsp").forward(request, response);

	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("come in find����");
		request.setCharacterEncoding("UTF-8");

		// ��ȡ��ѯ��ʽ�͹ؼ���
		String type = request.getParameter("column");
		String keyword = request.getParameter("value");

		// Ĭ�ϲ�ѯ���е��û���Ϣ
		String sql = "SELECT * FROM tb_orderform";
		// �����ѯ�ؼ��ֲ�Ϊ�գ����ض���SQL���
		if (keyword != null) {
			sql = "SELECT * FROM tb_orderform WHERE " + type + " LIKE '%" + keyword + "%'";
		}

		String ono = request.getParameter("ono");
		List<Orderform> list = DaoFactory.getOrderformDaoInstance().find(ono, sql);

		// ����session
		HttpSession session = request.getSession();
		session.setAttribute("orderformList", list);
		
		response.sendRedirect("orderform/orderformAdmin.jsp");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderform = request.getParameter("name");
		DaoFactory.getOrderformDaoInstance().delete(orderform);
		list(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("come in list()");
		List<Orderform> list = DaoFactory.getOrderformDaoInstance().findAll();

		// ��Servlet�д���session���ö���
		HttpSession session = request.getSession();
		session.setAttribute("orderformList", list);
		response.sendRedirect("orderform/orderformAdmin.jsp");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Orderform orderform = new Orderform();
		
		orderform.setCno(request.getParameter("cno"));
		orderform.setAno(request.getParameter("ano"));
		orderform.setMno(request.getParameter("mno"));
		orderform.setSymptom(request.getParameter("symptom"));
		

		IOrderformDao orderformDao = DaoFactory.getOrderformDaoInstance();
		orderformDao.save(orderform);

		List<Orderform> list = orderformDao.findAll();

		// ����session
		HttpSession session = request.getSession();
		session.setAttribute("orderformList", list);
		response.sendRedirect("orderform/orderformAdmin.jsp");
		// request.getRequestDispatcher("userAdmin.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
