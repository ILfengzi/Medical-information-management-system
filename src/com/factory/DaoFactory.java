package com.factory;

import com.dao.IAgencyDao;
import com.dao.IClientDao;
import com.dao.IMedicineDao;
import com.dao.IOrderformDao;
import com.dao.impl.AgencyDaoImpl;
import com.dao.impl.ClientDaoImpl;
import com.dao.impl.MedicineDaoImpl;
import com.dao.impl.OrderformDaoImpl;

public class DaoFactory {
	public static IAgencyDao getAgencyDaoInstance(){
		return new AgencyDaoImpl();
	}
	
	public static IClientDao getClientDaoInstance(){
		return new ClientDaoImpl();
	}
	
	public static IMedicineDao getMedicineDaoInstance(){
		return new MedicineDaoImpl();
	}
	
	public static IOrderformDao getOrderformDaoInstance(){
		return new OrderformDaoImpl();
	}
}
