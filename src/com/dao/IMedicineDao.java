package com.dao;

import java.util.List;

import com.bean.Medicine;

public interface IMedicineDao {
	
	/**
	 * ����ҩƷ
	 * @param medicine �����ҩƷ
	 * @return ��Ӱ��ļ�¼����
	 */
	public int save(Medicine medicine);
	
	/**
	 * ���ݱ�Ų�ѯ
	 * @param mno ҩƷ���
	 * @return �����
	 */
	public List<Medicine> find(String mno, String sql);
	
	/**
	 * ���ݱ��ɾ��
	 * @param mno ҩƷ���
	 * @return ��Ӱ��ļ�¼����
	 */	
	public int delete(String mno);
	
	/**
	 * ���ݱ���޸���Ϣ
	 * @param mno ҩƷ���
	 * @param medicine �µ�ҩƷ��Ϣ
	 * @return ��Ӱ��ļ�¼����
	 */
	public int update(String mno, Medicine medicine);
	
	/**
	 * ��������ҩƷ��Ϣ
	 * @return List���͵�ҩƷ��Ϣ
	 */
	public List<Medicine> findAll();
	
	/**
	 * ����ҩƷ��Ų��ҵ����˿�
	 * @param mno ҩƷ���
	 * @return Medicine����
	 */
	public Medicine findByMedicineId(String mno);
}
