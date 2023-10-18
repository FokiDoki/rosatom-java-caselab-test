CREATE TABLE IF NOT EXISTS
    users (
                    user_id serial PRIMARY KEY,
                    username varchar NOT NULL,
                    password varchar NOT NULL,
                    reg_date date NOT NULL,
                    is_banned boolean DEFAULT false,
                    ip varchar
);