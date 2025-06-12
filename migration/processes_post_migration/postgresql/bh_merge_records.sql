DROP FUNCTION IF EXISTS bh_merge_records(varchar, uuid, uuid);
CREATE OR REPLACE FUNCTION bh_merge_records(_tableName varchar, _uu_old uuid, _uu_new uuid)
	RETURNS void
AS
$$
DECLARE
	statement varchar;
	id_old    numeric;
	id_new    numeric;
BEGIN
	DROP TABLE IF EXISTS tmp_update_statements;
	CREATE TEMP TABLE tmp_update_statements
	(
		statement varchar
	);

	EXECUTE 'SELECT ' || _tableName || '_id FROM ' || _tableName || ' WHERE ' || _tableName || '_uu = ''' || _uu_old ||
	        ''';' INTO id_old;
	EXECUTE 'SELECT ' || _tableName || '_id FROM ' || _tableName || ' WHERE ' || _tableName || '_uu = ''' || _uu_new ||
	        ''';' INTO id_new;

	RAISE NOTICE 'clearing specific tables...';
	IF LOWER(_tableName) = 'c_bpartner' THEN
		EXECUTE 'DELETE FROM c_bp_employee_acct WHERE c_bpartner_id = ' || id_old || ';';
		EXECUTE 'DELETE FROM c_bp_customer_acct WHERE c_bpartner_id = ' || id_old || ';';
		EXECUTE 'DELETE FROM c_bp_vendor_acct WHERE c_bpartner_id = ' || id_old || ';';
		EXECUTE 'DELETE FROM t_aging WHERE c_bpartner_id = ' || id_old || ';';
		EXECUTE 'DELETE FROM c_bpartner_location WHERE c_bpartner_id = ' || id_old || ';';
	ELSEIF LOWER(_tableName) = 'm_product' THEN
		EXECUTE 'DELETE FROM m_product_trl WHERE m_product_id = ' || id_old || ';';
		EXECUTE 'DELETE FROM m_product_acct WHERE m_product_id = ' || id_old || ';';
		EXECUTE 'DELETE FROM m_productprice WHERE m_product_id = ' || id_old || ';';
		EXECUTE 'DELETE FROM m_replenish WHERE m_product_id = ' || id_old || ';';
		EXECUTE 'DELETE FROM t_replenish WHERE m_product_id = ' || id_old || ';';
		EXECUTE 'DELETE FROM m_product_po WHERE m_product_id = ' || id_old || ';';
		EXECUTE 'DELETE FROM m_cost WHERE m_product_id = ' || id_old || ';';
		-- Update reservations correctly
		EXECUTE '
			UPDATE m_storagereservation soh1
			SET
				qty = COALESCE(qty, 0) + COALESCE((
					SELECT
						qty
					FROM
						m_storagereservation soh2
					WHERE
						soh1.issotrx = soh2.issotrx
						AND soh1.m_attributesetinstance_id = soh2.m_attributesetinstance_id
						AND soh1.m_warehouse_id = soh2.m_warehouse_id
						AND soh2.m_product_id = ' || id_old || '
				), 0)
			WHERE
				m_product_id = ' || id_new || ';';
		EXECUTE '
			UPDATE m_storagereservation soh1
			SET
				m_product_id = ' || id_new || '
			WHERE
				m_product_id = ' || id_old || '
				AND NOT EXISTS (
					SELECT
						1
					FROM
						m_storagereservation soh2
					WHERE
						soh1.issotrx = soh2.issotrx
						AND soh1.m_attributesetinstance_id = soh2.m_attributesetinstance_id
						AND soh1.m_warehouse_id = soh2.m_warehouse_id
						AND soh1.m_product_id = soh2.m_product_id
				)';
		EXECUTE 'DELETE FROM m_storagereservation WHERE m_product_id = ' || id_old || ';';
	ELSEIF LOWER(_tableName) = 'ad_user' THEN
		EXECUTE 'DELETE FROM ad_user_roles WHERE ad_user_id = ' || id_old || ';';
	ELSEIF LOWER(_tableName) = 'ad_org' THEN
		EXECUTE 'DELETE FROM ad_orginfo WHERE ad_org_id = ' || id_old || ';';
		EXECUTE 'DELETE FROM ad_role_orgaccess WHERE ad_org_id = ' || id_old || ';';
	END IF;

	INSERT INTO tmp_update_statements
	SELECT
		LOWER('UPDATE ' || la.attrelid::regclass || ' SET ' || la.attname || ' = ' || id_new || ' WHERE ' ||
		      la.attname || ' = ' || id_old || ';') AS statement
	FROM
		pg_constraint AS c
			JOIN pg_index AS i
			ON i.indexrelid = c.conindid
			JOIN pg_attribute AS la
			ON la.attrelid = c.conrelid
			AND la.attnum = c.conkey[1]
			JOIN pg_attribute AS ra
			ON ra.attrelid = c.confrelid
			AND ra.attnum = c.confkey[1]
	WHERE
		c.confrelid = LOWER(_tableName)::regclass
		AND c.contype = 'f'
		AND ra.attname = LOWER(_tablename) || '_id'
		AND CARDINALITY(c.confkey) = 1
	UNION
	SELECT
		LOWER('UPDATE ' || t.TableName || ' SET ' || c.ColumnName || ' = ' || id_new || ' WHERE ' ||
		      c.ColumnName || ' = ' || id_old || ';')
	FROM
		AD_Table t
			INNER JOIN AD_Column c
			ON t.AD_Table_ID = c.AD_Table_ID
	WHERE
		t.IsView = 'N'
		AND t.TableName NOT IN ('C_TaxDeclarationAcct')
		AND (
			(LOWER(c.ColumnName) = LOWER(_tablename) || '_id' AND c.IsKey = 'N')
				OR
			c.AD_Reference_Value_ID IN
			(
				SELECT
					rt.AD_Reference_ID
				FROM
					AD_Ref_Table rt
						INNER JOIN AD_Column cc
						ON rt.AD_Table_ID = cc.AD_Table_ID AND rt.AD_Key = cc.AD_Column_ID
				WHERE
					cc.IsKey = 'Y'
					AND LOWER(cc.ColumnName) = LOWER(_tablename) || '_id'
			)
			)
		AND c.ColumnSQL IS NULL;

	RAISE NOTICE 'executing FK updates...';
	FOR statement IN SELECT * FROM tmp_update_statements
		LOOP
			RAISE NOTICE 'updating %...', (
				SELECT SPLIT_PART(statement, ' ', 2)
			);
			EXECUTE statement;
		END LOOP;

	DROP TABLE IF EXISTS tmp_update_statements;

	RAISE NOTICE 'deleting old record...';
	EXECUTE 'DELETE FROM ' || _tableName || ' WHERE ' || _tableName || '_id = ' || id_old;

	RAISE NOTICE 'performing final tasks...';
	IF LOWER(_tableName) = 'c_bpartner' THEN
		-- Update BP-specific fields
		EXECUTE '
			UPDATE c_bpartner bp
			SET
				so_creditused    = COALESCE(calc.so_creditused, bp.so_creditused),
				totalopenbalance = COALESCE(calc.totalopenbalance, bp.totalopenbalance),
				socreditstatus   = CASE
					                   WHEN bp.socreditstatus IN (''X'', ''S'') OR bp.so_creditlimit = 0 THEN bp.socreditstatus
					                   WHEN bp.so_creditlimit < COALESCE(calc.totalopenbalance, bp.totalopenbalance) THEN ''H''
					                   WHEN bp.so_creditlimit * 0.9 < COALESCE(calc.totalopenbalance, bp.totalopenbalance) THEN ''W''
					                   ELSE ''O'' END,
				actuallifetimevalue = COALESCE(calc.actuallifetimevalue, bp.actuallifetimevalue)
			FROM
				(
					SELECT
						COALESCE((
							         SELECT
								         SUM(currencyBase(invoiceOpen(i.C_Invoice_ID, i.C_InvoicePaySchedule_ID), i.C_Currency_ID,
								                          i.DateInvoiced,
								                          i.AD_Client_ID, i.AD_Org_ID))
							         FROM
								         C_Invoice_v i
							         WHERE
								         i.C_BPartner_ID = bp.C_BPartner_ID
								         AND i.IsSOTrx = ''Y''
								         AND i.IsPaid = ''N''
								         AND i.DocStatus IN (''CO'', ''CL'')
						         ), 0)                  AS so_creditused,
						COALESCE((
							         SELECT
								         SUM(currencyBase(invoiceOpen(i.C_Invoice_ID, i.C_InvoicePaySchedule_ID), i.C_Currency_ID,
								                          i.DateInvoiced, i.AD_Client_ID, i.AD_Org_ID) * i.MultiplierAP)
							         FROM
								         C_Invoice_v i
							         WHERE
								         i.C_BPartner_ID = bp.C_BPartner_ID
								         AND i.IsPaid = ''N''
								         AND i.DocStatus IN (''CO'', ''CL'')
						         ), 0) - COALESCE((
							                          SELECT
								                          SUM(currencyBase(Paymentavailable(p.C_Payment_ID), p.C_Currency_ID, p.DateTrx,
								                                           p.AD_Client_ID, p.AD_Org_ID))
							                          FROM
								                          C_Payment_v p
							                          WHERE
								                          p.C_BPartner_ID = bp.C_BPartner_ID
								                          AND p.IsAllocated = ''N''
								                          AND p.C_Charge_ID IS NULL
								                          AND p.DocStatus IN (''CO'', ''CL'')
						                          ), 0) AS totalopenbalance,
						COALESCE((
											SELECT
												SUM(currencyBase(i.GrandTotal, i.C_Currency_ID, i.DateInvoiced, i.AD_Client_ID, i.AD_Org_ID))
											FROM
												C_Invoice_v i
											WHERE
												i.C_BPartner_ID = bp.C_BPartner_ID
												AND i.IsSOTrx = ''Y''
												AND i.DocStatus IN (''CO'', ''CL'')
										), 0)                  AS actualLifetimeValue,
						bp.c_bpartner_id
					FROM
						C_BPartner bp
					WHERE
						bp.c_bpartner_id = ' || id_new || '
				) calc
			WHERE
				calc.c_bpartner_id = bp.c_bpartner_id;';
	END IF;
END
$$
	LANGUAGE plpgsql;
