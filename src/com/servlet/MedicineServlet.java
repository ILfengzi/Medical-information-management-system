package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Medicine;
import com.dao.IMedicineDao;
import com.factory.DaoFactory;

/**
 * Servlet implementation class AgencyServlet
 */
@WebServlet("/MedicineServlet")
public class MedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicineServlet() {
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
		} else if ("medicineupdate".equals(action)) {
			medicineupdate(request, response);
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Medicine medicine = new Medicine();
		String mno = request.getParameter("medicinemno");
		System.out.println("���");
		
		medicine.setMname(request.getParameter("medicinename"));
		medicine.setMmode(request.getParameter("mmode"));
		medicine.setMefficacy(request.getParameter("mefficacy"));

		IMedicineDao medicineDao = DaoFactory.getMedicineDaoInstance();
		medicineDao.update(mno, medicine);

		List<Medicine> list = medicineDao.findAll();

		// ����session
		HttpSession session = request.getSession();
		session.setAttribute("medicineList", list);

		request.getRequestDispatcher("medicine/medicineAdmin").forward(request, response);
		// response.sendRedirect("user/userUpdate.jsp");

	}

	private void medicineupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String medicine = request.getParameter("name");
		request.setAttribute("medicine", DaoFactory.getMedicineDaoInstance().findByMedicineId(medicine));
		request.getRequestDispatcher("medicine/medicineUpdate.jsp").forward(request, response);
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("come in find����");
		request.setCharacterEncoding("UTF-8");

		// ��ȡ��ѯ��ʽ�͹ؼ���
		String type = request.getParameter("column");
		String keyword = request.getParameter("value");

		// Ĭ�ϲ�ѯ���е��û���Ϣ
		String sql = "SELECT * FROM tb_medicine";
		// �����ѯ�ؼ��ֲ�Ϊ�գ����ض���SQL���
		if (keyword != null) {
			sql = "SELECT * FROM tb_medicine WHERE " + type + " LIKE '%" + keyword + "%'";
		}

		String mno = request.getParameter("mno");
		List<Medicine> list = DaoFactory.getMedicineDaoInstance().find(mno, sql);

		// ����session
		HttpSession session = request.getSession();
		session.setAttribute("medicineList", list);

		response.sendRedirect("medicine/medicineAdmin.jsp");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String medicine = request.getParameter("name");
		DaoFactory.getMedicineDaoInstance().delete(medicine);
		list(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("come in list()");
		List<Medicine> list = DaoFactory.getMedicineDaoInstance().findAll();

		// ��Servlet�д���session���ö���
		HttpSession session = request.getSession();
		session.setAttribute("medicineList", list);
		response.sendRedirect("medicine/medicineAdmin.jsp");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Medicine medicine = new Medicine();
		
		medicine.setMno(request.getParameter("medicinemno"));
		medicine.setMname(request.getParameter("medicinename"));
		medicine.setMmode(request.getParameter("mmode"));
		medicine.setMefficacy(request.getParameter("mefficacy"));

		IMedicineDao medicineDao = DaoFactory.getMedicineDaoInstance();
		medicineDao.save(medicine);

		List<Medicine> list = medicineDao.findAll();

		// ����session
		HttpSession session = request.getSession();
		session.setAttribute("medicineList", list);
		response.sendRedirect("medicine/medicineAdmin.jsp");
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
