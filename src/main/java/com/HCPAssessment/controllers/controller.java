package com.HCPAssessment.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.HCPAssessment.models.user;
import com.HCPAssessment.models.userlist;

@RestController
public class controller {

	
	@GetMapping("https://dev.app.homecarepulse.com/Primary/?FlowId=7423bd80-cddb-11ea-9160-326dddd3e106&Action=api")
	public List<String> helloWorld() throws IOException {
	/*	RestTemplate restTemplete = new RestTemplate();
		List<user> users = new ArrayList<>();
		users = restTemplete.getForEntity("https://jsonplaceholder.typicode.com/todos", user.class);
		ResponseEntity<user> user = restTemplete.getForEntity("https://jsonplaceholder.typicode.com/todos", user.class);
		System.out.println("user: ");
		return user;*/
		RestTemplate restTemplate = new RestTemplate();


		ResponseEntity<user> u = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/1", user.class);
	
		List<ResponseEntity> users = new ArrayList<>();
		
		List<String> list = new ArrayList<>();
		
		for (Integer i = 1; i < 2; i++) {
		String	uri = "https://jsonplaceholder.typicode.com/todos/";
			String id = i.toString();
			System.out.println("id: " + id);
			uri = uri + id;
			
			System.out.println(uri);
		
		
			u = restTemplate.getForEntity(uri, user.class);
			System.out.println("user: " + u.getClass());

			//users.add(u);
		

			
			

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<user> result = restTemplate.exchange(uri, HttpMethod.GET, entity, user.class);

		System.out.println("headers:" + headers.size());
		System.out.println("entity:" + entity.toString());
		System.out.println("Printing GET Response in POJO");
		System.out.println("###########################################");
		users.add(result);

		}
		System.out.println(users.size());
		for (ResponseEntity user : users) {
			user n = new user();
			n = (com.HCPAssessment.models.user) user.getBody();
			System.out.println(n.toString());
			list.add(n.toString());
		}
	/*	userlist l = restTemplate.getForObject(
				  "http://localhost:8080/employees",
				  userlist.class);
				List<user> userlists = l.getUsers();*/
		/*System.out.println(list);
		String uri = "http://localhost:8080/hello";
		restTemplate.postForObject(
				  uri,
				  list,
				  ResponseEntity.class);*/
		System.out.println("list: " + list);
		return list;
	}
	
	@GetMapping("/hello2")
	public String hello() throws IOException {
		String uri = "https://dev.app.homecarepulse.com/Primary/?FlowId=7423bd80-cddb-11ea-9160-326dddd3e106&Action=api";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	   @RequestMapping(value = "/hello2", method = RequestMethod.POST, produces="application/json")
	   public String createProducts(@RequestBody user user) {
		   RestTemplate restTemplate = new RestTemplate();
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<user> entity = new HttpEntity<user>(user, headers);

	      return restTemplate.exchange(
	         "https://dev.app.homecarepulse.com/Primary/?FlowId=7423bd80-cddb-11ea-9160-326dddd3e106&Action=api", HttpMethod.POST, entity, String.class).getBody();
	   }

}
