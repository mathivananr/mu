package com.mu.webapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mu.Constants;
import com.mu.common.MUException;
import com.mu.model.JsonResponse;
import com.mu.model.NetworkOperator;
import com.mu.model.Payment;
import com.mu.model.RcErrorCode;
import com.mu.model.Recharge;
import com.mu.service.RechargeManager;
import com.mu.util.StringUtil;

@Controller
public class RechargeController extends BaseFormController {

	private RechargeManager rechargeManager;

	@Autowired
	public void setRechargeManager(RechargeManager rechargeManager) {
		this.rechargeManager = rechargeManager;
	}

	@RequestMapping(value = "/recharge", method = RequestMethod.GET)
	public ModelAndView showRechargeFormAsHome(
			final HttpServletRequest request, final HttpServletResponse response)
			throws MUException {
		Model model = new ExtendedModelMap();
		Recharge recharge = new Recharge();
		recharge.setAmount("10");
		model.addAttribute("recharge", recharge);
		model.addAttribute("activeMenu", "recharge-link");
		return new ModelAndView("/mu/rechargeForm", model.asMap());
	}

	@RequestMapping(value = "/rechargeForm", method = RequestMethod.GET)
	public ModelAndView showRechargeForm(final HttpServletRequest request,
			final HttpServletResponse response) throws MUException {
		Model model = new ExtendedModelMap();
		Recharge recharge = new Recharge();
		recharge.setAmount("10");
		model.addAttribute("recharge", recharge);
		model.addAttribute("activeMenu", "recharge-link");
		return new ModelAndView("/mu/rechargeForm", model.asMap());
	}

	/*
	 * @RequestMapping(value = "/paymentForm", method = RequestMethod.GET)
	 * public ModelAndView showPaymentForm(Recharge recharge, BindingResult
	 * errors, HttpServletRequest request) throws MUException { Model model =
	 * new ExtendedModelMap(); model.addAttribute("activeMenu",
	 * "recharge-link"); return new ModelAndView("/mu/paymentForm",
	 * model.asMap()); }
	 */

	@RequestMapping(value = "/initiatePayment", method = RequestMethod.POST)
	public ModelAndView initiatePayment(Recharge recharge,
			BindingResult errors, HttpServletRequest request)
			throws MUException {
		Model model = new ExtendedModelMap();
		recharge = rechargeManager.initiatePayment(recharge);
		model.addAttribute("recharge", recharge);
		model.addAttribute("payment", recharge.getPayment());
		model.addAttribute("activeMenu", "recharge-link");
		return new ModelAndView("/mu/paymentForm", model.asMap());
	}

	@RequestMapping(value = "/paymentResponse", method = RequestMethod.POST)
	public ModelAndView handlePaymentResponse(Payment payment,
			BindingResult errors, HttpServletRequest request)
			throws MUException {
		Model model = new ExtendedModelMap();
		try {
			Recharge recharge = rechargeManager.handlePaymentResponse(payment);
			if (recharge.getStatus().equalsIgnoreCase(Constants.RC_SUCCESS)) {
				saveMessage(request,
						"Your recharge " + recharge.getRechargeId() + " done.");
			} else {
				log.error("recharge failed " + recharge.getRechargeSummary());
				saveError(request, "Your recharge" + recharge.getRechargeId()
						+ "failed.");
			}
		} catch (MUException e) {
			saveMessage(request,
					"Your recharge failed. please try after some time");
		}
		model.addAttribute("activeMenu", "recharge-link");
		return new ModelAndView("/mu/rechargeForm", model.asMap());
	}

