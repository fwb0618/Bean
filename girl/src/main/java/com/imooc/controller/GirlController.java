package com.imooc.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.util.ResultUtil;

@RestController
public class GirlController {

	private final static Logger logger=LoggerFactory.getLogger(GirlController.class);
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
    private GirlService girlService;
	
	@GetMapping(value="/girls")
	public List<Girl> girlList(){
		logger.info("girlList");
		return girlRepository.findAll();
	}
	
	@PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }
	
	@GetMapping(value="/girls/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id) {
		return girlRepository.findOne(id);
	}
	
	@PutMapping(value="/girls/{id}")
	public Girl girlUpdate(@PathVariable("id") Integer id,
							@RequestParam("cupSize") String cupSize,
							@RequestParam("age") Integer age) {
		Girl girl=new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
		return girlRepository.save(girl);
	}
	
	@DeleteMapping(value="/girls/{id}")
	public void girlDelete(@PathVariable("id") Integer id) {
		girlRepository.delete(id);
	}
	
	@GetMapping(value="/girls/age/{age}")
	public List<Girl> girlListByAge(@PathVariable("age") Integer age){
		return girlRepository.findByAge(age);
	}
	
	@PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
