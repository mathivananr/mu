package com.mu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mu.common.MUException;
import com.mu.dao.RechargeDao;
import com.mu.model.NetworkOperator;
import com.mu.model.RcErrorCode;
import com.mu.model.Recharge;
import com.mu.service.RechargeManager;

@Service("rechargeManager")
public class RechargeManagerImpl extends GenericManagerImpl<Recharge, Long>
		implements RechargeManager {

	private RechargeDao rechargeDao;

	@Autowired
	public RechargeManagerImpl(RechargeDao rechargeDao) {
		super(rechargeDao);
		this.rechargeDao = rechargeDao;
	}

	public Recharge saveRecharge(Recharge recharge) throws MUException {
		return rechargeDao.saveRecharge(recharge);
	}

	public List<Recharge> getRechargeByStatus(String status) throws MUException {
		return rechargeDao.getRechargeByStatus(status);
	}

	public List<Recharge> getAllRecharge() throws MUException {
		return rechargeDao.getAllRecharge();
	}

	public List<Recharge> getRecharge(int from, int to) throws MUException {
		return rechargeDao.getRecharge(from, to);
	}

	public Recharge getRechargeById(Long rechargeId) throws MUException {
		return rechargeDao.getRechargeById(rechargeId);
	}

	public NetworkOperator saveNetworkOperator(NetworkOperator networkOperator)
			throws MUException {
		return rechargeDao.saveNetworkOperator(networkOperator);
	}

	public List<NetworkOperator> getAllNetworkOperators() throws MUException {
		return rechargeDao.getAllNetworkOperators();
	}

	public List<NetworkOperator> getNetworkOperators(String operatorType)
			throws MUException {
		return rechargeDao.getNetworkOperators(operatorType);
	}

	public NetworkOperator getNetworkOperatorById(Long id) throws MUException {
		return rechargeDao.getNetworkOperatorById(id);
	}

	public List<NetworkOperator> getMobileOperators() throws MUException {
		return rechargeDao.getMobileOperators();
	}

	public List<NetworkOperator> getDataCardOperators() throws MUException {
		return rechargeDao.getDataCardOperators();
	}

	public List<NetworkOperator> getDTHOperators() throws MUException {
		return rechargeDao.getDTHOperators();
	}

	public RcErrorCode getRcErrorCodeById(Long id) throws MUException{
		return rechargeDao.getRcErrorCodeById(id);
	}
	
	public RcErrorCode saveRcErrorCode(RcErrorCode rcErrorCode)
			throws MUException {
		return rechargeDao.saveRcErrorCode(rcErrorCode);
	}

	public RcErrorCode getRcErrorByCode(String errorCode) throws MUException {
		return rechargeDao.getRcErrorByCode(errorCode);
	}

	public List<RcErrorCode> getAllRcErrorCodes() throws MUException {
		return rechargeDao.getAllRcErrorCodes();
	}
}
