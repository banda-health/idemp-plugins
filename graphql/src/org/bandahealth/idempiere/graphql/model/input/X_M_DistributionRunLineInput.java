package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDistributionList;
import org.compiere.model.MDistributionRun;
import org.compiere.model.MDistributionRunLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for M_DistributionRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_DistributionRunLineInput extends MDistributionRunLine implements I_M_DistributionRunLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_DistributionList;
	private ForeignEntityInput mM_DistributionRun;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_DistributionRunLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MDistributionRunLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Distribution List.
	 *
	 * @param M_DistributionList Distribution Lists allow to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionList")
	public void setM_DistributionListInput(ForeignEntityInput M_DistributionList) {
		this.mM_DistributionList = M_DistributionList;
		MDistributionList foreignEntity;
		if (M_DistributionList != null &&
				(foreignEntity = new Query(getCtx(), "M_DistributionList", "M_DistributionList_UU=?", get_TrxName())
						.setParameters(M_DistributionList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_DistributionList_ID(foreignEntity.get_ID());
		} else {
			super.setM_DistributionList_ID(0);
		}
	}

	/**
	 * Get Distribution List.
	 *
	 * @return Distribution Lists allow to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionList")
	public ForeignEntityInput M_DistributionList() {
		return mM_DistributionList;
	}

	/**
	 * Set Distribution Run.
	 *
	 * @param M_DistributionRun Distribution Run create Orders to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionRun")
	public void setM_DistributionRunInput(ForeignEntityInput M_DistributionRun) {
		this.mM_DistributionRun = M_DistributionRun;
		MDistributionRun foreignEntity;
		if (get_ID() == 0 && M_DistributionRun != null &&
				(foreignEntity = new Query(getCtx(), "M_DistributionRun", "M_DistributionRun_UU=?", get_TrxName())
						.setParameters(M_DistributionRun.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_DistributionRun_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Distribution Run.
	 *
	 * @return Distribution Run create Orders to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionRun")
	public ForeignEntityInput M_DistributionRun() {
		return mM_DistributionRun;
	}
	/**
	 * Set Distribution Run Line.
	 *
	 * @param M_DistributionRunLine_ID Distribution Run Lines define Distribution List, the Product and Quantities
	 */

	public void setM_DistributionRunLine_ID(int M_DistributionRunLine_ID) {
		if (get_ID() == 0) {
			super.setM_DistributionRunLine_ID(M_DistributionRunLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_DistributionRunLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_DistributionRunLine_UU();
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}
}
