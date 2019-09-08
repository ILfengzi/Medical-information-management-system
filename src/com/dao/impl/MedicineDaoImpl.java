package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Medicine;
import com.dao.IMedicineDao;
import com.util.DbcpPool;

public class MedicineDaoImpl implements IMedicineDao {


	@Override
	public int save(Medicine medicine) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO tb_medicine (mno,mname," + "mmode"
				+ ",mefficacy) " + "VALUES(?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0;
		try {
			ps.setString(1, medicine.getMno());
			ps.setString(2, medicine.getMname());
			ps.setString(3, medicine.getMmode());
			ps.setString(4, medicine.getMefficacy());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public List<Medicine> find(String mno, String sql) {
		// TODO Auto-generated method stub

		ResultSet rs = DbcpPool.executeQuery(sql);
		List<Medicine> list = new ArrayList<Medicine>();
		try {
			while (rs.next()) {
				Medicine medicine = new Medicine();
				medicine.setMno(rs.getString("mno"));
				medicine.setMname(rs.getString("mname"));
				medicine.setMmode(rs.getString("mmode"));
				medicine.setMefficacy(rs.getString("mefficacy"));
				
				list.add(medicine);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}

	@Override
	public int delete(String mno) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tb_medicine WHERE mno = '" + mno + "'";
		System.out.println("sql:" + sql);
		int result = 0;
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		return result;
	}

	@Override
	public int update(String mno, Medicine medicine) {
		// TODO Auto-generated method stub
		String sql = "UPDATE tb_medicine SET mno=?,mname=?,mmode=?,"
				+ "mefficacy=? WHERE mno=?";

		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0;
		try {
			ps.setString(1, medicine.getMname());
			ps.setString(2, medicine.getMmode());
			ps.setString(3, medicine.getMefficacy());
			ps.setString(4, mno);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public Medicine findByMedicineId(String mno) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_medicine WHERE mno = '" + mno + "'";
		Medicine medicine = new Medicine();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			if (rs.next()) {
				medicine.setMno(rs.getString("mno"));
				medicine.setMname(rs.getString("mname"));
				medicine.setMmode(rs.getString("mmode"));
				medicine.setMefficacy(rs.getString("mefficacy"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return medicine;
	}

	@Override
	public List<Medicine> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_medicine ORDER BY mno";
		List<Medicine> list = new ArrayList<Medicine>();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			while (rs.next()) {
				Medicine medicine = new Medicine();
				medicine.setMno(rs.getString("mno"));
				medicine.setMname(rs.getString("mname"));
				medicine.setMmode(rs.getString("mmode"));
				medicine.setMefficacy(rs.getString("mefficacy"));
				
				list.add(medicine);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}
}
