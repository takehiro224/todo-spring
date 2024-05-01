DROP TABLE IF EXISTS todos;
CREATE TABLE todos (
    id SERIAL PRIMARY KEY,
    todo VARCHAR(255) NOT NULL,
    detail text,
    created_at timestamp without time zone,
    updated_at timestamp without time zone
);