package com.mu.service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.mu.common.MUException;
import com.mu.model.NetworkOperator;
import com.mu.model.Payment;
import com.mu.model.RcErrorCode;
import com.mu.model.Recharge;

public interface RechargeManager extends GenericManager<Recharge, Long> {

	Recharge saveRecharge(Recharge recharge) throws MUException;

	List<Recharge> getRechargeByStatus(String status) throws MUException;

	List<Recharge> getAllRecharge() throws MUException;

	List<Recharge> getRecharges(Calendar from, Calendar to, String email,
			String phoneNumber, String status, String operator)
			throws MUException;

	List<Map<String, String>> getRecharges(Calendar from, Calendar to,
			String status) throws MUException;

	List<Recharge> getRecharge(int from, int to) throws MUException;

	Recharge getRechargeById(Long rechargeId) throws MUException;

	NetworkOperator saveNetworkOperator(NetworkOperator networkOperator)
			throws MUException;

	List<NetworkOperator> getAllNetworkOperators() throws MUException;

	List<NetworkOperator> getNetworkOperators(String operatorType)
			throws MUException;

	NetworkOperator getNetworkOperatorById(Long id) throws MUException;

	List<NetworkOperator> getMobileOperators() throws MUException;

	List<NetworkOperator> getDataCardOperators() throws MUException;

	List<NetworkOperator> getDTHOperators() throws MUException;

	RcErrorCode getRcErrorCodeById(Long id) throws MUException;

	RcErrorCode saveRcErrorCode(RcErrorCode rcErrorCode) throws MUException;

	RcErrorCode getRcErrorByCode(String errorCode) throws MUException;

	List<RcErrorCode> getAllRcErrorCodes() throws MUException;

	Recharge completeRecharge(Long rechargeId) throws MUException;

	Recharge initiatePayment(Recharge recharge)
			throws MUException;

	Recharge handlePaymentResponse(Payment payment) throws MUException;
}
