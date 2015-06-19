package com.mu.webapp.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mu.common.MUException;
import com.mu.model.Advise;
import com.mu.model.JsonResponse;
import com.mu.service.AdviseManager;
import com.mu.util.StringUtil;

@Controller
public class AdviseController extends BaseFormController {

	private AdviseManager adviseManager;

	@Autowired
	public void setAdviseManager(AdviseManager adviseManager) {
		this.adviseManager = adviseManager;
	}

	@ModelAttribute
	@RequestMapping(value = "/advise", method = RequestMethod.GET)
	public ModelAndView showAdvisePage(final HttpServletRequest request,
			final HttpServletResponse response) throws MUException {
		Model model = new ExtendedModelMap();
		model.addAttribute("activeMenu", "advise-link");
		try {
			model.addAttribute("advises", adviseManager.getAdvise(0, 10));
		} catch (MUException e) {
			log.error(e.getMessage(), e);
		}
		return new ModelAndView("/mu/advise", model.asMap());
	}

	@RequestMapping(value = "/getAdvise", method = RequestMethod.GET)
	public @ResponseBody
	JsonResponse getAdvise(@RequestParam("adviseId") String adviseId) {
		JsonResponse res = new JsonResponse();
		try {
			res.setStatus("SUCCESS");
			if (!StringUtil.isEmptyString(adviseId) && !adviseId.equals("undefined")) {
				res.setResult(adviseManager.getAdviseById(Long
						.parseLong(adviseId)));
			} else {
				res.setResult(new Advise());
			}
			return res;
		} catch (MUException e) {
			log.error(e.getMessage(), e);
			res.setStatus("fail");
			res.setResult(new Advise());
			return res;
		}
	}

	@RequestMapping(value = "/postAdvise", method = RequestMethod.POST)
	public ModelAndView addUser(Advise advise, BindingResult errors,
			HttpServletRequest request) {
		Model model = new ExtendedModelMap();
		try {
			Calendar now = new GregorianCalendar();
			if (StringUtil.isEmptyString(advise.getId())) {
				advise.setCreatedOn(now);
				advise.setCreatedIpAddress(request.getRemoteAddr());
			}
			advise.setUpdatedOn(now);
			advise.setUpdatedIpAddress(request.getRemoteAddr());
			advise.setEnabled(true);
			adviseManager.saveAdvise(advise);
			model.addAttribute("activeMenu", "advise-link");
			model.addAttribute("advises", adviseManager.getAdvise(0, 10));
		} catch (MUException e) {
			log.error(e.getMessage(), e);
		}
		return new ModelAndView("/mu/advise", model.asMap());
	}

	/*
	 * @RequestMapping(value = "/postAdvise", method = RequestMethod.POST)
	 * public @ResponseBody JsonResponse addUser(@ModelAttribute(value =
	 * "advise") Advise advise, BindingResult result) { JsonResponse res = new
	 * JsonResponse(); try { Calendar now = new GregorianCalendar();
	 * advise.setCreatedOn(now); advise.setUpdatedOn(now);
	 * advise.setEnabled(true); adviseManager.saveAdvise(advise);
	 * res.setStatus("SUCCESS"); res.setResult(""); return res; } catch
	 * (MUException e) { log.error(e.getMessage(), e); res.setStatus("fail");
	 * res.setResult(""); return res; } }
	 */
}
