package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_POSTenderType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_POSTenderType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSTenderTypeInput extends X_C_POSTenderType implements I_C_POSTenderTypeInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mTenderType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_POSTenderType_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_POSTenderTypeInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_POSTenderType(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set POS Tender Type.
	 *
	 * @param C_POSTenderType_ID POS Tender Type
	 */

	public void setC_POSTenderType_ID(int C_POSTenderType_ID) {
		if (get_ID() == 0) {
			super.setC_POSTenderType_ID(C_POSTenderType_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_POSTenderType_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_POSTenderType_UU();
	}

	/**
	 * Set Tender type.
	 *
	 * @param TenderType Method of Payment
	 */
	@JsonProperty("TenderType")
	public void setTenderTypeInput(I_AD_Ref_ListInput TenderType) {
		this.mTenderType = TenderType;
		MRefList_BH foreignEntity;
		if (TenderType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TenderType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setTenderType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + TenderType.getUUID());
			}
		} else {
			this.setTenderType(null);
		}
	}

	/**
	 * Get Tender type.
	 *
	 * @return Method of Payment
	 */
	@JsonProperty("TenderType")
	public I_AD_Ref_ListInput TenderType() {
		return mTenderType;
	}
}
