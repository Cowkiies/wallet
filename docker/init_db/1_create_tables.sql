CREATE TABLE public.player (
	id bigserial PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	phone VARCHAR(15),
	email VARCHAR(100) NOT NULL
);

CREATE TABLE public.wallet (
	id bigserial PRIMARY KEY,
	player_id BIGINT REFERENCES player,
	cash_amount FLOAT DEFAULT 0 CHECK (cash_amount >= 0),
	bonus_amount FLOAT DEFAULT 0 CHECK (bonus_amount >= 0)
);

CREATE TABLE public.transactions (
	id bigserial PRIMARY KEY,
	player_id BIGINT REFERENCES player,
	amount FLOAT DEFAULT 0,
	date_utc TIMESTAMP WITHOUT TIME ZONE DEFAULT (NOW() AT TIME ZONE 'utc') NOT NULL
);

CREATE TABLE public.bets (
	id bigserial PRIMARY KEY,
	player_id BIGINT REFERENCES player,
	status VARCHAR(10) NOT NULL,
	cash_amount FLOAT DEFAULT 0 CHECK (cash_amount >= 0),
	bonus_amount FLOAT DEFAULT 0 CHECK (bonus_amount >= 0)
);