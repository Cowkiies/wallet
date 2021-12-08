CREATE TABLE public.player (
	id serial PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	phone VARCHAR(15),
	email VARCHAR(100) NOT NULL
);

CREATE TABLE public.wallet (
	id serial PRIMARY KEY,
	player_id serial REFERENCES player,
	cash_amount INTEGER DEFAULT 0,
	bonus_amount INTEGER DEFAULT 0 CONSTRAINT positive_bonus_amount CHECK (bonus_amount >= 0)
);

CREATE TABLE public.transactions (
	id serial PRIMARY KEY,
	player_id INTEGER REFERENCES player,
	amount INTEGER DEFAULT 0,
	date_utc TIMESTAMP WITHOUT TIME ZONE DEFAULT (NOW() AT TIME ZONE 'utc') NOT NULL
);