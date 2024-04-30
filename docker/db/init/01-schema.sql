\c todo_db;
-- 初期化処理
DROP TABLE IF EXISTS todos;
DROP TABLE IF EXISTS users;

-- テーブル作成
CREATE TABLE todos (
    id SERIAL PRIMARY KEY,
    todo VARCHAR(255) NOT NULL,
    detail text,
    created_at timestamp without time zone,
    updated_at timestamp without time zone
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);