package org.bandahealth.idempiere.rest.service.db;

import java.math.BigDecimal;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.Movement;
import org.bandahealth.idempiere.rest.model.MovementLine;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MClient;
import org.compiere.model.MLocator;
import org.compiere.model.MLocatorType;
import org.compiere.model.MMovementLine;
import org.compiere.model.MProduct;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class MovementDBService extends BaseMovementDBService<Movement> {

	private MovementLineDBService movementLineDBService;
	/** Document Type */
	private int p_C_DocType_ID = 0;
	private static final String MISSING_FROM_WAREHOUSE = "Missing From warehouse";
	private static final String MISSING_TO_WAREHOUSE = "Missing To warehouse";

	public MovementDBService() {
		this.movementLineDBService = new MovementLineDBService();
	}

	@Override
	protected String getDocumentTypeName() {
		return DOCUMENTNAME_MOVEMENT;
	}

	@Override
	public Movement saveEntity(Movement entity) {
		// From
		MWarehouse fromWarehouse = new Query(Env.getCtx(), MWarehouse.Table_Name,
				MWarehouse.COLUMNNAME_M_Warehouse_UU + " =?", null).setParameters(entity.getFromWarehouse().getUuid())
						.first();
		if (fromWarehouse == null) {
			throw new AdempiereException(MISSING_FROM_WAREHOUSE);
		}

		// To
		MWarehouse toWarehouse = new Query(Env.getCtx(), MWarehouse.Table_Name,
				MWarehouse.COLUMNNAME_M_Warehouse_UU + " =?", null).setParameters(entity.getFromWarehouse().getUuid())
						.first();
		if (toWarehouse == null) {
			throw new AdempiereException(MISSING_TO_WAREHOUSE);
		}

		try {
			MMovement_BH mMovement = getEntityByUuidFromDB(entity.getUuid());
			if (mMovement == null) {
				mMovement = getModelInstance();
				if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
					mMovement.setM_Movement_UU(entity.getUuid());
				}

				mMovement.setC_DocType_ID(p_C_DocType_ID);
			}

			mMovement.setAD_Org_ID(fromWarehouse.getAD_Org_ID());
			mMovement.setBH_FromWarehouseID(fromWarehouse.get_ID());
			mMovement.setBH_ToWarehouseID(toWarehouse.get_ID());

			if (StringUtil.isNotNullAndEmpty(entity.getMovementDate())) {
				mMovement.setMovementDate(DateUtil.getTimestamp(entity.getMovementDate()));
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				mMovement.setDescription(entity.getDescription());
			}

			mMovement.setIsActive(entity.getIsActive());

			mMovement.setIsApproved(true);
			mMovement.setDocAction(MOrder_BH.DOCACTION_Complete);

			mMovement.saveEx();

			int locatorToID = toWarehouse.getDefaultLocator().getM_Locator_ID();

			if (entity.getMovementLines() != null && !entity.getMovementLines().isEmpty()) {
				for (MovementLine movementLine : entity.getMovementLines()) {
					// entity.getMovementLines().forEach((movementLine -> {
					// From: Look-up Storage
					MProduct product = new Query(Env.getCtx(), MProduct_BH.Table_Name,
							MProduct_BH.COLUMNNAME_M_Product_UU + " =?", null)
									.setParameters(movementLine.getProduct().getUuid()).first();

					String mMPolicy = product.getMMPolicy();
					// get inventory
					MStorageOnHand[] storages = MStorageOnHand.getWarehouse(Env.getCtx(),
							fromWarehouse.getM_Warehouse_ID(), product.getM_Product_ID(), 0, null,
							MClient.MMPOLICY_FiFo.equals(mMPolicy), false, 0, null);
					//
					BigDecimal target = movementLine.getMovementQuantity();

					for (int j = 0; j < storages.length; j++) { // foreach loops don't work with continue/break;
						MStorageOnHand storage = storages[j];
						if (storage.getQtyOnHand().signum() <= 0)
							continue;

						/* IDEMPIERE-2668 - filter just locators enabled for replenishment */
						MLocator locator = MLocator.get(Env.getCtx(), storage.getM_Locator_ID());
						MLocatorType locatorType = null;
						if (locator.getM_LocatorType_ID() > 0)
							locatorType = MLocatorType.get(Env.getCtx(), locator.getM_LocatorType_ID());
						if (locatorType != null && !locatorType.isAvailableForReplenishment())
							continue;

						// don't transfer more than what is available
						BigDecimal movementQuantity = target;
						if (storage.getQtyOnHand().compareTo(movementQuantity) < 0) {
							movementQuantity = storage.getQtyOnHand();
						}

						MMovementLine mMovementLine = new MMovementLine(mMovement);
						mMovementLine.setM_Product_ID(product.getM_Product_ID());
						mMovementLine.setMovementQty(movementQuantity);
						if (movementLine.getMovementQuantity().compareTo(movementQuantity) != 0) {
							mMovementLine.setDescription("Total: " + movementLine.getMovementQuantity());
						}

						mMovementLine.setM_Locator_ID(storage.getM_Locator_ID()); // from
						mMovementLine.setM_AttributeSetInstance_ID(storage.getM_AttributeSetInstance_ID());
						mMovementLine.setM_LocatorTo_ID(locatorToID); // to
						mMovementLine.setM_AttributeSetInstanceTo_ID(storage.getM_AttributeSetInstance_ID());
						mMovementLine.saveEx();
						//
						target = target.subtract(movementQuantity);
						if (target.signum() == 0) {
							break;
						}
					}
				}
			}

			return createInstanceWithAllFields(getEntityByUuidFromDB(mMovement.getM_Movement_UU()));

		} catch (Exception ex) {
			ex.printStackTrace();
			log.severe(ex.getMessage());

			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		try {
			MMovement_BH movement = new Query(Env.getCtx(), MMovement_BH.Table_Name,
					MMovement_BH.COLUMNNAME_M_Movement_UU + "=?", null).setParameters(entityUuid).first();

			if (movement.isComplete()) {
				throw new AdempiereException("Transaction is already completed");
			} else {
				// movementLineDBService.deleteMovementLinesByMovement(movement);

				return movement.delete(false);
			}
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Movement createInstanceWithDefaultFields(MMovement_BH instance) {
		return new Movement(instance, movementLineDBService.getLinesByMovement(instance));
	}

	@Override
	protected Movement createInstanceWithAllFields(MMovement_BH instance) {
		return new Movement(instance);
	}

	@Override
	protected Movement createInstanceWithSearchFields(MMovement_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MMovement_BH getModelInstance() {
		return new MMovement_BH(Env.getCtx(), 0, null);
	}

}
