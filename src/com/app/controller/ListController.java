package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IListDao;
import com.app.pojos.RestType;

@Controller
@RequestMapping("/lists")
@CrossOrigin(origins = "http://localhost:4200")
public class ListController {

	@Autowired
	private IListDao ldao;
	
	@GetMapping("/resttypes")
	public List<String> getAllRestTypes()
	{
		List<String> lists = new ArrayList<String>();
		RestType[] rt = ldao.getRestauranTypes();
		System.out.println(rt);
		for (RestType restType : rt) {
		lists.add(restType.toString());
		}
		for (String l : lists) {
			System.out.println(l);
		}
		
		
		return lists;
	}
}
