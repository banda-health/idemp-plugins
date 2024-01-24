package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MStorageProvider;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_StorageProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_StorageProviderInput extends MStorageProvider implements I_AD_StorageProviderInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mMethod;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_StorageProviderInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MStorageProvider(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
	 * Set Storage Provider.
	 *
	 * @param AD_StorageProvider_ID Storage Provider
	 */

	public void setAD_StorageProvider_ID(int AD_StorageProvider_ID) {
		if (get_ID() == 0) {
			super.setAD_StorageProvider_ID(AD_StorageProvider_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_StorageProvider_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_StorageProvider_UU();
	}

	/**
	 * Set Method.
	 *
	 * @param Method Method
	 */
	@JsonProperty("Method")
	public void setMethodInput(I_AD_Ref_ListInput Method) {
		this.mMethod = Method;
		MRefList_BH foreignEntity;
		if (Method != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Method.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMethod(foreignEntity.getValue());
		} else {
			this.setMethod(null);
		}
	}

	/**
	 * Get Method.
	 *
	 * @return Method
	 */
	@JsonProperty("Method")
	public I_AD_Ref_ListInput Method() {
		return mMethod;
	}
}
