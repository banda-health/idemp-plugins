package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_FindResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Find;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Find - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_FindInput extends X_AD_Find implements I_AD_FindInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAndOr;
	private ForeignEntityInput mOperation;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Find_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_FindInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		if (AD_Column != null) {
			// Since an entity was passed, make sure it's in the DB
			MColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
							.setParameters(AD_Column.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UU " + AD_Column.getUU());
			}
		} else {
			this.setAD_Column_ID(0);
		}
	}

	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	@JsonProperty("AD_Column")
	public ForeignEntityInput AD_Column() {
		return mAD_Column;
	}
	/**
	 * Set Find.
	 *
	 * @param AD_Find_ID Find
	 */
	@JsonProperty("AD_Find_ID")
	public void setAD_Find_IDFromJson(int AD_Find_ID) {
		if (get_ID() == 0) {
			super.setAD_Find_ID(AD_Find_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Find_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Find_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
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
	 * Set And/Or.
	 *
	 * @param AndOr Logical operation: AND or OR
	 */
	@JsonProperty("AndOr")
	public void setAndOrInput(ForeignEntityInput AndOr) {
		this.mAndOr = AndOr;
		if (AndOr != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_FindResolver.ANDOR_UUIDS_BY_VALUE.containsValue(AndOr.getUU())) {
				throw new AdempiereException("The reference list UU of " + AndOr.getUU() +
						" is not in the list defined for the AndOr column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AndOr.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAndOr(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AndOr.getUU());
			}
		} else {
			this.setAndOr(null);
		}
	}

	/**
	 * Get And/Or.
	 *
	 * @return Logical operation: AND or OR
	 */
	@JsonProperty("AndOr")
	public ForeignEntityInput AndOr() {
		return mAndOr;
	}

	/**
	 * Set Operation.
	 *
	 * @param Operation Compare Operation
	 */
	@JsonProperty("Operation")
	public void setOperationInput(ForeignEntityInput Operation) {
		this.mOperation = Operation;
		if (Operation != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_FindResolver.OPERATION_UUIDS_BY_VALUE.containsValue(Operation.getUU())) {
				throw new AdempiereException("The reference list UU of " + Operation.getUU() +
						" is not in the list defined for the Operation column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Operation.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setOperation(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Operation.getUU());
			}
		} else {
			this.setOperation(null);
		}
	}

	/**
	 * Get Operation.
	 *
	 * @return Compare Operation
	 */
	@JsonProperty("Operation")
	public ForeignEntityInput Operation() {
		return mOperation;
	}
}
