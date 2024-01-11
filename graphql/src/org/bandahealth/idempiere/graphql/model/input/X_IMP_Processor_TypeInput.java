package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_IMP_Processor_Type;

import java.sql.ResultSet;

/**
 * Generated Model for IMP_Processor_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_IMP_Processor_TypeInput extends X_IMP_Processor_Type implements I_IMP_Processor_TypeInput {

	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_IMP_Processor_TypeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_IMP_Processor_Type(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Import Processor Type.
	 *
	 * @param IMP_Processor_Type_ID Import Processor Type
	 */

	public void setIMP_Processor_Type_ID(int IMP_Processor_Type_ID) {
		if (get_ID() == 0) {
			super.setIMP_Processor_Type_ID(IMP_Processor_Type_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setIMP_Processor_Type_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getIMP_Processor_Type_UU();
	}
}
