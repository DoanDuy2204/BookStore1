package com.dvd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dvd.entity.PublishingHouse;

/**
 * This method is repository which used to contain data/object of publishingHouse and accept its in DB.
 * @author Admin
 *
 */
@Repository
public class PublishingHouseDaoImpl implements PublishingHouseDao {

	//Declare SessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * This method is used to get publishingHouse in DB.
	 * @param total : size of List
	 * @return 
	 * 		List<PublishingHouse>
	 */
	@Override
	public List<PublishingHouse> getPublishingHouse(int total) {
		Session session =  sessionFactory.getCurrentSession();
		Query<PublishingHouse> query = session.createQuery("from PublishingHouse",PublishingHouse.class);
		if(total!=-1)
			query.setFirstResult(0).setMaxResults(total);
		return query.getResultList();
	}

	/**
	 * This method is used to get Id of first publishingHouse in DB.
	 * @param 
	 * @return 
	 * 			int:id of publishingHouse
	 */
	@Override
	public int getIdPublishingHouseFirset() {
		return sessionFactory.getCurrentSession().createQuery("from PublishingHouse",PublishingHouse.class)
				.setFirstResult(0).setMaxResults(1).getSingleResult().getId();
	}

	/**
	 * This method is used to get PublishingHouse in DB by Id.
	 * @param idPublishingHouse : id of publishingHouse
	 * @return 
	 * 		PublishingHouse
	 */
	@Override
	public PublishingHouse getPublishingHouseById(int idPublishingHouse) {
		return sessionFactory.getCurrentSession().get(PublishingHouse.class, idPublishingHouse);
	}
}
