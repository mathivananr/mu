package com.mu.service.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.mu.Constants;
import com.mu.common.MUException;
import com.mu.dao.RechargeDao;
import com.mu.model.NetworkOperator;
import com.mu.model.RcErrorCode;
import com.mu.model.Recharge;
import com.mu.service.MailEngine;
import com.mu.service.RechargeManager;
import com.mu.util.ApiUtil;
import com.mu.util.StringUtil;

@Service("rechargeManager")
public class RechargeManagerImpl extends GenericManagerImpl<Recharge, Long>
		implements RechargeManager {

	private RechargeDao rechargeDao;
	private MailEngine mailEngine;
	private SimpleMailMessage message;

	@Autowired
	public RechargeManagerImpl(RechargeDao rechargeDao) {
		super(rechargeDao);
		this.rechargeDao = rechargeDao;
	}

	@Autowired(required = false)
	public void setMailEngine(final MailEngine mailEngine) {
		this.mailEngine = mailEngine;
	}

	@Autowired(required = false)
	public void setMailMessage(final SimpleMailMessage message) {
		this.message = message;
	}

	/**
	 * {@inheritDoc}
	 */
	public Recharge saveRecharge(Recharge recharge) throws MUException {
		return rechargeDao.saveRecharge(recharge);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Recharge> getRechargeByStatus(String status) throws MUException {
		return rechargeDao.getRechargeByStatus(status);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Recharge> getAllRecharge() throws MUException {
		return rechargeDao.getAllRecharge();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Recharge> getRecharge(int from, int to) throws MUException {
		return rechargeDao.getRecharge(from, to);
	}

	/**
	 * {@inheritDoc}
	 */
	public Recharge getRechargeById(Long rechargeId) throws MUException {
		return rechargeDao.getRechargeById(rechargeId);
	}

	/**
	 * {@inheritDoc}
	 */
	public NetworkOperator saveNetworkOperator(NetworkOperator networkOperator)
			throws MUException {
		return rechargeDao.saveNetworkOperator(networkOperator);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<NetworkOperator> getAllNetworkOperators() throws MUException {
		return rechargeDao.getAllNetworkOperators();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<NetworkOperator> getNetworkOperators(String operatorType)
			throws MUException {
		return rechargeDao.getNetworkOperators(operatorType);
	}

	/**
	 * {@inheritDoc}
	 */
	public NetworkOperator getNetworkOperatorById(Long id) throws MUException {
		return rechargeDao.getNetworkOperatorById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<NetworkOperator> getMobileOperators() throws MUException {
		return rechargeDao.getMobileOperators();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<NetworkOperator> getDataCardOperators() throws MUException {
		return rechargeDao.getDataCardOperators();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<NetworkOperator> getDTHOperators() throws MUException {
		return rechargeDao.getDTHOperators();
	}

	/**
	 * {@inheritDoc}
	 */
	public RcErrorCode getRcErrorCodeById(Long id) throws MUException {
		return rechargeDao.getRcErrorCodeById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public RcErrorCode saveRcErrorCode(RcErrorCode rcErrorCode)
			throws MUException {
		return rechargeDao.saveRcErrorCode(rcErrorCode);
	}

	/**
	 * {@inheritDoc}
	 */
	public RcErrorCode getRcErrorByCode(String errorCode) throws MUException {
		return rechargeDao.getRcErrorByCode(errorCode);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<RcErrorCode> getAllRcErrorCodes() throws MUException {
		return rechargeDao.getAllRcErrorCodes();
	}

	/**
	 * {@inheritDoc}
	 */
	public Recharge completeRecharge(String rechargeId) throws MUException {
		Recharge recharge = getRechargeById(Long.parseLong(rechargeId));
		Map<String, Object> response = ApiUtil.getRequest(recharge);
		if (response.get("status").toString()
				.equalsIgnoreCase(Constants.STATUS_SUCCESS)) {
			if (response.get("response").toString().split(",")[0]
					.equalsIgnoreCase(Constants.STATUS_FAILED)) {
				recharge.setStatus(Constants.FAILED);
				recharge.setRechargeSummary(getRcErrorByCode(
						response.get("response").toString().split(",")[1])
						.getDescription());
			} else {
				recharge.setStatus(Constants.SUCCESS);
				recharge.setRechargeSummary("Recharged Succesully!");
				recharge.setReferenceId(response.get("response").toString()
						.split(",")[0]);
			}
			recharge.setReferenceDetail(response.get("response").toString());
			Calendar now = new GregorianCalendar();
			recharge.setUpdatedOn(now);
			saveRecharge(recharge);
		} else {
			recharge.setStatus(Constants.FAILED);
			recharge.setRechargeSummary(response.get("response").toString());
			saveRecharge(recharge);
		}
		return recharge;
	}

	/**
	 * {@inheritDoc}
	 */
	public Recharge proceedPayment(String rechargeId) throws MUException {
		Recharge recharge = completeRecharge(rechargeId);
		/*if (recharge.getStatus().equalsIgnoreCase(Constants.SUCCESS)) {
			sendRechargeEmail(recharge, "rechargeSuccess.vm", "Recharge Done");
		}*/
		return recharge;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Recharge> getRecharges(Calendar from, Calendar to, String email, String phoneNumber, String status) throws MUException{
		return rechargeDao.getRecharges(from, to, email, phoneNumber, status);
	}
	
	private void sendRechargeEmail(final Recharge recharge,
			final String template, final String subject) {
		message.setTo(recharge.getEmail());
		message.setSubject(subject);
		final Map<String, Serializable> model = new HashMap<String, Serializable>();
		model.put("recharge", recharge);
		mailEngine.sendMessage(message, template, model);
	}
}
