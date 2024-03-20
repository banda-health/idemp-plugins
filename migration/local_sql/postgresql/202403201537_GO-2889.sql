ALTER TABLE c_invoice
	DROP COLUMN IF EXISTS bh_navbuttons;

ALTER TABLE c_payment
	DROP COLUMN IF EXISTS bh_navbuttons;

ALTER TABLE c_payment
	DROP COLUMN IF EXISTS nhif_number;

ALTER TABLE m_product
	DROP COLUMN IF EXISTS bh_navbuttons;

ALTER TABLE m_product
	DROP COLUMN IF EXISTS bh_product_category_type;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_bh_hasexpiration_check;

ALTER TABLE m_product
	DROP COLUMN IF EXISTS bh_hasexpiration;

ALTER TABLE c_orderline
	DROP COLUMN IF EXISTS bh_expiration;

ALTER TABLE c_orderline
	DROP COLUMN IF EXISTS bh_navbuttons;

ALTER TABLE c_invoiceline
	DROP COLUMN IF EXISTS bh_navbuttons;

ALTER TABLE m_inventory
	DROP COLUMN IF EXISTS bh_navbuttons;

ALTER TABLE m_inventoryline
	DROP COLUMN IF EXISTS bh_expiration;

ALTER TABLE m_inventoryline
	DROP COLUMN IF EXISTS bh_navbuttons;

ALTER TABLE m_productprice
	DROP COLUMN IF EXISTS bh_navbuttons;

DROP TABLE IF EXISTS bh_tabnavbtn_tab_trl;

DROP TABLE IF EXISTS bh_tabnavbtn_tab;

DROP TABLE IF EXISTS bh_tabnavbtn_trl;

DROP TABLE IF EXISTS bh_tabnavbtn;

DROP TABLE IF EXISTS bh_uibutton_trl;

DROP TABLE IF EXISTS bh_uibutton;

DROP TABLE IF EXISTS bh_stock_mvt_v;

DROP TABLE IF EXISTS bh_stockrevenue_view;

DROP VIEW IF EXISTS bh_stocktake_v;

DROP TABLE IF EXISTS bh_stocktake;

-- Delete the bh_navbuttons column from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			columnname ILIKE 'bh_navbuttons'
	);
DELETE
FROM
	ad_column
WHERE
	columnname ILIKE 'bh_navbuttons';
DELETE
FROM
	ad_element
WHERE
	columnname ILIKE 'bh_navbuttons';

-- Delete the nhif_number column from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			columnname ILIKE 'nhif_number'
	);
DELETE
FROM
	ad_column
WHERE
	columnname ILIKE 'nhif_number';
DELETE
FROM
	ad_element
WHERE
	columnname ILIKE 'nhif_number';

-- Delete the bh_product_category_type column on table m_product from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			columnname ILIKE 'bh_product_category_type'
			AND ad_table_id = 208
	);
DELETE
FROM
	ad_column
WHERE
	columnname ILIKE 'bh_product_category_type'
	AND ad_table_id = 208;

-- Delete the bh_hasexpiration column from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			columnname ILIKE 'bh_hasexpiration'
			AND ad_table_id = 208
	);
DELETE
FROM
	ad_column
WHERE
	columnname ILIKE 'bh_hasexpiration'
	AND ad_table_id = 208;

-- Delete the bh_expiration column from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			columnname ILIKE 'bh_expiration'
	);
DELETE
FROM
	ad_column
WHERE
	columnname ILIKE 'bh_expiration';
DELETE
FROM
	ad_element
WHERE
	columnname ILIKE 'bh_expiration';

-- Delete the bh_tabnavbtn_tab_trl table from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT ad_table_id FROM ad_table WHERE tablename ILIKE 'bh_tabnavbtn_tab_trl'
			)
	);
DELETE
FROM
	ad_tab
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT ad_table_id FROM ad_table WHERE tablename ILIKE 'bh_tabnavbtn_tab_trl'
			)
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = (
		SELECT ad_table_id FROM ad_table WHERE tablename ILIKE 'bh_tabnavbtn_tab_trl'
	);
DELETE
FROM
	ad_tab
WHERE
	ad_table_id = (
		SELECT ad_table_id FROM ad_table WHERE tablename ILIKE 'bh_tabnavbtn_tab_trl'
	);
DELETE
FROM
	ad_table
WHERE
	tablename ILIKE 'bh_tabnavbtn_tab_trl';

-- Delete the bh_tabnavbtn_tab table from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_tabnavbtn_tab'
			)
	);
DELETE
FROM
	ad_tab
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_tabnavbtn_tab'
			)
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_tabnavbtn_tab'
	);
DELETE
FROM
	ad_tab
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_tabnavbtn_tab'
	);
DELETE
FROM
	ad_package_imp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_tabnavbtn_tab'
	);
DELETE
FROM
	ad_table
WHERE
	tablename ILIKE 'bh_tabnavbtn_tab';

-- Delete the bh_tabnavbtn_trl table from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_tabnavbtn_trl'
			)
	);
