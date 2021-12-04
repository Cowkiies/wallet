INSERT INTO 
	public.player (player_name)
VALUES
    ('Bernard'),
    ('Jean'),
    ('BigMat'),
    ('Manolis')
ON CONFLICT (id)
	DO NOTHING;