	@RequestMapping(value = "/admin/completeRecharge", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse completeRecharge(@RequestParam("id") String rechargeId) {
		JsonResponse res = new JsonResponse();
		try {
			if (!StringUtil.isEmptyString(rechargeId)) {
				rechargeManager.completeRecharge(Long.parseLong(rechargeId));
				res.setStatus(Constants.SUCCESS);
				return res;
			} else {
				res.setStatus(Constants.FAIL);
				return res;
			}
		} catch (MUException e) {
			res.setStatus(Constants.FAIL);
			return res;
		}
	}

	@RequestMapping(value = "/admin/recharges", method = RequestMethod.GET)
	public ModelAndView showRecharges(final HttpServletRequest request,
			final HttpServletResponse response) {
		Model model = new ExtendedModelMap();
		String fromMenu = request.getParameter("fromMenu");
		String from = request.getParameter("fromDate");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String to = request.getParameter("toDate");
		String status = request.getParameter("status");
		String operator = request.getParameter("operator");
		Calendar fromCal = null;
		Calendar toCal = null;
		try {
			if (!StringUtil.isEmptyString(fromMenu)) {
				fromCal = new GregorianCalendar();
				toCal = new GregorianCalendar();
				fromCal.add(Calendar.HOUR_OF_DAY, -1);
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				if (!StringUtil.isEmptyString(from)) {
					fromCal = new GregorianCalendar();
					fromCal.setTime(sdf.parse(from));
				}
				if (!StringUtil.isEmptyString(to)) {
					toCal = new GregorianCalendar();
					fromCal.setTime(sdf.parse(to));
				}
			}
			model.addAttribute(Constants.RECHARGE_LIST, rechargeManager
					.getRecharges(fromCal, toCal, email, phoneNumber, status,
							operator));
		} catch (MUException e) {
			saveError(request, "problem in getting recharges");
			log.error(e.getMessage(), e);
			model.addAttribute(Constants.RECHARGE_LIST,
					new ArrayList<Recharge>());
		} catch (ParseException e) {
			saveError(request, "problem in getting recharges");
			log.error(e.getMessage(), e);
			model.addAttribute(Constants.RECHARGE_LIST,
					new ArrayList<Recharge>());
		}
		return new ModelAndView("/admin/rechargeList", model.asMap());
	}

	@RequestMapping(value = "/admin/rechargeSummaryReport", method = RequestMethod.GET)
	public ModelAndView showRechargeSummaryReport(
			final HttpServletRequest request, final HttpServletResponse response) {
		Model model = new ExtendedModelMap();
		String fromMenu = request.getParameter("fromMenu");
		String from = request.getParameter("fromDate");
		String to = request.getParameter("toDate");
		String status = request.getParameter("status");
		Calendar fromCal = null;
		Calendar toCal = null;
		try {
			if (!StringUtil.isEmptyString(fromMenu)
					|| (StringUtil.isEmptyString(from) && StringUtil
							.isEmptyString(to))) {
				fromCal = new GregorianCalendar();
				toCal = new GregorianCalendar();
				fromCal.set(Calendar.HOUR_OF_DAY, 0);
				fromCal.set(Calendar.MINUTE, 0);
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				if (!StringUtil.isEmptyString(from)) {
					fromCal = new GregorianCalendar();
					fromCal.setTime(sdf.parse(from));
				} else {
					fromCal = new GregorianCalendar();
					fromCal.set(Calendar.HOUR_OF_DAY, 0);
					fromCal.set(Calendar.MINUTE, 0);
				}
				if (!StringUtil.isEmptyString(to)) {
					toCal = new GregorianCalendar();
					fromCal.setTime(sdf.parse(to));
				} else {
					toCal = new GregorianCalendar();
					fromCal.set(Calendar.HOUR_OF_DAY, 23);
					fromCal.set(Calendar.MINUTE, 59);
				}
			}

			if (StringUtil.isEmptyString(status)) {
				status = Constants.RC_SUCCESS;
			}

			List<Map<String, String>> summaries = rechargeManager.getRecharges(
					fromCal, toCal, status);
			int totalAmount = 0;
			for (Map<String, String> summary : summaries) {
				totalAmount = totalAmount
						+ Integer.parseInt(summary.get("amount"));
			}
			model.addAttribute(Constants.RECHARGE_SUMMARIES, summaries);
			model.addAttribute(Constants.TOTAL_AMOUNT, totalAmount);
		} catch (MUException e) {
			saveError(request, "problem in getting recharges");
			log.error(e.getMessage(), e);
			model.addAttribute(Constants.RECHARGE_SUMMARIES,
					new ArrayList<Recharge>());
		} catch (ParseException e) {
			saveError(request, "problem in getting recharges");
			log.error(e.getMessage(), e);
			model.addAttribute(Constants.RECHARGE_SUMMARIES,
					new ArrayList<Recharge>());
		}
		return new ModelAndView("/admin/rechargeSummaryReport", model.asMap());
	}

	@RequestMapping(value = "/admin/networkOperator", method = RequestMethod.GET)
	public ModelAndView showNetworkOperatorPage(
			final HttpServletRequest request, final HttpServletResponse response)
			throws MUException {
		Model model = new ExtendedModelMap();
		String networkOperatorId = request.getParameter("id");
		if (!StringUtil.isEmptyString(networkOperatorId)) {
			model.addAttribute("networkOperator", rechargeManager
					.getNetworkOperatorById(Long.parseLong(networkOperatorId)));
		} else {
			model.addAttribute("networkOperator", new NetworkOperator());
		}
		return new ModelAndView("/admin/networkOperator", model.asMap());
	}

	@RequestMapping(value = "/admin/networkOperators", method = RequestMethod.GET)
	public ModelAndView showNetworkOperators(final HttpServletRequest request,
			final HttpServletResponse response) {
		Model model = new ExtendedModelMap();
		try {
			model.addAttribute(Constants.NETWORK_OPERATOR_LIST,
					rechargeManager.getAllNetworkOperators());
		} catch (MUException e) {
			log.error(e.getMessage(), e);
			model.addAttribute(Constants.NETWORK_OPERATOR_LIST,
					new ArrayList<NetworkOperator>());
		}
		return new ModelAndView("/admin/networkOperatorList", model.asMap());
	}

	@RequestMapping(value = "/admin/saveNetworkOperator", method = RequestMethod.POST)
	public ModelAndView saveNetworkOperator(NetworkOperator networkOperator,
			BindingResult errors, HttpServletRequest request) {
		Model model = new ExtendedModelMap();
		try {
			Calendar now = new GregorianCalendar();
			if (StringUtil.isEmptyString(networkOperator.getId())) {
				networkOperator.setCreatedOn(now);
			}
			networkOperator.setUpdatedOn(now);
			rechargeManager.saveNetworkOperator(networkOperator);
			saveMessage(request, "Network operator saved successfully.");
			model.addAttribute(Constants.NETWORK_OPERATOR_LIST,
					rechargeManager.getAllNetworkOperators());
		} catch (MUException e) {
			log.error(e.getMessage(), e);
			model.addAttribute(Constants.NETWORK_OPERATOR_LIST,
					new ArrayList<NetworkOperator>());
		}
		return new ModelAndView("/admin/networkOperatorList", model.asMap());
	}

	@RequestMapping(value = "/admin/rcErrorCode", method = RequestMethod.GET)
	public ModelAndView showRcErrorCodePage(final HttpServletRequest request,
			final HttpServletResponse response) throws MUException {
		Model model = new ExtendedModelMap();
		String rcErrorCodeId = request.getParameter("id");
		if (!StringUtil.isEmptyString(rcErrorCodeId)) {
			model.addAttribute("rcErrorCode", rechargeManager
					.getRcErrorCodeById(Long.parseLong(rcErrorCodeId)));
		} else {
			model.addAttribute("rcErrorCode", new RcErrorCode());
		}
		return new ModelAndView("/admin/rcErrorCode", model.asMap());
	}

	@RequestMapping(value = "/admin/rcErrorCodes", method = RequestMethod.GET)
	public ModelAndView showRcErrorCodes(final HttpServletRequest request,
			final HttpServletResponse response) {
		Model model = new ExtendedModelMap();
		try {
			model.addAttribute(Constants.RC_ERROR_CODE_LIST,
					rechargeManager.getAllRcErrorCodes());
		} catch (MUException e) {
			log.error(e.getMessage(), e);
			model.addAttribute(Constants.RC_ERROR_CODE_LIST,
					new ArrayList<RcErrorCode>());
		}
		return new ModelAndView("/admin/rcErrorCodeList", model.asMap());
	}

	@RequestMapping(value = "/admin/saveRcErrorCode", method = RequestMethod.POST)
	public ModelAndView saveRcErrorCode(RcErrorCode rcErrorCode,
			BindingResult errors, HttpServletRequest request) {
		Model model = new ExtendedModelMap();
		try {
			rechargeManager.saveRcErrorCode(rcErrorCode);
			saveMessage(request, "Recharge error code saved successfully.");
			model.addAttribute(Constants.RC_ERROR_CODE_LIST,
					rechargeManager.getAllRcErrorCodes());
		} catch (MUException e) {
			log.error(e.getMessage(), e);
			model.addAttribute(Constants.RC_ERROR_CODE_LIST,
					new ArrayList<RcErrorCode>());
		}
		return new ModelAndView("/admin/rcErrorCodeList", model.asMap());
	}
}