DELETE
FROM
	ad_tab
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_tabnavbtn_trl'
			)
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_tabnavbtn_trl'
	);
DELETE
FROM
	ad_tab
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_tabnavbtn_trl'
	);
DELETE
FROM
	ad_table
WHERE
	tablename ILIKE 'bh_tabnavbtn_trl';

-- Delete the bh_tabnavbtn table from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_tabnavbtn'
			)
	);
DELETE
FROM
	ad_tab
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_tabnavbtn'
			)
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_tabnavbtn'
	);
DELETE
FROM
	ad_tab
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_tabnavbtn'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_tabnavbtn'
	);
DELETE
FROM
	ad_package_imp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_tabnavbtn'
	);
DELETE
FROM
	ad_table
WHERE
	tablename ILIKE 'bh_tabnavbtn';

-- Delete the bh_uibutton_trl table from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_uibutton_trl'
			)
	);
DELETE
FROM
	ad_tab
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_uibutton_trl'
			)
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_uibutton_trl'
	);
DELETE
FROM
	ad_tab
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_uibutton_trl'
	);
DELETE
FROM
	ad_table
WHERE
	tablename ILIKE 'bh_uibutton_trl';
DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_menu_id IN (
		SELECT
			ad_menu_id
		FROM
			ad_menu
		WHERE
			ad_window_id IN (
				SELECT
					ad_window_id
				FROM
					ad_window
				WHERE
					ad_window_uu = '656dd6d3-6926-4120-9f9a-a2fb858c0f86'
			)
	);
DELETE
FROM
	ad_menu
WHERE
	ad_window_id IN (
		SELECT
			ad_window_id
		FROM
			ad_window
		WHERE
			ad_window_uu = '656dd6d3-6926-4120-9f9a-a2fb858c0f86'
	);
DELETE
FROM
	ad_window
WHERE
	ad_window_uu = '656dd6d3-6926-4120-9f9a-a2fb858c0f86';

-- Delete the bh_uibutton table from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_uibutton'
			)
	);
DELETE
FROM
	ad_tab
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_uibutton'
			)
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_uibutton'
	);
DELETE
FROM
	ad_tab
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_uibutton'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_uibutton'
	);
DELETE
FROM
	ad_package_imp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_uibutton'
	);
DELETE
FROM
	ad_table
WHERE
	tablename ILIKE 'bh_uibutton';

-- Delete the bh_stock_mvt_v table from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stock_mvt_v'
			)
	);
DELETE
FROM
	ad_tab
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stock_mvt_v'
			)
	);
DELETE
FROM
	ad_printformatitem
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stock_mvt_v'
			)
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stock_mvt_v'
	);
DELETE
FROM
	ad_tab
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stock_mvt_v'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stock_mvt_v'
	);
DELETE
FROM
	ad_package_imp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stock_mvt_v'
	);
DELETE
FROM
	ad_printformat_trl
WHERE
	ad_printformat_id IN (
		SELECT
			ad_printformat_id
		FROM
			ad_printformat
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stock_mvt_v'
			)
	);
DELETE
FROM
	ad_printformat
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stock_mvt_v'
	);
DELETE
FROM
	ad_printformat
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stock_mvt_v'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_reportview_id IN (
				SELECT
					ad_reportview_id
				FROM
					ad_reportview
				WHERE
					ad_table_id = (
						SELECT
							ad_table_id
						FROM
							ad_table
						WHERE
							tablename ILIKE 'bh_stock_mvt_v'
					)
			)
	);
DELETE
FROM
	ad_pinstance
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_reportview_id IN (
				SELECT
					ad_reportview_id
				FROM
					ad_reportview
				WHERE
					ad_table_id = (
						SELECT
							ad_table_id
						FROM
							ad_table
						WHERE
							tablename ILIKE 'bh_stock_mvt_v'
					)
			)
	);
DELETE
FROM
	ad_process
WHERE
	ad_reportview_id IN (
		SELECT
			ad_reportview_id
		FROM
			ad_reportview
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stock_mvt_v'
			)
	);
DELETE
FROM
	ad_reportview
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stock_mvt_v'
	);
DELETE
FROM
	ad_table
WHERE
	tablename ILIKE 'bh_stock_mvt_v';

-- Delete the bh_stockrevenue_view table from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stockrevenue_view'
			)
	);
DELETE
FROM
	ad_tab
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stockrevenue_view'
			)
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stockrevenue_view'
	);
DELETE
FROM
	ad_tab
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stockrevenue_view'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stockrevenue_view'
	);
DELETE
FROM
	ad_package_imp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stockrevenue_view'
	);
DELETE
FROM
	ad_printformat_trl
WHERE
	ad_printformat_id IN (
		SELECT
			ad_printformat_id
		FROM
			ad_printformat
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stockrevenue_view'
			)
	);
DELETE
FROM
	ad_printformat
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stockrevenue_view'
	);
