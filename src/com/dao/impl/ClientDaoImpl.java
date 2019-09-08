package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Client;
import com.dao.IClientDao;
import com.util.DbcpPool;

public class ClientDaoImpl implements IClientDao {


	@Override
	public int save(Client client) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO tb_client (cno,cname,csex,cage," + "caddress,cphone"
				+ ",cremark) " + "VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0;
		try {
			ps.setString(1, client.getCno());
			ps.setString(2, client.getCname());
			ps.setString(3, client.getCsex());
			ps.setString(4, client.getCage());
			ps.setString(5, client.getCaddress());
			ps.setString(6, client.getCphone());
			ps.setString(7, client.getCremark());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public List<Client> find(String cno, String sql) {
		// TODO Auto-generated method stub

		ResultSet rs = DbcpPool.executeQuery(sql);
		List<Client> list = new ArrayList<Client>();
		try {
			while (rs.next()) {
				Client client = new Client();
				client.setCno(rs.getString("cno"));
				client.setCname(rs.getString("cname"));
				client.setCsex(rs.getString("csex"));
				client.setCage(rs.getString("cage"));
				client.setCaddress(rs.getString("caddress"));
				client.setCphone(rs.getString("cphone"));
				client.setCremark(rs.getString("cremark"));
				
				list.add(client);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}

	@Override
	public int delete(String cno) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tb_client WHERE cno = '" + cno + "'";
		System.out.println("cno:" + sql);
		int result = 0;
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		return result;
	}

	@Override
	public int update(String cno, Client client) {
		// TODO Auto-generated method stub
		String sql = "UPDATE tb_client SET cname=?,csex=?,cage=?,caddress=?,cphone=?,"
				+ "cremark=? WHERE cno=?";

		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0;
		try {
			ps.setString(1, client.getCname());
			ps.setString(2, client.getCsex());
			ps.setString(3, client.getCage());
			ps.setString(4, client.getCaddress());
			ps.setString(5, client.getCphone());
			ps.setString(6, client.getCremark());
			ps.setString(7, cno);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return result;
	}

	@Override
	public Client findByClientId(String cno) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_client WHERE cno = '" + cno + "'";
		Client client = new Client();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			if (rs.next()) {
				client.setCno(rs.getString("cno"));
				client.setCname(rs.getString("cname"));
				client.setCsex(rs.getString("csex"));
				client.setCage(rs.getString("cage"));
				client.setCaddress(rs.getString("caddress"));
				client.setCphone(rs.getString("cphone"));
				client.setCremark(rs.getString("cremark"));

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return client;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_client ORDER BY cno";
		List<Client> list = new ArrayList<Client>();
		ResultSet rs = DbcpPool.executeQuery(sql);
		try {
			while (rs.next()) {
				Client client = new Client();
				client.setCno(rs.getString("cno"));
				client.setCname(rs.getString("cname"));
				client.setCsex(rs.getString("csex"));
				client.setCage(rs.getString("cage"));
				client.setCaddress(rs.getString("caddress"));
				client.setCphone(rs.getString("cphone"));
				client.setCremark(rs.getString("cremark"));
				
				list.add(client);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}
}
