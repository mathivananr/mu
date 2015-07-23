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
import com.mu.model.Payment;
import com.mu.model.RcErrorCode;
import com.mu.model.Recharge;
import com.mu.service.MailEngine;
import com.mu.service.RechargeManager;
import com.mu.util.ApiUtil;
import com.mu.util.PropertyReader;
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
	public List<NetworkOperator> getOperators(String operatorFinderCode)
			throws MUException {
		return rechargeDao.getOperators(operatorFinderCode);
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, Object> getOperator(String number) throws MUException {
		PropertyReader reader = PropertyReader.getInstance();
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("enableSpecial", false);
		String operatorResponse = ApiUtil.getOperator(
				reader.getPropertyFromFile(Constants.DATA_TYPE_STRING,
						Constants.JOLO_OPERATOR_URL).toString(),
				reader.getPropertyFromFile(Constants.DATA_TYPE_STRING,
						Constants.JOLO_USER_ID).toString(),
				reader.getPropertyFromFile(Constants.DATA_TYPE_STRING,
						Constants.JOLO_KEY).toString(), number);
		if (!StringUtil.isEmptyString(operatorResponse)
				&& operatorResponse.contains(",")
				&& !operatorResponse.equalsIgnoreCase("0,0")
				&& !operatorResponse.split(",")[0]
						.equalsIgnoreCase(Constants.STATUS_FAILED)) {
			List<NetworkOperator> operators = getOperators(operatorResponse
					.split(",")[0]);

			if (operators != null) {
				if (operators.size() > 1) {
					response.put("enableSpecial", true);
				}
				response.put("circleCode", operatorResponse.split(",")[1]);
				response.put("networkOperator", operators.get(0));
			}
		}
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	public Recharge initiatePayment(Recharge recharge) throws MUException {
		PropertyReader reader = PropertyReader.getInstance();
		recharge.setStatus(Constants.RC_OPEN);
		Calendar now = new GregorianCalendar();
		if (StringUtil.isEmptyString(recharge.getId())) {
			recharge.setCreatedOn(now);
		}
		recharge.setUpdatedOn(now);
		recharge = saveRecharge(recharge);
		Payment payment = new Payment();
		if (reader
				.getPropertyFromFile(Constants.DATA_TYPE_STRING,
						Constants.APP_MODE).toString().equalsIgnoreCase("0")) {
			payment.setKey(reader.getPropertyFromFile(
					Constants.DATA_TYPE_STRING, Constants.PY_TEST_KEY)
					.toString());
		} else {
			payment.setKey(reader.getPropertyFromFile(
					Constants.DATA_TYPE_STRING, Constants.PY_LIVE_KEY)
					.toString());
		}
		payment.setTxnid(recharge.getId().toString());
		payment.setFirstname(reader.getPropertyFromFile(
				Constants.DATA_TYPE_STRING, Constants.PY_FIRST_NAME).toString());
		payment.setEmail(recharge.getEmail());
		payment.setPhone(recharge.getPhoneNumber());
		int amount = Integer.parseInt(recharge.getAmount()) + 1;
		if (null != reader.getPropertyFromFile(Constants.DATA_TYPE_STRING,
				Constants.MU_CONTRIBUTION)) {
			amount = Integer.parseInt(recharge.getAmount())
					+ Integer.parseInt(reader.getPropertyFromFile(
							Constants.DATA_TYPE_STRING,
							Constants.MU_CONTRIBUTION).toString());
		}
		payment.setAmount(amount + "");
		payment.setProductinfo(reader.getPropertyFromFile(
				Constants.DATA_TYPE_STRING, Constants.PY_PRODUCT_INFO)
				.toString());
		payment.setService_provider(reader.getPropertyFromFile(
				Constants.DATA_TYPE_STRING, Constants.PY_SERVICE_PROVIDER)
				.toString());
		if (reader
				.getPropertyFromFile(Constants.DATA_TYPE_STRING,
						Constants.APP_MODE).toString().equalsIgnoreCase("0")) {
			payment.setSurl(reader.getPropertyFromFile(
					Constants.DATA_TYPE_STRING, Constants.PY_TEST_SURL)
					.toString());
			payment.setFurl(reader.getPropertyFromFile(
					Constants.DATA_TYPE_STRING, Constants.PY_TEST_FURL)
					.toString());
			payment.setCurl(Constants.PY_TEST_CURL);
		} else {
			payment.setSurl(reader.getPropertyFromFile(
					Constants.DATA_TYPE_STRING, Constants.PY_LIVE_SURL)
					.toString());
			payment.setFurl(reader.getPropertyFromFile(
					Constants.DATA_TYPE_STRING, Constants.PY_LIVE_FURL)
					.toString());
			payment.setCurl(reader.getPropertyFromFile(
					Constants.DATA_TYPE_STRING, Constants.PY_LIVE_CURL)
					.toString());
		}
		if (reader
				.getPropertyFromFile(Constants.DATA_TYPE_STRING,
						Constants.APP_MODE).toString().equalsIgnoreCase("0")) {
			payment.setHash(StringUtil.generateHash(
					reader.getPropertyFromFile(Constants.DATA_TYPE_STRING,
							Constants.PY_TEST_SALT).toString(),
					reader.getPropertyFromFile(Constants.DATA_TYPE_STRING,
							Constants.PY_ENCRYPT_TYPE).toString(), payment));
		} else {
			payment.setHash(StringUtil.generateHash(
					reader.getPropertyFromFile(Constants.DATA_TYPE_STRING,
							Constants.PY_LIVE_SALT).toString(),
					reader.getPropertyFromFile(Constants.DATA_TYPE_STRING,
							Constants.PY_ENCRYPT_TYPE).toString(), payment));
		}
		recharge.setPayment(payment);
		return recharge;
	}

	/**
	 * {@inheritDoc}
	 */
	public Recharge handlePaymentResponse(Payment payment) throws MUException {
		log.info("mihpayid :: " + payment.getMihpayid() + " txnid :: "
				+ payment.getTxnid());
		Recharge recharge = rechargeDao.getRechargeById(Long.parseLong(payment
				.getTxnid()));
		if (payment.getStatus().equalsIgnoreCase(Constants.STATUS_SUCCESS)) {
			Calendar now = new GregorianCalendar();
			recharge.setUpdatedOn(now);
			recharge.setPayment(payment);
			Double amount = Double.parseDouble(payment.getAmount());
			if (amount.intValue() >= (Integer.parseInt(recharge.getAmount()) + 1)) {
				recharge.setStatus(Constants.RC_PAYMENT_SUCCESS);
				recharge = saveRecharge(recharge);
				recharge = completeRecharge(recharge.getId());
			} else {
				recharge.setStatus(Constants.RC_PAYMENT_FAILED);
				if (StringUtil.isEmptyString(recharge.getRechargeSummary())) {
					recharge.setRechargeSummary("Date :: "
							+ now.getTime()
							+ " Summary :: Recharged failed! full payment not received \n");
				} else {
					recharge.setRechargeSummary(recharge.getRechargeSummary()
							+ " Date :: "
							+ now.getTime()
							+ " Summary :: Recharged failed! full payment not received \n");
				}
				recharge = saveRecharge(recharge);
			}

		} else if (payment.getStatus().equalsIgnoreCase(Constants.RC_OPEN)) {
			Calendar now = new GregorianCalendar();
			recharge.setUpdatedOn(now);
			recharge.setPayment(payment);
			recharge.setStatus(Constants.RC_PAYMENT_FAILED);
			if (StringUtil.isEmptyString(recharge.getRechargeSummary())) {
				recharge.setRechargeSummary("Date :: " + now.getTime()
						+ " Summary :: Recharged failed! payment canceled \n");
			} else {
				recharge.setRechargeSummary(recharge.getRechargeSummary()
						+ " Date :: " + now.getTime()
						+ "Summary :: Recharged failed! payment canceled \n");
			}
			recharge = saveRecharge(recharge);
		} else {
			Calendar now = new GregorianCalendar();
			recharge.setUpdatedOn(now);
			recharge.setPayment(payment);
			recharge.setStatus(Constants.RC_PAYMENT_FAILED);
			if (StringUtil.isEmptyString(recharge.getRechargeSummary())) {
				recharge.setRechargeSummary("Date :: "
						+ now.getTime()
						+ " Summary :: Recharged failed! payment not received \n");
			} else {
				recharge.setRechargeSummary(recharge.getRechargeSummary()
						+ " Date :: "
						+ now.getTime()
						+ " Summary :: Recharged failed! payment not received \n");
			}
			recharge = saveRecharge(recharge);
		}
		return recharge;
	}

	/**
	 * {@inheritDoc}
	 */
	public Recharge completeRecharge(Long rechargeId) throws MUException {
		PropertyReader reader = PropertyReader.getInstance();
		Recharge recharge = getRechargeById(rechargeId);
		Map<String, Object> response = ApiUtil.doRecharge(
				reader.getPropertyFromFile(Constants.DATA_TYPE_STRING,
						Constants.JOLO_RECHARGE_URL).toString(),
				reader.getPropertyFromFile(Constants.DATA_TYPE_STRING,
						Constants.APP_MODE).toString(),
				reader.getPropertyFromFile(Constants.DATA_TYPE_STRING,
						Constants.JOLO_USER_ID).toString(),
				reader.getPropertyFromFile(Constants.DATA_TYPE_STRING,
						Constants.JOLO_KEY).toString(), recharge);
		Calendar now = new GregorianCalendar();
		recharge.setUpdatedOn(now);
		if (response.get("status").toString()
				.equalsIgnoreCase(Constants.STATUS_SUCCESS)) {
			if (response.get("response").toString().split(",")[0]
					.equalsIgnoreCase(Constants.STATUS_FAILED)) {
				recharge.setStatus(Constants.RC_FAILED);
				if (response.get("response").toString().split(",")[1]
						.contains("your ip")) {
					if (StringUtil.isEmptyString(recharge.getRechargeSummary())) {
						recharge.setRechargeSummary("Date :: "
								+ now.getTime()
								+ " Summary :: "
								+ response.get("response").toString()
										.split(",")[1] + " \n");
					} else {
						recharge.setRechargeSummary(recharge
								.getRechargeSummary()
								+ " Date :: "
								+ now.getTime()
								+ " Summary :: "
								+ response.get("response").toString()
										.split(",")[1] + " \n");
					}

				} else {
					if (StringUtil.isEmptyString(recharge.getRechargeSummary())) {
						recharge.setRechargeSummary("Date :: "
								+ now.getTime()
								+ " Summary :: "
								+ getRcErrorByCode(
										response.get("response").toString()
												.split(",")[1])
										.getDescription() + " \n");
					} else {
						recharge.setRechargeSummary(recharge
								.getRechargeSummary()
								+ " Date :: "
								+ now.getTime()
								+ " Summary :: "
								+ getRcErrorByCode(
										response.get("response").toString()
												.split(",")[1])
										.getDescription() + " \n");
					}
				}
			} else if (response.get("response").toString().split(",")[1]
					.equalsIgnoreCase(Constants.RC_SUCCESS)) {
				recharge.setStatus(Constants.RC_SUCCESS);
				if (StringUtil.isEmptyString(recharge.getRechargeSummary())) {
					recharge.setRechargeSummary("Date :: " + now.getTime()
							+ " Summary :: Recharged Succesully! \n");
				} else {
					recharge.setRechargeSummary(recharge.getRechargeSummary()
							+ " Date :: " + now.getTime()
							+ " Summary :: Recharged Succesully! \n");
				}
				recharge.setReferenceId(response.get("response").toString()
						.split(",")[0]);
			} else {
				recharge.setStatus(Constants.RC_FAILED);
				if (StringUtil.isEmptyString(recharge.getRechargeSummary())) {
					recharge.setRechargeSummary("Date :: " + now.getTime()
							+ " Summary :: "
							+ response.get("response").toString() + " \n");
				} else {
					recharge.setRechargeSummary(recharge.getRechargeSummary()
							+ " Date :: " + now.getTime() + "Summary :: "
							+ response.get("response").toString() + " \n");
				}

			}
			if (StringUtil.isEmptyString(recharge.getReferenceDetail())) {
				recharge.setReferenceDetail("Date :: " + now.getTime()
						+ " Summary :: " + response.get("response").toString()
						+ " \n");
			} else {
				recharge.setReferenceDetail(recharge.getReferenceDetail()
						+ " Date :: " + now.getTime() + "Summary :: "
						+ response.get("response").toString() + " \n");
			}
		} else {
			recharge.setStatus(Constants.RC_FAILED);
			if (StringUtil.isEmptyString(recharge.getRechargeSummary())) {
				recharge.setRechargeSummary("Date :: " + now.getTime()
						+ " Summary :: " + response.get("response").toString()
						+ " \n");
			} else {
				recharge.setRechargeSummary(recharge.getRechargeSummary()
						+ " Date :: " + now.getTime() + "Summary :: "
						+ response.get("response").toString() + " \n");
			}
			if (StringUtil.isEmptyString(recharge.getReferenceDetail())) {
				recharge.setReferenceDetail("Date :: " + now.getTime()
						+ " Summary :: " + response.get("response").toString()
						+ " \n");
			} else {
				recharge.setReferenceDetail(recharge.getReferenceDetail()
						+ " Date :: " + now.getTime() + "Summary :: "
						+ response.get("response").toString() + " \n");
			}
		}
		return saveRecharge(recharge);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Recharge> getRecharges(Calendar from, Calendar to,
			String email, String phoneNumber, String status, String operator)
			throws MUException {
		return rechargeDao.getRecharges(from, to, email, phoneNumber, status,
				operator);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Map<String, String>> getRecharges(Calendar from, Calendar to,
			String status) throws MUException {
		return rechargeDao.getRecharges(from, to, status);
	}

	@SuppressWarnings("unused")
	private void sendRechargeEmail(final Recharge recharge,
			final String template, final String subject) {
		message.setTo(recharge.getEmail());
		message.setSubject(subject);
		final Map<String, Serializable> model = new HashMap<String, Serializable>();
		model.put("recharge", recharge);
		mailEngine.sendMessage(message, template, model);
	}
}
