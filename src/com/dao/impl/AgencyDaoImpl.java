package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Agency;
import com.dao.IAgencyDao;
import com.util.DbcpPool;

public class AgencyDaoImpl implements IAgencyDao {

	@Override
	public boolean login(String ano, String apassword) {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) AS NUM FROM tb_agency WHERE ano='" + ano + "' AND apassword = '"
				+ apassword + "'";
		ResultSet rs = DbcpPool.executeQuery(sql);
		int result = 0;
		try {
			if (rs.next()) {
				result = rs.getInt("NUM");
			}
			System.out.println(result + "   " + rs.getInt("NUM"));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int save(Agency agency) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO tb_agency (ano,aname," + "asex,aphone"
				+ ",aremark,apassword) " + "VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0;
		try {
			ps.setString(1, agency.getAno());
			ps.setString(2, agency.getAname());
			ps.setString(3, agency.getAsex());
			ps.setString(4, agency.getAphone());
			ps.setString(5, agency.getAremark());
			ps.setString(6, agency.getApassword());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public List<Agency> find(String ano, String sql) {
		// TODO Auto-generated method stub

		ResultSet rs = DbcpPool.executeQuery(sql);
		List<Agency> list = new ArrayList<Agency>();
		try {
			while (rs.next()) {
				Agency agency = new Agency();
				agency.setAno(rs.getString("ano"));
				agency.setAname(rs.getString("aname"));
				agency.setAsex(rs.getString("asex"));
				agency.setAphone(rs.getString("aphone"));
				agency.setAremark(rs.getString("aremark"));
				agency.setApassword(rs.getString("apassword"));
				
				list.add(agency);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}

	@Override
	public int delete(String ano) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tb_agency WHERE ano = '" + ano + "'";
		System.out.println("ano:" + sql);
		int result = 0;
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		return result;
	}

	@Override
	public int update(String ano, Agency agency) {
		// TODO Auto-generated method stub
		String sql = "UPDATE tb_agency SET aname=?,"
				+ "asex=?,aphone=?,aremark=?," + "apassword=? WHERE ano=?";

		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0;
		try {
			ps.setString(1, agency.getAname());
			ps.setString(2, agency.getAsex());
			ps.setString(3, agency.getAphone());
			ps.setString(4, agency.getAremark());
			ps.setString(5, agency.getApassword());
			ps.setString(6, ano);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public Agency findByAgencyId(String ano) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_agency WHERE ano = '" + ano + "'";
		Agency agency = new Agency();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			if (rs.next()) {
				agency.setAno(rs.getString("ano"));
				agency.setAname(rs.getString("aname"));
				agency.setAsex(rs.getString("asex"));
				agency.setAphone(rs.getString("aphone"));
				agency.setAremark(rs.getString("aremark"));
				agency.setApassword(rs.getString("apassword"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return agency;
	}

	@Override
	public List<Agency> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_agency ORDER BY ano";
		List<Agency> list = new ArrayList<Agency>();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			while (rs.next()) {
				Agency agency = new Agency();
				agency.setAno(rs.getString("ano"));
				agency.setAname(rs.getString("aname"));
				agency.setAsex(rs.getString("asex"));
				agency.setAphone(rs.getString("aphone"));
				agency.setAremark(rs.getString("aremark"));
				agency.setApassword(rs.getString("apassword"));
				list.add(agency);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}
}
