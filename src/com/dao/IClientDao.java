package com.dao;

import java.util.List;

import com.bean.Client;

public interface IClientDao {
	
	/**
	 * ����˿�
	 * @param client ����Ĺ˿�
	 * @return ��Ӱ��ļ�¼����
	 */
	public int save(Client client);
	
	/**
	 * ���ݱ�Ų�ѯ
	 * @param cno �˿ͱ��
	 * @return �����
	 */
	public List<Client> find(String cno, String sql);
	
	/**
	 * ���ݱ��ɾ��
	 * @param cno �˿ͱ��
	 * @return ��Ӱ��ļ�¼����
	 */	
	public int delete(String cno);
	
	/**
	 * ���ݱ���޸���Ϣ
	 * @param cno �˿ͱ��
	 * @param client �µĹ˿���Ϣ
	 * @return ��Ӱ��ļ�¼����
	 */
	public int update(String cno, Client client);
	
	/**
	 * �������й˿���Ϣ
	 * @return List���͵Ĺ˿���Ϣ
	 */
	public List<Client> findAll();
	
	/**
	 * ���ݹ˿ͱ�Ų��ҵ����˿�
	 * @param cno �˿ͱ��
	 * @return Client����
	 */
	public Client findByClientId(String cno);

}
