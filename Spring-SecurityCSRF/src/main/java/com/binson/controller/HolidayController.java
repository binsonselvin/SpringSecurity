package com.binson.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.binson.model.Holiday;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HolidayController {
	
	@RequestMapping("/holidays/{display}")
	public String getHolidayPage(@PathVariable String display , Model model) {
		log.info("/holidays mapped getHolidayPage() method called : "+display);
		
		if(null != display && display.equals("all")) {
			model.addAttribute("federal", true);
			model.addAttribute("festival", true);
		} else if(null != display && display.equals("federal")) {
			model.addAttribute("federal", true);
		} else if(null != display && display.equals("festival")) {
			model.addAttribute("festival", true);
		}
		
		List<Holiday> holidayLst = new ArrayList<>();
		holidayLst.add(new Holiday("May 1","Labour Day", Holiday.types.FEDERAL));
		holidayLst.add(new Holiday("October 2","Gandhi Jayanthi", Holiday.types.FEDERAL));
		holidayLst.add(new Holiday("August 15","Independence Day", Holiday.types.FEDERAL));
		holidayLst.add(new Holiday("January 14","Pongal", Holiday.types.FESTIVAL));
		holidayLst.add(new Holiday("December 25","Christmas", Holiday.types.FESTIVAL));
		
		Holiday.types[] typeArr = Holiday.types.values();
		
		
		for(Holiday.types typ: typeArr) {
			model.addAttribute(typ.toString(), holidayLst.stream().filter(holiday -> 
				holiday.getType().equals(typ)).collect(Collectors.toList()));
		}
		
		return "holidays.html";
	}	
	
	public static void main(String[] args) {
		HolidayController controller = new HolidayController();
		Model model = (Model) new ModelAndView();
		//controller.getHolidayPage(model);
	}
}
