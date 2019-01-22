package com.dvd.dao;

import java.util.List;

import com.dvd.entity.PublishingHouse;

public interface PublishingHouseDao {

	public List<PublishingHouse> getPublishingHouse(int total);
	public int getIdPublishingHouseFirset();
	public PublishingHouse getPublishingHouseById(int idPublishingHouse);
	
}
