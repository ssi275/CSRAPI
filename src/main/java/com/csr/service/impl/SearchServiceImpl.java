package com.csr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.csr.dao.ReadDao;
import com.csr.entity.Charity;
import com.csr.service.SearchService;

//@PropertySource("classpath: attributes.properties")
@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	ReadDao readDao;

	@Autowired
	Environment environment;

	
	/**
	 * This method fetches a list of NGOs near a lat/long
	 * @param lat latitude
	 * @param lon longitude
	 * @return List of Ngos
	 */
	@Override
	public List<Charity> fetchNearbyNgoList(double lat, double lon) {
		List<Charity> ngoList = readDao.getNgoList();
		List<Charity> nearbyNgoList = new ArrayList<Charity>();
		HashMap<String, Double> map = new HashMap<String, Double>();
		ValueComparator bvc = new ValueComparator(map);
		TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc);
		for (Charity ngo : ngoList) {
			double latitude = ngo.getLatitude();
		double longitude = ngo.getLongitude();
			double distance = calculateDistance(lat, lon, latitude, longitude);
			if (distance < Integer.parseInt(environment.getProperty("distance"))) {
				map.put(ngo.getNgoId(), distance);
			}

		}
		sorted_map.putAll(map);
		for (Entry<String, Double> entry : sorted_map.entrySet()) {
			String key = entry.getKey();
			nearbyNgoList.add(readDao.getNgoDetail(key));
		}
		return nearbyNgoList;
	}

	/**
	 * This method calculates the distance between two places
	 * @param lat1 latitude
	 * @param lon1 longitude
	 * @param lat2 latitude
	 * @param lon2 longitude
	 * @return distance(in Km) between to two lat/long
	 */
	public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		// Distance in miles
		dist = dist * 60 * 1.1515;
		// Distance in Kilometers
		dist = dist * 1.609344;

		return dist;
	}

	/**
	 * This method converts degree to radian
	 * @param deg
	 * @return
	 */
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/**
	 * This method converts radian to degree
	 * @param rad
	 * @return
	 */
	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}
}
