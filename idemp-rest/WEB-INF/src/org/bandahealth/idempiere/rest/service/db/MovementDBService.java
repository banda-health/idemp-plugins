package org.bandahealth.idempiere.rest.service.db;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.model.Movement;
import org.bandahealth.idempiere.rest.model.MovementLine;
import org.bandahealth.idempiere.rest.model.User;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class MovementDBService extends DocumentDBService<Movement, MMovement_BH> {

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

	private Map<String, String> dynamicJoins = new HashMap<>() {
		{
			put(MWarehouse.Table_Name,
					"LEFT JOIN " + MWarehouse.Table_Name + " ON " + MMovement_BH.Table_Name + "."
							+ MMovement_BH.COLUMNNAME_BH_FROM_WAREHOUSE_ID + " = " + MWarehouse.Table_Name + "."
							+ MWarehouse.COLUMNNAME_M_Warehouse_ID);
			put(MUser_BH.Table_Name,
					"LEFT JOIN " + MUser_BH.Table_Name + " ON " + MMovement_BH.Table_Name + "."
							+ MMovement_BH.COLUMNNAME_CreatedBy + " = " + MUser_BH.Table_Name + "."
							+ MUser_BH.COLUMNNAME_AD_User_ID);
		}
	};

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
				MWarehouse.COLUMNNAME_M_Warehouse_UU + " =?", null).setParameters(entity.getToWarehouse().getUuid())
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
				Timestamp movementDate = DateUtil.getTimestamp(entity.getMovementDate());
				if (movementDate == null) {
					movementDate = new Timestamp(System.currentTimeMillis());
				}

				mMovement.setMovementDate(movementDate);
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				mMovement.setDescription(entity.getDescription());
			}

			mMovement.setIsActive(entity.getIsActive());

			mMovement.setIsApproved(true);
			mMovement.setDocAction(MOrder_BH.DOCACTION_Complete);

			mMovement.saveEx();

			if (entity.getMovementLines() != null && !entity.getMovementLines().isEmpty()) {
				for (MovementLine movementLine : entity.getMovementLines()) {
					movementLineDBService.saveEntity(movementLine, mMovement, fromWarehouse, toWarehouse,
							movementLine.getMovementQuantity());
				}
			}

			return getEntity(mMovement.getM_Movement_UU()); 

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
		return new Movement(instance);
	}

	@Override
	protected Movement createInstanceWithAllFields(MMovement_BH instance) {
		return new Movement(instance, movementLineDBService.getLinesByMovement(instance));
	}

	@Override
	protected Movement createInstanceWithSearchFields(MMovement_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MMovement_BH getModelInstance() {
		return new MMovement_BH(Env.getCtx(), 0, null);
	}

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}

	@Override
	public Movement getEntity(String uuid) {
		return transformData(Collections.singletonList(getEntityByUuidFromDB(uuid))).get(0);
	}

	@Override
	public List<Movement> transformData(List<MMovement_BH> dbModels) {
		List<Movement> results = new ArrayList<>();

		// get available warehouses
		List<MWarehouse> warehouses = Arrays.asList(MWarehouse.getForOrg(Env.getCtx(), Env.getAD_Org_ID(Env.getCtx())));

		// get list of users
		Set<Integer> userIds = dbModels.stream().map(MMovement_BH::getCreatedBy).collect(Collectors.toSet());
		List<Object> parameters = new ArrayList<>();

		List<MUser_BH> users = new Query(Env.getCtx(), MUser_BH.Table_Name,
				MUser_BH.COLUMNNAME_AD_User_ID + " IN ("
						+ QueryUtil.getWhereClauseAndSetParametersForSet(userIds, parameters) + ")",
				null).setParameters(parameters).list();
		dbModels.forEach((mMovement) -> {
			Movement movement = createInstanceWithAllFields(mMovement);
			if (mMovement.getBH_FromWarehouseID() > 0) {
				Optional<MWarehouse> foundWarehouse = warehouses.stream().filter(warehouse -> {
					return warehouse.get_ID() == mMovement.getBH_FromWarehouseID();
				}).findFirst();

				if (!foundWarehouse.isEmpty()) {
					movement.setFromWarehouse(new Warehouse(foundWarehouse.get()));
				}
			}

			if (mMovement.getBH_ToWarehouseID() > 0) {
				Optional<MWarehouse> foundWarehouse = warehouses.stream().filter(warehouse -> {
					return warehouse.get_ID() == mMovement.getBH_ToWarehouseID();
				}).findFirst();

				if (!foundWarehouse.isEmpty()) {
					movement.setToWarehouse(new Warehouse(foundWarehouse.get()));
				}
			}

			Optional<MUser_BH> foundUser = users.stream().filter(user -> {
				return user.get_ID() == mMovement.getCreatedBy();
			}).findFirst();
			if (!foundUser.isEmpty()) {
				MUser_BH mUser = foundUser.get();
				movement.setUser(new User(mUser.getName(), mUser.getAD_User_UU()));
			}

			results.add(movement);
		});

		return results;
	}
}
