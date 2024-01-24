package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MStorageProvider;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_StorageProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_StorageProviderInput extends MStorageProvider implements I_AD_StorageProviderInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mMethod;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_StorageProvider_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_StorageProviderInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MStorageProvider(null, (ResultSet) null, null),
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_StorageProvider_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (Method != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Method.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setMethod(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Method.getUUID());
			}
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
