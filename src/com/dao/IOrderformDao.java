package com.dao;

import java.util.List;

import com.bean.Orderform;

public interface IOrderformDao {
	
	/**
	 * 保存订单
	 * @param orderform 保存的订单
	 * @return 受影响的记录个数
	 */
	public int save(Orderform orderform);
	
	/**
	 * 根据编号查询
	 * @param ono 订单编号
	 * @return 结果集
	 */
	public List<Orderform> find(String ono, String sql);
	
	/**
	 * 根据编号删除
	 * @param ono 订单编号
	 * @return 受影响的记录个数
	 */	
	public int delete(String ono);
	
	/**
	 * 根据编号修改信息
	 * @param ono 订单编号
	 * @param orderform 新的订单信息
	 * @return 受影响的记录个数
	 */
	public int update(String ono, Orderform orderform);
	
	/**
	 * 查找所有订单信息
	 * @return List类型的订单信息
	 */
	public List<Orderform> findAll();
	
	/**
	 * 根据订单编号查找单个订单
	 * @param ono 药品编号
	 * @return Orderform对象
	 */
	public Orderform findByOrderformId(String ono);
}
