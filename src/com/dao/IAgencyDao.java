package com.dao;

import java.util.List;

import com.bean.Agency;

public interface IAgencyDao {
	/**
	 *�����˵�¼
	 * @param ano �����˱��
	 * @param apassword ����
	 * @return ����¼�ɹ�����true������false 
	 */
	public boolean login(String ano, String apassword);
	
	/**
	 * ���澭����
	 * @param agency ����ľ�����
	 * @return ��Ӱ��ļ�¼����
	 */
	public int save(Agency agency);
	
	/**
	 * ���ݱ�Ų�ѯ
	 * @param ano �����˱��
	 * @return �����
	 */
	public List<Agency> find(String ano, String sql);
	
	/**
	 * ���ݱ��ɾ��
	 * @param ano �����˱��
	 * @return ��Ӱ��ļ�¼����
	 */	
	public int delete(String ano);
	
	/**
	 * ���ݱ���޸���Ϣ
	 * @param ano �����˱��
	 * @param agency �µľ�������Ϣ
	 * @return ��Ӱ��ļ�¼����
	 */
	public int update(String ano, Agency agency);
	
	/**
	 * �������о�������Ϣ
	 * @return List���͵ľ�������Ϣ
	 */
	public List<Agency> findAll();
	
	/**
	 * ���ݾ����˱�Ų��ҵ���������
	 * @param ano �����˱��
	 * @return Agency����
	 */
	public Agency findByAgencyId(String ano);

}
