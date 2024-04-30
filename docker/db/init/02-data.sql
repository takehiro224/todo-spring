BEGIN;

-- データ登録
INSERT INTO todos (todo, detail, created_at, updated_at) VALUES ('買い物', 'スーバーで食材を購入する', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO todos (todo, detail, created_at, updated_at) VALUES ('図書館', '本を借りる', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO todos (todo, detail, created_at, updated_at) VALUES ('ジム', '運動する', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO users (name) VALUES ('Taro');


COMMIT;