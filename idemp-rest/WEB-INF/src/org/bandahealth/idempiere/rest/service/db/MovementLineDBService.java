package org.bandahealth.idempiere.rest.service.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.MovementLine;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MClient;
import org.compiere.model.MLocator;
import org.compiere.model.MLocatorType;
import org.compiere.model.MProduct;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class MovementLineDBService extends BaseDBService<MovementLine, MMovementLine_BH> {

	public MovementLineDBService() {
	}

	/**
	 * Save a movement line.
	 * 
	 * @param entity
	 * @param movement
	 * @param fromWarehouse
	 * @param toWarehouse
	 * @param targetQuantity - monitor available quantity and avoid transferring
	 *                       more than is available
	 */
	public void saveEntity(MovementLine entity, MMovement_BH movement, MWarehouse fromWarehouse, MWarehouse toWarehouse,
			BigDecimal targetQuantity) {
		MMovementLine_BH mMovementLine = getEntityByUuidFromDB(entity.getUuid());
		if (mMovementLine == null) {
			mMovementLine = new MMovementLine_BH(Env.getCtx(), 0, null);
			mMovementLine.setAD_Org_ID(Env.getAD_Org_ID(Env.getCtx()));
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				mMovementLine.setM_MovementLine_UU(entity.getUuid());
			}
		}

		if (mMovementLine.getM_Movement_ID() == 0) {
			mMovementLine.setM_Movement_ID(movement.get_ID());
		}

		// From: Look-up Storage
		MProduct product = new Query(Env.getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + " =?",
				null).setParameters(entity.getProduct().getUuid()).first();

		String mMPolicy = product.getMMPolicy();
		// get inventory
		MStorageOnHand[] storages = MStorageOnHand.getWarehouse(Env.getCtx(), fromWarehouse.getM_Warehouse_ID(),
				product.getM_Product_ID(), 0, null, MClient.MMPOLICY_FiFo.equals(mMPolicy), false, 0, null);

		List<MLocator> locators = new Query(Env.getCtx(), MLocator.Table_Name, null, null).setClient_ID().list();

		for (int j = 0; j < storages.length; j++) {
			MStorageOnHand storage = storages[j];
			if (storage.getQtyOnHand().signum() <= 0)
				continue;

			/* IDEMPIERE-2668 - filter just locators enabled for replenishment */
			Optional<MLocator> mLocator = locators.stream()
					.filter((locator -> locator.get_ID() == storage.getM_Locator_ID())).findFirst();
			if (mLocator.isEmpty()) {
				continue;
			}

			MLocator locator = mLocator.get();
			MLocatorType locatorType = null;
			if (locator.getM_LocatorType_ID() > 0) {
				locatorType = MLocatorType.get(Env.getCtx(), locator.getM_LocatorType_ID());
			}

			if (locatorType != null && !locatorType.isAvailableForReplenishment()) {
				continue;
			}

			// don't transfer more than what is available
			BigDecimal movementQuantity = targetQuantity;
			if (storage.getQtyOnHand().compareTo(movementQuantity) < 0) {
				movementQuantity = storage.getQtyOnHand();
			}

			// MMovementLine mMovementLine = new MMovementLine(mMovement);
			mMovementLine.setM_Product_ID(product.getM_Product_ID());
			mMovementLine.setMovementQty(movementQuantity);
			if (entity.getMovementQuantity().compareTo(movementQuantity) != 0) {
				mMovementLine.setDescription("Total: " + entity.getMovementQuantity());
			}

			mMovementLine.setM_Locator_ID(storage.getM_Locator_ID()); // from
			mMovementLine.setM_AttributeSetInstance_ID(storage.getM_AttributeSetInstance_ID());
			mMovementLine.setM_LocatorTo_ID(toWarehouse.getDefaultLocator().getM_Locator_ID()); // to
			mMovementLine.setM_AttributeSetInstanceTo_ID(storage.getM_AttributeSetInstance_ID());
			mMovementLine.saveEx();
			//
			targetQuantity = targetQuantity.subtract(movementQuantity);
			if (targetQuantity.signum() == 0) {
				break;
			}

			mMovementLine.saveEx();
		}
	}

	@Override
	public MovementLine saveEntity(MovementLine entity) {
		// not implemented

		return null;
	}

	public List<MovementLine> getLinesByMovement(MMovement_BH movement) {
		List<MovementLine> results = new ArrayList<>();

		List<MMovementLine_BH> lines = new Query(Env.getCtx(), MMovementLine_BH.Table_Name,
				MMovementLine_BH.COLUMNNAME_M_Movement_ID + "=?", null).setParameters(movement.get_ID())
						.setOnlyActiveRecords(true).setClient_ID().list();
		lines.forEach(line -> {
			results.add(createInstanceWithDefaultFields(line));
		});

		return results;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		MMovementLine_BH movementLine = new Query(Env.getCtx(), MMovementLine_BH.Table_Name,
				MMovementLine_BH.COLUMNNAME_M_MovementLine_UU + "=?", null).setParameters(entityUuid).setClient_ID()
						.first();
		if (movementLine != null) {
			movementLine.deleteEx(false);

			return true;
		}

		return false;
	}

	public void deleteMovementLinesByMovement(MMovement_BH movement) {
		List<MMovementLine_BH> mMovementLines = new Query(Env.getCtx(), MMovementLine_BH.Table_Name,
				MMovementLine_BH.COLUMNNAME_M_Movement_ID + "=?", null).setParameters(movement.get_ID()).setClient_ID()
						.list();
		for (MMovementLine_BH mMovementLine : mMovementLines) {
			mMovementLine.deleteEx(false);
		}
	}

	@Override
	protected MovementLine createInstanceWithDefaultFields(MMovementLine_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MovementLine createInstanceWithAllFields(MMovementLine_BH instance) {
		return new MovementLine(instance);
	}

	@Override
	protected MovementLine createInstanceWithSearchFields(MMovementLine_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MMovementLine_BH getModelInstance() {
		return new MMovementLine_BH(Env.getCtx(), 0, null);
	}

	@Override
	public List<MovementLine> transformData(List<MMovementLine_BH> dbModels) {
		List<MovementLine> results = new ArrayList<>();

		// get list of products
		Set<Integer> productIds = dbModels.stream().map(MMovementLine_BH::getM_Product_ID).collect(Collectors.toSet());
		List<Object> parameters = new ArrayList<>();
		List<MProduct_BH> products = new Query(Env.getCtx(), MProduct_BH.Table_Name,
				MProduct_BH.COLUMNNAME_M_Product_ID + " IN ("
						+ QueryUtil.getWhereClauseAndSetParametersForSet(productIds, parameters) + ")",
				null).setParameters(parameters).list();
		dbModels.forEach((line) -> {
			MovementLine movementLine = new MovementLine(line);

			Optional<MProduct_BH> foundProduct = products.stream().filter((product) -> {
				return product.get_ID() == line.getM_Product_ID();
			}).findFirst();
			if (!foundProduct.isEmpty()) {
				MProduct_BH mProduct = foundProduct.get();
				movementLine.setProduct(new Product(mProduct.getName(), mProduct.getM_Product_UU(),
						mProduct.getProductType(), mProduct));
			}

			results.add(movementLine);

		});

		return results;
	}
}
