package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_ASP_Level;
import org.compiere.model.X_ASP_Ref_List;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for ASP_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_Ref_ListInput extends X_ASP_Ref_List implements I_ASP_Ref_ListInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Ref_List;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mASP_Level;
	private I_AD_Ref_ListInput mASP_Status;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The ASP_Ref_List_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_ASP_Ref_ListInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Reference List.
	 *
	 * @param AD_Ref_List Reference List based on Table
	 */
	@JsonProperty("AD_Ref_List")
	public void setAD_Ref_ListInput(ForeignEntityInput AD_Ref_List) {
		this.mAD_Ref_List = AD_Ref_List;
		if (AD_Ref_List != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Ref_List", "AD_Ref_List_UU=?", get_TrxName())
							.setParameters(AD_Ref_List.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Ref_List_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Ref_List with UUID " + AD_Ref_List.getUUID());
			}
		} else {
			this.setAD_Ref_List_ID(0);
		}
	}

	/**
	 * Get Reference List.
	 *
	 * @return Reference List based on Table
	 */
	@JsonProperty("AD_Ref_List")
	public ForeignEntityInput AD_Ref_List() {
		return mAD_Ref_List;
	}

	/**
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public void setAD_ReferenceInput(ForeignEntityInput AD_Reference) {
		this.mAD_Reference = AD_Reference;
		if (AD_Reference != null) {
			// Since an entity was passed, make sure it's in the DB
			MReference_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Reference_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UUID " + AD_Reference.getUUID());
			}
		} else {
			this.setAD_Reference_ID(0);
		}
	}

	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public ForeignEntityInput AD_Reference() {
		return mAD_Reference;
	}

	/**
	 * Set ASP Level.
	 *
	 * @param ASP_Level ASP Level
	 */
	@JsonProperty("ASP_Level")
	public void setASP_LevelInput(ForeignEntityInput ASP_Level) {
		this.mASP_Level = ASP_Level;
		if (ASP_Level != null) {
			// Since an entity was passed, make sure it's in the DB
			X_ASP_Level foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "ASP_Level", "ASP_Level_UU=?", get_TrxName())
							.setParameters(ASP_Level.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setASP_Level_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table ASP_Level with UUID " + ASP_Level.getUUID());
			}
		} else {
			this.setASP_Level_ID(0);
		}
	}

	/**
	 * Get ASP Level.
	 *
	 * @return ASP Level
	 */
	@JsonProperty("ASP_Level")
	public ForeignEntityInput ASP_Level() {
		return mASP_Level;
	}
	/**
	 * Set ASP_Ref_List.
	 *
	 * @param ASP_Ref_List_ID ASP_Ref_List
	 */

	public void setASP_Ref_List_ID(int ASP_Ref_List_ID) {
		if (get_ID() == 0) {
			super.setASP_Ref_List_ID(ASP_Ref_List_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setASP_Ref_List_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getASP_Ref_List_UU();
	}

	/**
	 * Set ASP Status.
	 *
	 * @param ASP_Status ASP Status
	 */
	@JsonProperty("ASP_Status")
	public void setASP_StatusInput(I_AD_Ref_ListInput ASP_Status) {
		this.mASP_Status = ASP_Status;
		if (ASP_Status != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ASP_Status.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setASP_Status(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ASP_Status.getUUID());
			}
		} else {
			this.setASP_Status(null);
		}
	}

	/**
	 * Get ASP Status.
	 *
	 * @return ASP Status
	 */
	@JsonProperty("ASP_Status")
	public I_AD_Ref_ListInput ASP_Status() {
		return mASP_Status;
	}
}
