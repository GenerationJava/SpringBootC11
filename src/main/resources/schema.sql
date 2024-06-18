INSERT IGNORE INTO usuarios (nombre, apellido, correo, password) VALUES
                                                              ('Ash', 'Ketchum', 'ash.ketchum@pokemon.com', 'pikachu123'),
                                                              ('Misty', 'Williams', 'misty.williams@pokemon.com', 'togepi456'),
                                                              ('Brock', 'Harrison', 'brock.harrison@pokemon.com', 'onix789'),
                                                              ('Jessie', 'Murrow', 'jessie.james@teamrocket.com', 'meowth101'),
                                                              ('James', 'Morgan', 'james.morgan@teamrocket.com', 'wobbuffet202');

INSERT IGNORE INTO productos (nombre, stock, precio) VALUES
                                                  ('Pokeball', 100, 2.50),
                                                  ('Potion', 50, 1.00),
                                                  ('Rare Candy', 20, 5.00),
                                                  ('Pikachu Plush', 30, 10.00),
                                                  ('Trainer Hat', 15, 8.00);

INSERT IGNORE INTO roles (nombre_rol) values ("USER"), ("ADMIN");