drop table IF EXISTS payment_history;
create TABLE payment_history (
    history_no serial primary key,
    deposit_date date,
    branch char(3) not null,
    account char(7) not null,
    transfer_source varchar(64),
    withdrawal_amount integer,
    deposit_amount integer,
    balance integer,
    memo varchar(128),
    created_at timestamp,
    updated_at timestamp
);
COMMENT ON TABLE payment_history is '入金履歴';
COMMENT ON COLUMN payment_history.history_no is '履歴番号';
COMMENT ON COLUMN payment_history.deposit_date is '入金日';
COMMENT ON COLUMN payment_history.branch is '支店CD';
COMMENT ON COLUMN payment_history.account is '口座番号';
COMMENT ON COLUMN payment_history.transfer_source is '振込元';
COMMENT ON COLUMN payment_history.withdrawal_amount is '出金金額(円)';
COMMENT ON COLUMN payment_history.deposit_amount is '入金金額(円)';
COMMENT ON COLUMN payment_history.balance is '残高(円)';
COMMENT ON COLUMN payment_history.memo is 'メモ';
COMMENT ON COLUMN payment_history.created_at is '作成日';
COMMENT ON COLUMN payment_history.updated_at is '更新日';