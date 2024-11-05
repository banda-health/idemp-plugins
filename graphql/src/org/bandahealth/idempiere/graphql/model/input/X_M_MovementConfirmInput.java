package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_M_MovementConfirmResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MMovementConfirm;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_MovementConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MovementConfirmInput extends MMovementConfirm implements I_M_MovementConfirmInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mDocAction;
	private ForeignEntityInput mDocStatus;
	private ForeignEntityInput mM_Inventory;
	private ForeignEntityInput mM_Movement;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_MovementConfirm_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_MovementConfirmInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(ForeignEntityInput DocAction) {
		this.mDocAction = DocAction;
		if (DocAction != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_MovementConfirmResolver.DOCACTION_UUIDS_BY_VALUE.containsValue(DocAction.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocAction.getUU() +
						" is not in the list defined for the DocAction column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocAction.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocAction.getUU());
			}
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public ForeignEntityInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(ForeignEntityInput DocStatus) {
		this.mDocStatus = DocStatus;
		if (DocStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_MovementConfirmResolver.DOCSTATUS_UUIDS_BY_VALUE.containsValue(DocStatus.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocStatus.getUU() +
						" is not in the list defined for the DocStatus column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocStatus.getUU());
			}
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	@JsonProperty("DocStatus")
	public ForeignEntityInput DocStatus() {
		return mDocStatus;
	}

	/**
	 * Set Phys.Inventory.
	 *
	 * @param M_Inventory Parameters for a Physical Inventory
	 */
	@JsonProperty("M_Inventory")
	public void setM_InventoryInput(ForeignEntityInput M_Inventory) {
		this.mM_Inventory = M_Inventory;
		if (M_Inventory != null) {
			// Since an entity was passed, make sure it's in the DB
			MInventory_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Inventory", "M_Inventory_UU=?", get_TrxName())
							.setParameters(M_Inventory.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Inventory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Inventory with UU " + M_Inventory.getUU());
			}
		} else {
			this.setM_Inventory_ID(0);
		}
	}

	/**
	 * Get Phys.Inventory.
	 *
	 * @return Parameters for a Physical Inventory
	 */
	@JsonProperty("M_Inventory")
	public ForeignEntityInput M_Inventory() {
		return mM_Inventory;
	}

	/**
	 * Set Inventory Move.
	 *
	 * @param M_Movement Movement of Inventory
	 */
	@JsonProperty("M_Movement")
	public void setM_MovementInput(ForeignEntityInput M_Movement) {
		this.mM_Movement = M_Movement;
		if (M_Movement != null) {
			// Since an entity was passed, make sure it's in the DB
			MMovement_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Movement", "M_Movement_UU=?", get_TrxName())
							.setParameters(M_Movement.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Movement_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Movement with UU " + M_Movement.getUU());
			}
		} else {
			this.setM_Movement_ID(0);
		}
	}

	/**
	 * Get Inventory Move.
	 *
	 * @return Movement of Inventory
	 */
	@JsonProperty("M_Movement")
	public ForeignEntityInput M_Movement() {
		return mM_Movement;
	}
	/**
	 * Set Move Confirm.
	 *
	 * @param M_MovementConfirm_ID Inventory Move Confirmation
	 */
	@JsonProperty("M_MovementConfirm_ID")
	public void setM_MovementConfirm_IDFromJson(int M_MovementConfirm_ID) {
		if (get_ID() == 0) {
			super.setM_MovementConfirm_ID(M_MovementConfirm_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_MovementConfirm_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_MovementConfirm_UU();
	}
}
