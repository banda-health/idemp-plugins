package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.MovementLine;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MProduct;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class MovementLineDBService extends BaseDBService<MovementLine, MMovementLine_BH> {

	private MovementDBService movementDBService;

	public MovementLineDBService() {
		movementDBService = new MovementDBService();
	}

	@Override
	public MovementLine saveEntity(MovementLine entity) {
		MMovementLine_BH mMovementLine = getEntityByUuidFromDB(entity.getUuid());
		if (mMovementLine == null) {
			mMovementLine = new MMovementLine_BH(Env.getCtx(), 0, null);
			mMovementLine.setAD_Org_ID(Env.getAD_Org_ID(Env.getCtx()));
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				mMovementLine.setM_MovementLine_UU(entity.getUuid());
			}
		}

		if (StringUtil.isNotNullAndEmpty(entity.getMovementUuid())) {
			MMovement_BH movement = movementDBService.getEntityByUuidFromDB(entity.getMovementUuid());
			mMovementLine.setM_Movement_ID(movement.get_ID());
		}

		mMovementLine.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(mMovementLine.getM_MovementLine_UU()));
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
		MovementLine movementLine = new MovementLine(instance);

		MProduct mProduct = instance.getProduct();
		movementLine.setProduct(new Product(mProduct.getName(), mProduct.getM_Product_UU(), mProduct.getProductType(),
				new MProduct_BH(Env.getCtx(), mProduct.get_ID(), null)));

		return movementLine;
	}

	@Override
	protected MovementLine createInstanceWithSearchFields(MMovementLine_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MMovementLine_BH getModelInstance() {
		return new MMovementLine_BH(Env.getCtx(), 0, null);
	}
}
