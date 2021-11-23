package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {

	private static final String API_BASE_URL = "https://cat-data.netlify.app/api/pictures/random";
	private RestTemplate restTemplate;

	public RestCatPicService() {restTemplate = new RestTemplate();}

	@Override
	public CatPic getPic() {
		String path = API_BASE_URL;
		return restTemplate.getForObject(path, CatPic.class);
	}

}	
