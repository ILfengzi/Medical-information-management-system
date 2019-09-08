package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Agency;
import com.dao.IAgencyDao;
import com.factory.DaoFactory;

/**
 * Servlet implementation class AgencyServlet
 */
@WebServlet("/AgencyServlet")
public class AgencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgencyServlet() {
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
		} else if ("login".equals(action)) {
			login(request, response);
		} else if ("agencyupdate".equals(action)) {
			agencyupdate(request, response);
		}

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String ano = request.getParameter("ano");
		String apassword = request.getParameter("apassword");
		IAgencyDao agencyDao = DaoFactory.getAgencyDaoInstance();
		System.out.println("ano:" + ano + "password:" + apassword);
		boolean loginStatus = agencyDao.login(ano, apassword);
		if (loginStatus) {
			List<Agency> list = agencyDao.findAll();
			System.out.println("list:" + list);
			// 创建session
			HttpSession session = request.getSession();
			session.setAttribute("agencyList", list);
			response.sendRedirect("index.html");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<script>alert(\"账号或密码错误\");</script>");
			response.getWriter().write("<script>window.location='loginform.html';window.close();</script>");
			response.getWriter().close();
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Agency agency = new Agency();
		String ano = request.getParameter("agencyano");
		System.out.println("你好");
		
		agency.setAname(request.getParameter("agencyname"));
		agency.setAsex(request.getParameter("gender"));
		agency.setAphone(request.getParameter("phone"));
		agency.setApassword(request.getParameter("password"));
		agency.setAremark(request.getParameter("aremarks"));

		IAgencyDao agencyDao = DaoFactory.getAgencyDaoInstance();
		agencyDao.update(ano, agency);

		List<Agency> list = agencyDao.findAll();

		// 创建session
		HttpSession session = request.getSession();
		session.setAttribute("agencyList", list);

		request.getRequestDispatcher("agency/agencyAdmin").forward(request, response);
		// response.sendRedirect("user/userUpdate.jsp");

	}

	private void agencyupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String agency = request.getParameter("name");
		request.setAttribute("agency", DaoFactory.getAgencyDaoInstance().findByAgencyId(agency));
		request.getRequestDispatcher("agency/agencyUpdate.jsp").forward(request, response);

	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("come in find（）");
		request.setCharacterEncoding("UTF-8");

		// 获取查询方式和关键字
		String type = request.getParameter("column");
		String keyword = request.getParameter("value");

		// 默认查询所有的用户信息
		String sql = "SELECT * FROM tb_agency";
		// 如果查询关键字不为空，则重定义SQL语句
		if (keyword != null) {
			sql = "SELECT * FROM tb_agency WHERE " + type + " LIKE '%" + keyword + "%'";
		}

		String ano = request.getParameter("ano");
		List<Agency> list = DaoFactory.getAgencyDaoInstance().find(ano, sql);

		// 创建session
		HttpSession session = request.getSession();
		session.setAttribute("agencyList", list);

		response.sendRedirect("agency/agencyAdmin.jsp");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String agency = request.getParameter("name");
		DaoFactory.getAgencyDaoInstance().delete(agency);
		list(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("come in list()");
		List<Agency> list = DaoFactory.getAgencyDaoInstance().findAll();

		// 在Servlet中创建session内置对象
		HttpSession session = request.getSession();
		session.setAttribute("agencyList", list);
		response.sendRedirect("agency/agencyAdmin.jsp");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Agency agency = new Agency();
		
		agency.setAname(request.getParameter("agencyname"));
		agency.setAsex(request.getParameter("gender"));
		agency.setAphone(request.getParameter("phone"));
		agency.setApassword(request.getParameter("password"));
		agency.setAno(request.getParameter("agencyano"));
		System.out.println(agency.getAno());
		agency.setAremark(request.getParameter("aremarks"));

		IAgencyDao agencyDao = DaoFactory.getAgencyDaoInstance();
		agencyDao.save(agency);

		List<Agency> list = agencyDao.findAll();

		// 创建session
		HttpSession session = request.getSession();
		session.setAttribute("agencyList", list);
		response.sendRedirect("agency/agencyAdmin.jsp");
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