DELETE
FROM
	ad_printformat
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stockrevenue_view'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_reportview_id IN (
				SELECT
					ad_reportview_id
				FROM
					ad_reportview
				WHERE
					ad_table_id = (
						SELECT
							ad_table_id
						FROM
							ad_table
						WHERE
							tablename ILIKE 'bh_stockrevenue_view'
					)
			)
	);
DELETE
FROM
	ad_pinstance
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_reportview_id IN (
				SELECT
					ad_reportview_id
				FROM
					ad_reportview
				WHERE
					ad_table_id = (
						SELECT
							ad_table_id
						FROM
							ad_table
						WHERE
							tablename ILIKE 'bh_stockrevenue_view'
					)
			)
	);
DELETE
FROM
	ad_process
WHERE
	ad_reportview_id IN (
		SELECT
			ad_reportview_id
		FROM
			ad_reportview
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stockrevenue_view'
			)
	);
DELETE
FROM
	ad_reportview
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stockrevenue_view'
	);
DELETE
FROM
	ad_table
WHERE
	tablename ILIKE 'bh_stockrevenue_view';

-- Delete the bh_stocktake table from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stocktake'
			)
	);
DELETE
FROM
	ad_tab
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stocktake'
			)
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake'
	);
DELETE
FROM
	ad_tab
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake'
	);
DELETE
FROM
	ad_package_imp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake'
	);
DELETE
FROM
	ad_printformat_trl
WHERE
	ad_printformat_id IN (
		SELECT
			ad_printformat_id
		FROM
			ad_printformat
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stocktake'
			)
	);
DELETE
FROM
	ad_printformat
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake'
	);
DELETE
FROM
	ad_printformat
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_reportview_id IN (
				SELECT
					ad_reportview_id
				FROM
					ad_reportview
				WHERE
					ad_table_id = (
						SELECT
							ad_table_id
						FROM
							ad_table
						WHERE
							tablename ILIKE 'bh_stocktake'
					)
			)
	);
DELETE
FROM
	ad_pinstance
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_reportview_id IN (
				SELECT
					ad_reportview_id
				FROM
					ad_reportview
				WHERE
					ad_table_id = (
						SELECT
							ad_table_id
						FROM
							ad_table
						WHERE
							tablename ILIKE 'bh_stocktake'
					)
			)
	);
DELETE
FROM
	ad_process
WHERE
	ad_reportview_id IN (
		SELECT
			ad_reportview_id
		FROM
			ad_reportview
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stocktake'
			)
	);
DELETE
FROM
	ad_reportview
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake'
	);
DELETE
FROM
	ad_table
WHERE
	tablename ILIKE 'bh_stocktake';

-- Delete the bh_stocktake_v table from the DB records
DELETE
FROM
	ad_field
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stocktake_v'
			)
	);
DELETE
FROM
	ad_tab
WHERE
	ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stocktake_v'
			)
	);
DELETE
FROM
	ad_column
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake_v'
	);
DELETE
FROM
	ad_tab
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake_v'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake_v'
	);
DELETE
FROM
	ad_package_imp_detail
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake_v'
	);
DELETE
FROM
	ad_printformat_trl
WHERE
	ad_printformat_id IN (
		SELECT
			ad_printformat_id
		FROM
			ad_printformat
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stocktake_v'
			)
	);
DELETE
FROM
	ad_printformat
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake_v'
	);
DELETE
FROM
	ad_printformat
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake_v'
	);
DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_reportview_id IN (
				SELECT
					ad_reportview_id
				FROM
					ad_reportview
				WHERE
					ad_table_id = (
						SELECT
							ad_table_id
						FROM
							ad_table
						WHERE
							tablename ILIKE 'bh_stocktake_v'
					)
			)
	);
DELETE
FROM
	ad_pinstance
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_reportview_id IN (
				SELECT
					ad_reportview_id
				FROM
					ad_reportview
				WHERE
					ad_table_id = (
						SELECT
							ad_table_id
						FROM
							ad_table
						WHERE
							tablename ILIKE 'bh_stocktake_v'
					)
			)
	);
DELETE
FROM
	ad_process
WHERE
	ad_reportview_id IN (
		SELECT
			ad_reportview_id
		FROM
			ad_reportview
		WHERE
			ad_table_id = (
				SELECT
					ad_table_id
				FROM
					ad_table
				WHERE
					tablename ILIKE 'bh_stocktake_v'
			)
	);
DELETE
FROM
	ad_reportview
WHERE
	ad_table_id = (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			tablename ILIKE 'bh_stocktake_v'
	);
DELETE
FROM
	ad_table
WHERE
	tablename ILIKE 'bh_stocktake_v';

-- Remove some virtual columns from m_inventoryline
DELETE
FROM
	ad_column
WHERE
	ad_column_uu IN ('f32628ac-95a6-44f5-83cc-0da8eb59d1bb', '72531553-7bb5-40f8-8242-fb680b54d56b',
	                 'd7f7b0c6-9e5b-420a-87bc-dc42f84c4fff');

SELECT
	register_migration_script('202403201537_GO-2889.sql')
FROM
	dual;
