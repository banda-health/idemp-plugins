package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_ASP_Field;
import org.compiere.model.X_ASP_Tab;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for ASP_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_FieldInput extends X_ASP_Field implements I_ASP_FieldInput {

	private ForeignEntityInput mAD_Field;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mASP_Tab;
	private I_AD_Ref_ListInput mASP_Status;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The ASP_Field_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_ASP_FieldInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_ASP_Field(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	@JsonProperty("AD_Field")
	public void setAD_FieldInput(ForeignEntityInput AD_Field) {
		this.mAD_Field = AD_Field;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Field != null) {
			// Since an entity was passed, make sure it's in the DB
			MField_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Field", "AD_Field_UU=?", get_TrxName())
							.setParameters(AD_Field.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Field_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Field with UUID " + AD_Field.getUUID());
			}
		} else {
			this.setAD_Field_ID(0);
		}
	}

	/**
	 * Get Field.
	 *
	 * @return Field on a database table
	 */
	@JsonProperty("AD_Field")
	public ForeignEntityInput AD_Field() {
		return mAD_Field;
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
	 * Set ASP Field.
	 *
	 * @param ASP_Field_ID ASP Field
	 */

	public void setASP_Field_ID(int ASP_Field_ID) {
		if (get_ID() == 0) {
			super.setASP_Field_ID(ASP_Field_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setASP_Field_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getASP_Field_UU();
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
							.setParameters(ASP_Status.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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

	/**
	 * Set ASP Tab.
	 *
	 * @param ASP_Tab ASP Tab
	 */
	@JsonProperty("ASP_Tab")
	public void setASP_TabInput(ForeignEntityInput ASP_Tab) {
		this.mASP_Tab = ASP_Tab;
		if (get_ID() != 0) {
			return;
		}
		if (ASP_Tab != null) {
			// Since an entity was passed, make sure it's in the DB
			X_ASP_Tab foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "ASP_Tab", "ASP_Tab_UU=?", get_TrxName())
							.setParameters(ASP_Tab.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setASP_Tab_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table ASP_Tab with UUID " + ASP_Tab.getUUID());
			}
		} else {
			this.setASP_Tab_ID(0);
		}
	}

	/**
	 * Get ASP Tab.
	 *
	 * @return ASP Tab
	 */
	@JsonProperty("ASP_Tab")
	public ForeignEntityInput ASP_Tab() {
		return mASP_Tab;
	}
}
