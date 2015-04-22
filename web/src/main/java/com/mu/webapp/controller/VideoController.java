package com.mu.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mu.common.MUException;

@Controller
public class VideoController extends BaseFormController {

	@ModelAttribute
	@RequestMapping(value = "/video", method = RequestMethod.GET)
	public ModelAndView showVideoPage(final HttpServletRequest request,
			final HttpServletResponse response) throws MUException {
		Model model = new ExtendedModelMap();
		model.addAttribute("activeMenu", "video-link");
		return new ModelAndView("/mu/video", model.asMap());
	}
}
