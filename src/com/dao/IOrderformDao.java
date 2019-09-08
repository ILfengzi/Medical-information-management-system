package com.dao;

import java.util.List;

import com.bean.Orderform;

public interface IOrderformDao {
	
	/**
	 * ���涩��
	 * @param orderform ����Ķ���
	 * @return ��Ӱ��ļ�¼����
	 */
	public int save(Orderform orderform);
	
	/**
	 * ���ݱ�Ų�ѯ
	 * @param ono �������
	 * @return �����
	 */
	public List<Orderform> find(String ono, String sql);
	
	/**
	 * ���ݱ��ɾ��
	 * @param ono �������
	 * @return ��Ӱ��ļ�¼����
	 */	
	public int delete(String ono);
	
	/**
	 * ���ݱ���޸���Ϣ
	 * @param ono �������
	 * @param orderform �µĶ�����Ϣ
	 * @return ��Ӱ��ļ�¼����
	 */
	public int update(String ono, Orderform orderform);
	
	/**
	 * �������ж�����Ϣ
	 * @return List���͵Ķ�����Ϣ
	 */
	public List<Orderform> findAll();
	
	/**
	 * ���ݶ�����Ų��ҵ�������
	 * @param ono ҩƷ���
	 * @return Orderform����
	 */
	public Orderform findByOrderformId(String ono);
}
