package com.dvd.service;

import java.util.List;

import com.dvd.entity.PublishingHouse;

public interface PublishingHouseService {
 
	public List<PublishingHouse> getPublishingHouse(int total);
	public int getIdPublishingHouseFirst();
	public PublishingHouse getPublishingHouseById(int idPublishingHouse);
	
}
