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
    (1,100, 100),
    (2, 50, 0),
    (3, 25, 0)
ON CONFLICT (id)
	DO NOTHING;

INSERT INTO 
	public.transactions (player_id, amount, date_utc)
VALUES
    (1, 100, '2021-12-05'),
    (2, 50, '2021-12-06'),
    (3, 0, '2021-12-12'),
    (3, 25, '2021-12-12')
ON CONFLICT (id)
	DO NOTHING;