package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.InOutLine;
import org.bandahealth.idempiere.rest.model.InventoryLine;
import org.bandahealth.idempiere.rest.model.Locator;
import org.bandahealth.idempiere.rest.model.MovementLine;
import org.bandahealth.idempiere.rest.model.Transaction;
import org.bandahealth.idempiere.rest.model.User;
import org.compiere.model.MTransaction;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionDBService extends BaseDBService<Transaction, MTransaction> {
	private final InOutLineDBService inOutLineDBService = new InOutLineDBService();
	private final InventoryLineDBService inventoryLineDBService = new InventoryLineDBService();
	private final MovementLineDBService movementLineDBService = new MovementLineDBService();
	private final UserDBService userDBService = new UserDBService();
	private final AttributeSetInstanceDBService attributeInstanceDBService = new AttributeSetInstanceDBService();
	private final LocatorDBService locatorDBService = new LocatorDBService();

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

		// Get inventory lines
		Map<Integer, InventoryLine> inventoryLinesById = inventoryLineDBService
				.transformData(new ArrayList<>(
						inventoryLineDBService.getByIds(dbModels.stream().map(MTransaction::getM_InventoryLine_ID)
								.filter(lineId -> lineId > 0).collect(Collectors.toSet())).values()))
				.stream().collect(Collectors.toMap(InventoryLine::getId, line -> line));

		// Get movement lines
		Map<Integer, MovementLine> movementLinesById = movementLineDBService
				.transformData(new ArrayList<>(
						movementLineDBService.getByIds(dbModels.stream().map(MTransaction::getM_MovementLine_ID)
								.filter(lineId -> lineId > 0).collect(Collectors.toSet())).values()))
				.stream().collect(Collectors.toMap(MovementLine::getId, line -> line));

		// Get users who created the records
		Map<Integer, MUser_BH> usersById = userDBService
				.getByIds(dbModels.stream().map(MTransaction::getCreatedBy).collect(Collectors.toSet()));

		// Get attribute set instances
		Map<Integer, MAttributeSetInstance_BH> attributeSetInstancesById = attributeInstanceDBService
				.getByIds(dbModels.stream().map(MTransaction::getM_AttributeSetInstance_ID).filter(id -> id > 0)
						.collect(Collectors.toSet()));

		// Get locators
		Map<Integer, Locator> locatorsById = locatorDBService.transformData(new ArrayList<>(locatorDBService
						.getByIds(dbModels.stream().map(MTransaction::getM_Locator_ID).collect(Collectors.toSet())).values()))
				.stream().collect(Collectors.toMap(Locator::getId, line -> line));

		return dbModels.stream().map(mTransaction -> {
			Transaction transaction = new Transaction(mTransaction);

			// set user
			if (usersById.containsKey(mTransaction.getCreatedBy())) {
				transaction.setUser(new User(usersById.get(mTransaction.getCreatedBy())));
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

			// set inventory lines
			if (inventoryLinesById.containsKey(mTransaction.getM_InventoryLine_ID())) {
				transaction.setInventoryLine(inventoryLinesById.get(mTransaction.getM_InventoryLine_ID()));
			}

			// set movement lines
			if (movementLinesById.containsKey(mTransaction.getM_MovementLine_ID())) {
				transaction.setMovementLine(movementLinesById.get(mTransaction.getM_MovementLine_ID()));
			}

			// set locators
			if (locatorsById.containsKey(mTransaction.getM_Locator_ID())) {
				transaction.setLocator(locatorsById.get(mTransaction.getM_Locator_ID()));
			}

			return transaction;

		}).collect(Collectors.toList());
	}
}
