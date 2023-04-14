-- Visits/Bills
UPDATE bh_dbrdbtngrp_btn SET lineno = 10 WHERE bh_dbrdbtngrp_btn_uu = '35e36aad-3667-4212-80b1-7693725db473';
-- Patients 
UPDATE bh_dbrdbtngrp_btn SET lineno = 20 WHERE bh_dbrdbtngrp_btn_uu = '4dd0e4df-20bc-48cd-9bb9-358af7954601';
-- services and prices
UPDATE bh_dbrdbtngrp_btn SET lineno = 30 WHERE bh_dbrdbtngrp_btn_uu = 'a27677ca-cc76-4595-af41-9909d5500f93';
--- Products and prices
UPDATE bh_dbrdbtngrp_btn SET lineno = 40 WHERE bh_dbrdbtngrp_btn_uu = 'beade859-7122-41da-834f-f7a8ac5a81d5';
-- Receive Products
UPDATE bh_dbrdbtngrp_btn SET lineno = 50 WHERE bh_dbrdbtngrp_btn_uu = '674a0a2b-2eda-4502-984e-2ee4b63dcc7a';
-- Suppliers
UPDATE bh_dbrdbtngrp_btn SET lineno = 60 WHERE bh_dbrdbtngrp_btn_uu = '64746aed-41f0-4cef-a7d8-3c574d12639f';
-- Manage Inventory
UPDATE bh_dbrdbtngrp_btn SET lineno = 70 WHERE bh_dbrdbtngrp_btn_uu = 'a3ce69ef-8577-4458-a0c2-94f7606088da';
-- Debt payments / Pay open balance
UPDATE bh_dbrdbtngrp_btn SET lineno = 80 WHERE bh_dbrdbtngrp_btn_uu = 'f0a2ba7a-765c-4239-bb91-910ee85e6017';
-- Track Expenses
UPDATE bh_dbrdbtngrp_btn SET lineno = 90 WHERE bh_dbrdbtngrp_btn_uu = '2bd2f18b-7fe9-4079-b074-8dc113b98714';
-- Expense categories 
UPDATE bh_dbrdbtngrp_btn SET lineno = 100 WHERE bh_dbrdbtngrp_btn_uu = '8f5d51d4-e64e-4784-bcfa-cf96330f6422';
-- Transfer Inventory
UPDATE bh_dbrdbtngrp_btn SET lineno = 120 WHERE bh_dbrdbtngrp_btn_uu = '1da38275-67b8-4bb6-b409-db37b2decc9f';

SELECT register_migration_script('202112161600_GO-2019.sql') FROM dual;
