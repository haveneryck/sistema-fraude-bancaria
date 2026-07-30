DELETE FROM transacao;

INSERT INTO transacao (valor, origem, fraude) VALUES
(5000, 'internacional', 'sim'),
(10000, 'internacional', 'sim'),
(7500, 'internacional', 'sim'),
(8000, 'internacional', 'sim'),
(6200, 'internacional', 'sim'),
(9500, 'internacional', 'sim'),
(4800, 'internacional', 'sim'),
(11000, 'internacional', 'sim'),

(200, 'nacional', 'nao'),
(150, 'nacional', 'nao'),
(300, 'nacional', 'nao'),
(400, 'nacional', 'nao'),
(250, 'nacional', 'nao'),
(180, 'nacional', 'nao'),
(320, 'nacional', 'nao'),
(90, 'nacional', 'nao'),

(1000, 'nacional', 'sim'),
(1500, 'nacional', 'sim'),
(20000, 'nacional', 'sim'),
(3000, 'nacional', 'sim'),
(2500, 'internacional', 'nao'),
(1800, 'internacional', 'nao'),
(600, 'internacional', 'nao'),
(700, 'nacional', 'nao'),

(1200, 'internacional', 'sim'),
(50, 'internacional', 'nao'),
(15000, 'internacional', 'sim'),
(350, 'internacional', 'nao'),
(2200, 'nacional', 'sim'),
(120, 'nacional', 'nao'),
(9000, 'nacional', 'sim'),
(280, 'internacional', 'nao');