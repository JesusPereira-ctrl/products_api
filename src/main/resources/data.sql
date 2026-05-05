INSERT INTO category (name) VALUES 
('Ropa'),
('Calzado'),
('Deportes'),
('Alimentación'),
('Bebidas'),
('Limpieza'),
('Mascotas'),
('Jardinería'),
('Ferretería'),
('Automotriz');

INSERT INTO product (name, description, stock) VALUES 
('Zapatillas Running', 'Suela amortiguada para corredores', 80),
('Polera Térmica', 'Ideal para climas fríos', 120),
('Proteína Whey 1kg', 'Sabor chocolate, 25g proteína por porción', 60),
('Aceite de Oliva 1L', 'Extra virgen prensado en frío', 90),
('Detergente Líquido 3L', 'Fórmula concentrada para ropa delicada', 150),
('Alimento Perro 15kg', 'Fórmula premium para razas grandes', 40),
('Guantes de Boxeo', 'Cuero sintético 12oz', 35),
('Manguera Jardín 20m', 'Con pistola de agua ajustable', 25),
('Juego de Llaves', 'Set 20 piezas acero cromo vanadio', 50),
('Aceite Motor 5W30', 'Sintético para motores modernos', 70);

INSERT INTO product_category (product_id, category_id) VALUES 
(1, 2), (1, 3),  
(2, 1), (2, 3),  
(3, 4), (3, 3),  
(4, 4), (4, 5),  
(5, 6), (5, 1),  
(6, 7), (6, 4),  
(7, 3), (7, 1),  
(8, 8), (8, 9),  
(9, 9), (9, 10), 
(10, 10), (10, 9); 