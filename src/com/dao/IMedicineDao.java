package com.dao;

import java.util.List;

import com.bean.Medicine;

public interface IMedicineDao {
	
	/**
	 * 保存药品
	 * @param medicine 保存的药品
	 * @return 受影响的记录个数
	 */
	public int save(Medicine medicine);
	
	/**
	 * 根据编号查询
	 * @param mno 药品编号
	 * @return 结果集
	 */
	public List<Medicine> find(String mno, String sql);
	
	/**
	 * 根据编号删除
	 * @param mno 药品编号
	 * @return 受影响的记录个数
	 */	
	public int delete(String mno);
	
	/**
	 * 根据编号修改信息
	 * @param mno 药品编号
	 * @param medicine 新的药品信息
	 * @return 受影响的记录个数
	 */
	public int update(String mno, Medicine medicine);
	
	/**
	 * 查找所有药品信息
	 * @return List类型的药品信息
	 */
	public List<Medicine> findAll();
	
	/**
	 * 根据药品编号查找单个顾客
	 * @param mno 药品编号
	 * @return Medicine对象
	 */
	public Medicine findByMedicineId(String mno);
}
