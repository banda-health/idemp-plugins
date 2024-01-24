package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Package_Imp_Proc;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Package_Imp_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Package_Imp_ProcInput extends X_AD_Package_Imp_Proc implements I_AD_Package_Imp_ProcInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mAD_Package_Source_Type;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Package_Imp_ProcInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_Package_Imp_Proc(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Package Imp. Proc..
	 *
	 * @param AD_Package_Imp_Proc_ID Package Imp. Proc.
	 */

	public void setAD_Package_Imp_Proc_ID(int AD_Package_Imp_Proc_ID) {
		if (get_ID() == 0) {
			super.setAD_Package_Imp_Proc_ID(AD_Package_Imp_Proc_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Package_Imp_Proc_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Package_Imp_Proc_UU();
	}

	/**
	 * Set Package Source Type.
	 *
	 * @param AD_Package_Source_Type Type of package source - file, ftp, webservice etc
	 */
	@JsonProperty("AD_Package_Source_Type")
	public void setAD_Package_Source_TypeInput(I_AD_Ref_ListInput AD_Package_Source_Type) {
		this.mAD_Package_Source_Type = AD_Package_Source_Type;
		MRefList_BH foreignEntity;
		if (AD_Package_Source_Type != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AD_Package_Source_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Package_Source_Type(foreignEntity.getValue());
		} else {
			this.setAD_Package_Source_Type(null);
		}
	}

	/**
	 * Get Package Source Type.
	 *
	 * @return Type of package source - file, ftp, webservice etc
	 */
	@JsonProperty("AD_Package_Source_Type")
	public I_AD_Ref_ListInput AD_Package_Source_Type() {
		return mAD_Package_Source_Type;
	}
}
