package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Client;
import com.dao.IClientDao;
import com.factory.DaoFactory;

/**
 * Servlet implementation class AgencyServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
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
		} else if ("clientupdate".equals(action)) {
			clientupdate(request, response);
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client();
		String cno = request.getParameter("clientcno");
		System.out.println("你好");
		
		client.setCname(request.getParameter("clientname"));
		client.setCsex(request.getParameter("gender"));
		client.setCage(request.getParameter("cage"));
		client.setCaddress(request.getParameter("caddress"));
		client.setCphone(request.getParameter("phone"));
		client.setCremark(request.getParameter("cremark"));

		IClientDao clientDao = DaoFactory.getClientDaoInstance();
		clientDao.update(cno, client);

		List<Client> list = clientDao.findAll();

		// 创建session
		HttpSession session = request.getSession();
		session.setAttribute("clientList", list);

		request.getRequestDispatcher("client/clientAdmin").forward(request, response);
		// response.sendRedirect("user/userUpdate.jsp");

	}

	private void clientupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String client = request.getParameter("name");
		request.setAttribute("client", DaoFactory.getClientDaoInstance().findByClientId(client));
		request.getRequestDispatcher("client/clientUpdate.jsp").forward(request, response);

	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("come in find（）");
		request.setCharacterEncoding("UTF-8");

		// 获取查询方式和关键字
		String type = request.getParameter("column");
		String keyword = request.getParameter("value");

		// 默认查询所有的用户信息
		String sql = "SELECT * FROM tb_client";
		// 如果查询关键字不为空，则重定义SQL语句
		if (keyword != null) {
			sql = "SELECT * FROM tb_client WHERE " + type + " LIKE '%" + keyword + "%'";
		}

		String cno = request.getParameter("cno");
		List<Client> list = DaoFactory.getClientDaoInstance().find(cno, sql);

		// 创建session
		HttpSession session = request.getSession();
		session.setAttribute("clientList", list);

		response.sendRedirect("client/clientAdmin.jsp");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String client = request.getParameter("name");
		DaoFactory.getClientDaoInstance().delete(client);
		list(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("come in list()");
		List<Client> list = DaoFactory.getClientDaoInstance().findAll();

		// 在Servlet中创建session内置对象
		HttpSession session = request.getSession();
		session.setAttribute("clientList", list);
		response.sendRedirect("client/clientAdmin.jsp");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Client client = new Client();
		
		client.setCno(request.getParameter("clientcno"));
		client.setCname(request.getParameter("clientname"));
		client.setCsex(request.getParameter("gender"));
		client.setCage(request.getParameter("cage"));
		client.setCaddress(request.getParameter("caddress"));
		client.setCphone(request.getParameter("phone"));
		client.setCremark(request.getParameter("cremark"));

		IClientDao clientDao = DaoFactory.getClientDaoInstance();
		clientDao.save(client);

		List<Client> list = clientDao.findAll();

		// 创建session
		HttpSession session = request.getSession();
		session.setAttribute("clientList", list);
		response.sendRedirect("client/clientAdmin.jsp");
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
