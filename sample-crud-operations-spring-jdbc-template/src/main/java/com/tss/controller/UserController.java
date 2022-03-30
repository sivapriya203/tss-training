package com.tss.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.tss.pojo.User;
import com.tss.service.UserService;
import com.tss.util.Utility;

@Controller
public class UserController {
	private UserService svc;

	public UserController(Connection connection) {
		svc = UserService.init(connection);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("user") User user) throws SQLException {
		ModelAndView mav = new ModelAndView();
		if (Utility.isValidMobileNo(user.getPhoneNo())) {
			svc.add(user);
			mav.addObject("msg", "user added");
		} else {
			mav.addObject("msg", "please enter valid mobileNo");
		}
		mav.setViewName("message");
		return mav;
	}

	@RequestMapping(value = "/get/update", method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute("user") User user) throws SQLException {
		svc.update(user);
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "data updated");
		mav.setViewName("message");
		return mav;
	}

	@RequestMapping(value = "/delete/{phone}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String phone) throws SQLException {
		svc.delete(phone);
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "data deleted");
		mav.setViewName("message");
		return mav;
	}

	@RequestMapping(value = "/getdata", method = RequestMethod.POST)
	public ModelAndView get(@ModelAttribute("user") User user) throws SQLException {
		Map<String, Object> map = svc.get(user.getPhoneNo());
		ModelAndView mav = new ModelAndView();
		map.get(user.getName());
		mav.addObject("name", map.get("name"));
		mav.addObject("phone", user.getPhoneNo());
		mav.setViewName("Welcome");
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ModelAndView list(@ModelAttribute("user") User user) throws SQLException {
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> listOfRecords = svc.list();
		mav.addObject("records", listOfRecords);
		mav.setViewName("listOfRecords");
		return mav;
	}

	@RequestMapping(value = "/get/{phoneNo}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable String phoneNo) throws SQLException {
		Map<String, Object> map = svc.get(phoneNo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", map.get("name"));
		mav.addObject("phoneNo", map.get("phoneNo"));
		mav.setViewName("update");
		return mav;
	}
}