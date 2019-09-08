package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Orderform;
import com.dao.IOrderformDao;
import com.util.DbcpPool;

public class OrderformDaoImpl implements IOrderformDao {

	@Override
	public int save(Orderform orderform) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO tb_orderform (cno,ano," + "mno"
				+ ",symptom) " + "VALUES(?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0;
		try {
			//ono和date在数据库自动生成（自增）
			ps.setString(1, orderform.getCno());
			ps.setString(2, orderform.getAno());
			ps.setString(3, orderform.getMno());
			ps.setString(4, orderform.getSymptom());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public List<Orderform> find(String ono, String sql) {
		// TODO Auto-generated method stub

		ResultSet rs = DbcpPool.executeQuery(sql);
		List<Orderform> list = new ArrayList<Orderform>();
		try {
			while (rs.next()) {
				Orderform orderform = new Orderform();
				orderform.setOno(rs.getInt("ono"));
				orderform.setCno(rs.getString("cno"));
				orderform.setAno(rs.getString("ano"));
				orderform.setMno(rs.getString("mno"));
				Timestamp timestamp = rs.getTimestamp("date");
				orderform.setDate(new Date(timestamp.getTime()));
				
				list.add(orderform);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}

	@Override
	public int delete(String ono) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tb_orderform WHERE ono = '" + ono + "'";
		System.out.println("sql:" + sql);
		int result = 0;
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		return result;
	}

	@Override
	public int update(String ono, Orderform orderform) {
		// TODO Auto-generated method stub
		String sql = "UPDATE tb_orderform SET cno=?,ano=?,mno=?,"
				+ "symptom=? WHERE ono=?";

		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0;
		try {
			ps.setString(1, orderform.getCno());
			ps.setString(2, orderform.getAno());
			ps.setString(3, orderform.getMno());
			ps.setString(4, orderform.getSymptom());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public Orderform findByOrderformId(String ono) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_orderform WHERE ono = '" + ono + "'";
		Orderform orderform = new Orderform();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			if (rs.next()) {
				orderform.setOno(rs.getInt("ono"));
				orderform.setCno(rs.getString("cno"));
				orderform.setAno(rs.getString("ano"));
				orderform.setMno(rs.getString("mno"));
				Timestamp timestamp = rs.getTimestamp("date");
				orderform.setDate(new Date(timestamp.getTime()));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return orderform;
	}

	@Override
	public List<Orderform> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_orderform ORDER BY ono";
		List<Orderform> list = new ArrayList<Orderform>();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			while (rs.next()) {
				Orderform orderform = new Orderform();				
				orderform.setOno(rs.getInt("ono"));
				orderform.setCno(rs.getString("cno"));
				orderform.setAno(rs.getString("ano"));
				orderform.setMno(rs.getString("mno"));
				Timestamp timestamp = rs.getTimestamp("date");
				orderform.setDate(new Date(timestamp.getTime()));

				list.add(orderform);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}
}
