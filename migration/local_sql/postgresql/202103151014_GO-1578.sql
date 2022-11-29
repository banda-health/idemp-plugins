-- Reset person's open balance
UPDATE c_bpartner SET totalopenbalance = totalopenbalance + 379 WHERE c_bpartner_uu = 'aa28854c-8470-4d62-b73b-3219c530ce37';

-- Reset a payment that didn't calculate change correctly
UPDATE c_payment SET payamt = payamt - 379 WHERE c_payment_uu = '51e80c64-99a6-4504-ac86-fd81547c8423';

SELECT register_migration_script('202103151014_GO-1578.sql') FROM dual;
