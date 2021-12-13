INSERT INTO 
	public.player (id, first_name, last_name, phone, email)
VALUES
    (1, 'John', 'Doe', '+33698072045', 'johndoe@gmail.com'),
    (2, 'Richard', 'Roe', '+35612344321', 'richardroe@gmail.com'),
    (3, 'Jane', 'Doe', '+35656788765', 'janedoe@gmail.com')
ON CONFLICT (id)
	DO NOTHING;

INSERT INTO 
	public.wallet (player_id, cash_amount, bonus_amount)
VALUES
    (1,100.0, 100.0),
    (2, 50.0, 0.0),
    (3, 25.0, 0.0)
ON CONFLICT (id)
	DO NOTHING;

INSERT INTO 
	public.transactions (player_id, amount, date_utc)
VALUES
    (1, 100.0, '2021-12-05'),
    (2, 50.0, '2021-12-06'),
    (3, 0.0, '2021-12-12'),
    (3, 25.0, '2021-12-12')
ON CONFLICT (id)
	DO NOTHING;

INSERT INTO
    public.bets (player_id, status, cash_amount, bonus_amount)
VALUES
    (1, 'PENDING', 25.0, 0.0),
    (2, 'PENDING', 0.0, 50.0),
    (3, 'PENDING', 75.0, 25.0);