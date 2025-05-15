drop table IF EXISTS account;
create table account (
    account_seq serial primary key,
    branch char(3) not null,
    account char(7) not null,
    branch_nm varchar(64)  not null,
    account_nm varchar(64)  not null,
    open_date date,
    status char not null default '0',
    memo varchar(128),
    created_at timestamp,
    updated_at timestamp
);
COMMENT ON TABLE account is '口座';
COMMENT ON COLUMN account.account_seq is '口座SEQ';
COMMENT ON COLUMN account.branch is '支店CD';
COMMENT ON COLUMN account.account is '口座番号';
COMMENT ON COLUMN account.branch_nm is '支店名';
COMMENT ON COLUMN account.account_nm is '口座名義';
COMMENT ON COLUMN account.open_date is '開設日';
COMMENT ON COLUMN account.status is 'ステータス';
COMMENT ON COLUMN account.memo is 'メモ';
COMMENT ON COLUMN account.created_at is '作成日';
COMMENT ON COLUMN account.updated_at is '更新日';