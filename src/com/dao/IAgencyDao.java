package com.dao;

import java.util.List;

import com.bean.Agency;

public interface IAgencyDao {
	/**
	 *经办人登录
	 * @param ano 经办人编号
	 * @param apassword 密码
	 * @return 若登录成功返回true，否则false 
	 */
	public boolean login(String ano, String apassword);
	
	/**
	 * 保存经办人
	 * @param agency 保存的经办人
	 * @return 受影响的记录个数
	 */
	public int save(Agency agency);
	
	/**
	 * 根据编号查询
	 * @param ano 经办人编号
	 * @return 结果集
	 */
	public List<Agency> find(String ano, String sql);
	
	/**
	 * 根据编号删除
	 * @param ano 经办人编号
	 * @return 受影响的记录个数
	 */	
	public int delete(String ano);
	
	/**
	 * 根据编号修改信息
	 * @param ano 经办人编号
	 * @param agency 新的经办人信息
	 * @return 受影响的记录个数
	 */
	public int update(String ano, Agency agency);
	
	/**
	 * 查找所有经办人信息
	 * @return List类型的经办人信息
	 */
	public List<Agency> findAll();
	
	/**
	 * 根据经办人编号查找单个经办人
	 * @param ano 经办人编号
	 * @return Agency对象
	 */
	public Agency findByAgencyId(String ano);

}
