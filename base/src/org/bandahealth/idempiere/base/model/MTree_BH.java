package org.bandahealth.idempiere.base.model;

import org.compiere.model.MTree;
import org.compiere.model.MTree_Base;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Added solely because MTree doesn't have a UUID constructor - remove this if it ever gets one
 */
public class MTree_BH extends MTree {
	public MTree_BH(Properties ctx, String Record_UU, String trxName) {
		super(ctx, new MTree_Base(ctx, Record_UU, trxName).get_ID(), trxName);
	}

	public MTree_BH(Properties ctx, int AD_Tree_ID, String trxName) {
		super(ctx, AD_Tree_ID, trxName);
	}

	public MTree_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MTree_BH(Properties ctx, int AD_Tree_ID, boolean editable, boolean clientTree, String trxName) {
		super(ctx, AD_Tree_ID, editable, clientTree, trxName);
	}

	public MTree_BH(Properties ctx, int AD_Tree_ID, boolean editable, boolean clientTree, String trxName,
			String linkColName, int linkID) {
		super(ctx, AD_Tree_ID, editable, clientTree, trxName, linkColName, linkID);
	}

	public MTree_BH(Properties ctx, int AD_Tree_ID, boolean editable, boolean clientTree, boolean allNodes,
			String trxName) {
		super(ctx, AD_Tree_ID, editable, clientTree, allNodes, trxName);
	}

	public MTree_BH(Properties ctx, int AD_Tree_ID, boolean editable, boolean clientTree, boolean allNodes,
			String trxName,
			String linkColName, int linkID) {
		super(ctx, AD_Tree_ID, editable, clientTree, allNodes, trxName, linkColName, linkID);
	}
}
