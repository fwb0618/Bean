package com.imooc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.imooc.properties.GirlProperties;


@RestController
public class HelloController {
	@Autowired
	private GirlProperties girlProperties;
	
	//@RequestMapping(value= "/say",method=RequestMethod.GET)
	@GetMapping(value="/say")
	public String say(@RequestParam(value="id",required=false,defaultValue="0") Integer myId) {
		return "id:"+myId;
	}
	
}
