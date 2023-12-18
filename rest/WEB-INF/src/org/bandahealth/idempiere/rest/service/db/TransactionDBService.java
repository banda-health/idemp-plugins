package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.InOutLine;
import org.bandahealth.idempiere.rest.model.Transaction;
import org.bandahealth.idempiere.rest.model.User;
import org.compiere.model.MTransaction;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionDBService extends BaseDBService<Transaction, MTransaction> {
	@Autowired
	private InOutLineDBService inOutLineDBService;
	@Autowired
	private UserDBService userDBService;
	@Autowired
	private AttributeSetInstanceDBService attributeInstanceDBService;

	@Override
	public Transaction saveEntity(Transaction entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected Transaction createInstanceWithDefaultFields(MTransaction instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Transaction createInstanceWithAllFields(MTransaction instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MTransaction getModelInstance() {
		return new MTransaction(Env.getCtx(), 0, null);
	}

	@Override
	public List<Transaction> transformData(List<MTransaction> dbModels) {
		// Get in-out lines
		Map<Integer, InOutLine> inOutLinesById = inOutLineDBService
				.transformData(
						new ArrayList<>(
								inOutLineDBService
										.getByIds(dbModels.stream().map(MTransaction::getM_InOutLine_ID)
												.filter(inOutLineId -> inOutLineId > 0).collect(Collectors.toSet()))
										.values()))
				.stream().collect(Collectors.toMap(InOutLine::getId, line -> line));

		// Get users who created the records
		Map<Integer, MUser_BH> usersById = userDBService
				.getByIds(dbModels.stream().map(MTransaction::getCreatedBy).collect(Collectors.toSet()));

		// Get attribute set instances
		Map<Integer, MAttributeSetInstance_BH> attributeSetInstancesById = attributeInstanceDBService
				.getByIds(dbModels.stream().map(MTransaction::getM_AttributeSetInstance_ID).filter(id -> id > 0)
						.collect(Collectors.toSet()));

		dbModels.stream().map(mTransaction -> {
			Transaction transaction = new Transaction(mTransaction);

			// set user
			MUser_BH user = usersById.get(mTransaction.getCreatedBy());
			if (user != null) {
				transaction.setCreatedBy(new User(user));
			}

			// set attribute set instance
			MAttributeSetInstance_BH attributeSetInstance = attributeSetInstancesById
					.get(mTransaction.getM_AttributeSetInstance_ID());
			if (attributeSetInstance != null) {
				transaction.setAttributeSetInstance(new AttributeSetInstance(attributeSetInstance));
			}

			// set in-out lines
			if (inOutLinesById.containsKey(mTransaction.getM_InOutLine_ID())) {
				transaction.setInOutLine(inOutLinesById.get(mTransaction.getM_InOutLine_ID()));
			}

			return transaction;

		}).collect(Collectors.toList());

		return super.transformData(dbModels);
	}
}
