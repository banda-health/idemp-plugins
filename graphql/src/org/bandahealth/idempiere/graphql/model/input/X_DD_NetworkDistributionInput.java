package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.eevolution.model.X_DD_NetworkDistribution;

import java.sql.ResultSet;

/**
 * Generated Model for DD_NetworkDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_DD_NetworkDistributionInput extends X_DD_NetworkDistribution implements I_DD_NetworkDistributionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_ChangeNotice;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_DD_NetworkDistributionInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_DD_NetworkDistribution(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Network Distribution.
	 *
	 * @param DD_NetworkDistribution_ID Network Distribution
	 */

	public void setDD_NetworkDistribution_ID(int DD_NetworkDistribution_ID) {
		if (get_ID() == 0) {
			super.setDD_NetworkDistribution_ID(DD_NetworkDistribution_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setDD_NetworkDistribution_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getDD_NetworkDistribution_UU();
	}

	/**
	 * Set Change Notice.
	 *
	 * @param M_ChangeNotice Bill of Materials (Engineering) Change Notice (Version)
	 */
	@JsonProperty("M_ChangeNotice")
	public void setM_ChangeNoticeInput(ForeignEntityInput M_ChangeNotice) {
		this.mM_ChangeNotice = M_ChangeNotice;
		MChangeNotice foreignEntity;
		if (M_ChangeNotice != null &&
				(foreignEntity = new Query(getCtx(), "M_ChangeNotice", "M_ChangeNotice_UU=?", get_TrxName())
						.setParameters(M_ChangeNotice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ChangeNotice_ID(foreignEntity.get_ID());
		} else {
			super.setM_ChangeNotice_ID(0);
		}
	}

	/**
	 * Get Change Notice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	@JsonProperty("M_ChangeNotice")
	public ForeignEntityInput M_ChangeNotice() {
		return mM_ChangeNotice;
	}
}
