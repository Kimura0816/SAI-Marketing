drop table IF EXISTS system_config;
create table system_config (
    keyword varchar(32) primary key,
    val varchar(64),
    created_at timestamp,
    updated_at timestamp
);
COMMENT ON TABLE system_config is 'システム設定';
COMMENT ON COLUMN system_config.val is '設定値';
COMMENT ON COLUMN system_config.created_at is '作成日';
COMMENT ON COLUMN system_config.updated_at is '更新日';

INSERT INTO system_config(keyword, val, created_at, updated_at) VALUES ('admin.id','admin', current_timestamp, current_timestamp);
INSERT INTO system_config(keyword, val, created_at, updated_at) VALUES ('admin.pass','pass6190', current_timestamp, current_timestamp);
INSERT INTO system_config(keyword, val, created_at, updated_at) VALUES ('mail.from','develop@kimura.mail-box.ne.jp', current_timestamp, current_timestamp);
INSERT INTO system_config(keyword, val, created_at, updated_at) VALUES ('mail.user','develop@kimura.mail-box.ne.jp', current_timestamp, current_timestamp);
INSERT INTO system_config(keyword, val, created_at, updated_at) VALUES ('mail.pass','develop0077', current_timestamp, current_timestamp);
INSERT INTO system_config(keyword, val, created_at, updated_at) VALUES ('mail.host','www3564.sakura.ne.jp', current_timestamp, current_timestamp);
INSERT INTO system_config(keyword, val, created_at, updated_at) VALUES ('mail.port','587', current_timestamp, current_timestamp);
INSERT INTO system_config(keyword, val, created_at, updated_at) VALUES ('mail.starttls','true', current_timestamp, current_timestamp);
INSERT INTO system_config(keyword, val, created_at, updated_at) VALUES ('mail.debug','true', current_timestamp, current_timestamp);

