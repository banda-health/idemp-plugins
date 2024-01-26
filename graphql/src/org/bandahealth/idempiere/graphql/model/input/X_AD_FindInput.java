package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 8.2 - $Id$
 */
public class X_AD_FindInput extends X_AD_Find implements I_AD_FindInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mAndOr;
	private I_AD_Ref_ListInput mOperation;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Find_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_FindInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Column.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UUID " + AD_Column.getUUID());
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

	public void setAD_Find_ID(int AD_Find_ID) {
		if (get_ID() == 0) {
			super.setAD_Find_ID(AD_Find_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Find_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Find_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
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
	public void setAndOrInput(I_AD_Ref_ListInput AndOr) {
		this.mAndOr = AndOr;
		if (AndOr != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AndOr.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAndOr(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + AndOr.getUUID());
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
	public I_AD_Ref_ListInput AndOr() {
		return mAndOr;
	}

	/**
	 * Set Operation.
	 *
	 * @param Operation Compare Operation
	 */
	@JsonProperty("Operation")
	public void setOperationInput(I_AD_Ref_ListInput Operation) {
		this.mOperation = Operation;
		if (Operation != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Operation.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setOperation(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Operation.getUUID());
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
	public I_AD_Ref_ListInput Operation() {
		return mOperation;
	}
}
