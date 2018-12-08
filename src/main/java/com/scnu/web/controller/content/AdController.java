package com.scnu.web.controller.content;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scnu.bean.PageBean;
import com.scnu.contanst.PageCodeEnum;
import com.scnu.dto.AdDto;
import com.scnu.service.AdService;

@Controller
@RequestMapping("/ad")
public class AdController {
	
	@Autowired
	private AdService adService;

	@RequestMapping
	public String listPage() {
		return "content/list";
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody PageBean<AdDto> list(AdDto adDto) {
		PageBean<AdDto> ads = adService.searchByPage(adDto);
		return ads;
	}
	
	@RequestMapping("/addPage")
	public String addPage() {
		return "content/adAdd";
	}
	
	@RequestMapping("/editPage")
	public String editPage(Long id,Model model) {
		AdDto adDto = adService.selectById(id);
		model.addAttribute("ad", adDto);
		return "content/adUpdate";
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody Map<?,?> add(AdDto adDto) {
		PageCodeEnum pageCode = adService.add(adDto);
		return pageCode.convertToMap();
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<?,?> delete(Long id) {
		PageCodeEnum pageCode = adService.delete(id);
		return pageCode.convertToMap();
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public @ResponseBody Map<?,?> edit(AdDto adDto) {
		PageCodeEnum pageCode = adService.edit(adDto);
		return pageCode.convertToMap();
	}
}
