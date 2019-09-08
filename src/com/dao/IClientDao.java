package com.dao;

import java.util.List;

import com.bean.Client;

public interface IClientDao {
	
	/**
	 * 保存顾客
	 * @param client 保存的顾客
	 * @return 受影响的记录个数
	 */
	public int save(Client client);
	
	/**
	 * 根据编号查询
	 * @param cno 顾客编号
	 * @return 结果集
	 */
	public List<Client> find(String cno, String sql);
	
	/**
	 * 根据编号删除
	 * @param cno 顾客编号
	 * @return 受影响的记录个数
	 */	
	public int delete(String cno);
	
	/**
	 * 根据编号修改信息
	 * @param cno 顾客编号
	 * @param client 新的顾客信息
	 * @return 受影响的记录个数
	 */
	public int update(String cno, Client client);
	
	/**
	 * 查找所有顾客信息
	 * @return List类型的顾客信息
	 */
	public List<Client> findAll();
	
	/**
	 * 根据顾客编号查找单个顾客
	 * @param cno 顾客编号
	 * @return Client对象
	 */
	public Client findByClientId(String cno);

}
