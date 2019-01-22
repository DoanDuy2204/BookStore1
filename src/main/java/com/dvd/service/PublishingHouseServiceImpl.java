package com.dvd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.dao.PublishingHouseDao;
import com.dvd.entity.PublishingHouse;

@Service
@Transactional
public class PublishingHouseServiceImpl implements PublishingHouseService {

	//Autowrite PublishingHouseDao
	@Autowired
	private PublishingHouseDao publishingHouseDao;
	
	//Get All PublishingHouse
	@Override
	public List<PublishingHouse> getPublishingHouse(int total){
		return publishingHouseDao.getPublishingHouse(total);
	}

	//Get ID publishingHouse First
	@Override
	public int getIdPublishingHouseFirst() {
		return publishingHouseDao.getIdPublishingHouseFirset();
	}

	@Override
	public PublishingHouse getPublishingHouseById(int idPublishingHouse) {
		return publishingHouseDao.getPublishingHouseById(idPublishingHouse);
	}

}
