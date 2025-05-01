-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
INSERT INTO mt_customers (id, email, first_name, last_name, mother_name, birth_date) VALUES
(1, 'john.doe@example.com', 'John', 'Doe', 'Jane Doe', '1990-01-15'),
(2, 'jane.smith@example.com', 'Jane', 'Smith', 'Susan Smith', '1985-07-30'),
(3, 'bob.brown@example.com', 'Bob', 'Brown', 'Linda Brown', '2000-03-25');

INSERT INTO mt_products (id, name, description) VALUES
(1, 'Reguler', 'Tabungan dasar yang cocok untuk kebutuhan sehari-hari, dengan kemudahan akses dana melalui kartu debit dan berbagai transaksi'),
(2, 'TabunganKu', 'Tabungan yang dirancang khusus untuk membantu nasabah mengelola keuangan sehari-hari dengan fitur-fitur seperti setoran, penarikan, dan transfer'),
(3, 'Tabungan Pro', 'Tabungan yang ditujukan untuk individu aktif dengan kebutuhan transaksi yang lebih besar, seperti transfer dan penarikan'),
(4, 'Tabungan Woman One', 'Tabungan yang dirancang khusus untuk wanita, menawarkan berbagai keuntungan dan fasilitas'),

INSERT INTO mt_accounts (account_number, customer_id, product_id, balance, created_date) VALUES
('10000001', 1, 1, 1000, '2023-09-04'),
('10000002', 2, 4, 1000, '2023-09-04'),
('10000003', 3, 2, 120, '2023-09-04');

INSERT INTO mt_transactions (transaction_date, transaction_amount, type) VALUES
('2025-04-20 10:30:00', 100, 'TRANSFER');

INSERT INTO mt_transaction_transfers (transaction_id, beneficiary_account, status) VALUES
(1, '10000003', 'SUCCESS');
