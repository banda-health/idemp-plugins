package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_SerNoCtlExclude;

import java.sql.ResultSet;

/**
 * Generated Model for M_SerNoCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_SerNoCtlExcludeInput extends X_M_SerNoCtlExclude implements I_M_SerNoCtlExcludeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mM_SerNoCtl;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_SerNoCtlExcludeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_M_SerNoCtlExclude(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable_BH foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set Serial No Control.
	 *
	 * @param M_SerNoCtl Product Serial Number Control
	 */
	@JsonProperty("M_SerNoCtl")
	public void setM_SerNoCtlInput(ForeignEntityInput M_SerNoCtl) {
		this.mM_SerNoCtl = M_SerNoCtl;
		MSerNoCtl_BH foreignEntity;
		if (get_ID() == 0 && M_SerNoCtl != null &&
				(foreignEntity = new Query(getCtx(), "M_SerNoCtl", "M_SerNoCtl_UU=?", get_TrxName())
						.setParameters(M_SerNoCtl.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_SerNoCtl_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Serial No Control.
	 *
	 * @return Product Serial Number Control
	 */
	@JsonProperty("M_SerNoCtl")
	public ForeignEntityInput M_SerNoCtl() {
		return mM_SerNoCtl;
	}
	/**
	 * Set Exclude SerNo.
	 *
	 * @param M_SerNoCtlExclude_ID Exclude the ability to create Serial Numbers in Attribute Sets
	 */

	public void setM_SerNoCtlExclude_ID(int M_SerNoCtlExclude_ID) {
		if (get_ID() == 0) {
			super.setM_SerNoCtlExclude_ID(M_SerNoCtlExclude_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_SerNoCtlExclude_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_SerNoCtlExclude_UU();
	}
}
