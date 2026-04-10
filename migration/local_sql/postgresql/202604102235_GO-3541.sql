/**********************************************************************************************************/
-- GO-3541: Align AR Invoice sequence when invoices already use numbers >= currentnext (OTC / visit processing)
--
-- iDempiere stores invoice document counters in ad_sequence (name AR Invoice), not under c_doctype.name.
-- We only consider invoices whose c_doctypetarget_id is one of the allowed AR invoice document types.
/**********************************************************************************************************/

UPDATE ad_sequence s
SET
	currentnext = sub.new_currentnext
FROM
	(
		SELECT
			t.ad_sequence_id,
			t.new_currentnext
		FROM
			(
				SELECT
					seq.ad_sequence_id,
					(
						SELECT
							MAX(ci.documentno::bigint) + 1
						FROM
							c_invoice ci
						WHERE
							ci.ad_client_id = seq.ad_client_id
							AND ci.documentno::bigint >= seq.currentnext
							AND EXISTS (
								SELECT
									1
								FROM
									c_doctype dt
								WHERE
									dt.c_doctype_id = ci.c_doctypetarget_id
									AND dt.ad_client_id = ci.ad_client_id
									AND dt.isactive = 'Y'
									AND dt.docbasetype = 'ARI'
									AND dt.issotrx = 'Y'
									AND dt.name = 'AR Invoice'
									AND dt.docnosequence_id = seq.ad_sequence_id
							)
					) AS new_currentnext
				FROM
					ad_sequence seq
				WHERE
					seq.isactive = 'Y'
					AND seq.name = 'AR Invoice'
			) t
		WHERE
			t.new_currentnext IS NOT NULL
	) sub
WHERE
	s.ad_sequence_id = sub.ad_sequence_id;

SELECT
	register_migration_script('202604102235_GO-3541.sql')
FROM
	dual;
