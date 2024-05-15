-- Crear categorías
INSERT INTO Categoria (id, nombre) VALUES (1, 'MELEE');
INSERT INTO Categoria (id, nombre) VALUES (2, 'DISTANCIA');
INSERT INTO Categoria (id, nombre) VALUES (3, 'CUERO');
INSERT INTO Categoria (id, nombre) VALUES (4, 'METAL');

INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Espada de la Aurora', 'Una espada adornada con gemas relucientes que emanan un brillo etéreo.', 5, 150.90, 'https://mortisdraco.com/wp-content/uploads/2019/11/442533.jpg', 1);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Hoja de la Oscuridad', 'Una espada negra con una hoja afilada que parece absorber la luz.', 8, 120.90, 'https://mortisdraco.com/wp-content/uploads/2019/11/442527.jpg', 1);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Espada del Viento', 'Una espada ligera y elegante que corta con la fuerza del viento mismo.', 10, 100.90, 'https://mortisdraco.com/wp-content/uploads/2024/01/402004.jpg', 1);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Filo del Crepúsculo', 'Una espada con un brillo dorado que parece fusionarse con el atardecer.', 3, 180.90, 'https://mortisdraco.com/wp-content/uploads/2019/11/442507.jpg', 1);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Espada del Rey Dragón', 'Forjada con escamas de dragón, esta espada emana un fuego eterno.', 2, 250.90, 'https://mortisdraco.com/wp-content/uploads/2020/05/452505-1.jpg', 1);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Espada de la Tormenta', 'Una espada con una hoja que centellea con la energía de una tormenta.', 6, 135.90, 'https://mortisdraco.com/wp-content/uploads/2023/12/30880250-01.jpg', 1);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Hoja del Destino', 'Una espada mítica cuya hoja refleja el destino de quien la empuña.', 4, 200.90, 'https://mortisdraco.com/wp-content/uploads/2022/08/eirikir-1.jpg', 1);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Espada de Cristal', 'Una espada translúcida que parece esculpida en hielo sólido.', 7, 110.90, 'https://mortisdraco.com/wp-content/uploads/2019/11/442422.jpg', 1);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Espada del Guerrero Errante', 'Forjada en los campos de batalla, esta espada ha probado su valía una y otra vez.', 9, 90.90, 'https://mortisdraco.com/wp-content/uploads/2019/10/Espada-%C3%89lfica-Epic-1.jpg', 1);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Espada de la Llamarada', 'Una espada con una hoja ardiente que consume todo a su paso.', 3, 175.90, 'https://mortisdraco.com/wp-content/uploads/2023/06/espada-dualist-01.jpg', 1);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Hoja de la Luna', 'Una espada con una hoja plateada que brilla con la luz de la luna llena.', 6, 130.90, 'https://mortisdraco.com/wp-content/uploads/2019/10/442440.jpg', 1);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Espada del Guardián', 'Forjada para proteger los reinos, esta espada es un símbolo de honor y deber.', 5, 160.90, 'https://mortisdraco.com/wp-content/uploads/2019/10/442421-1.jpg', 1);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Arco de la Luna', 'Un arco hecho de madera de roble blanco, con incrustaciones de plata que brillan con la luz de la luna.', 5, 180.50, 'https://mortisdraco.com/wp-content/uploads/2019/10/idv-04001-1.jpg', 2);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Arco de la Aurora', 'Un arco tallado con motivos de auroras boreales, que parece capturar la energía de las luces del norte.', 8, 210.75, 'https://mortisdraco.com/wp-content/uploads/2019/10/987029-Nomadenbogen-mit-Sehne-gross.jpg', 2);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Arco del Bosque Profundo', 'Un arco de aspecto rústico, hecho de madera de haya oscura y adornado con hojas entrelazadas.', 10, 150.25, 'https://mortisdraco.com/wp-content/uploads/2020/01/HU703411.jpg', 2);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Arco del Cazador', 'Un arco ligero y resistente, ideal para largas jornadas de caza en el bosque.', 3, 120.00, 'https://mortisdraco.com/wp-content/uploads/2020/01/HU703459.jpg', 2);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Arco de la Estrella Fugaz', 'Un arco adornado con gemas que brillan como estrellas en la noche, otorgando precisión y poder.', 2, 300.00, 'https://mortisdraco.com/wp-content/uploads/2019/10/hu703401-1.jpg', 2);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Arco del Valle Verde', 'Un arco de diseño elegante, con detalles de hojas y flores que evocan la exuberancia de la naturaleza.', 7, 190.90, 'https://mortisdraco.com/wp-content/uploads/2020/01/hu703452.jpg', 2);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Arco de la Sombra Nocturna', 'Un arco negro como la noche, cuya flecha se pierde en la oscuridad sin dejar rastro.', 4, 260.30, 'https://mortisdraco.com/wp-content/uploads/2019/10/971299-Pendragon-Langbogen.jpg', 2);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Arco del Maestro Arquero', 'Un arco de calidad excepcional, utilizado por los maestros arqueros más hábiles en combate.', 6, 320.50, 'https://mortisdraco.com/wp-content/uploads/2019/10/HU703410.jpg', 2);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Arco del Viento Silencioso', 'Un arco ligero y flexible, que permite disparar flechas con una precisión casi sobrenatural.', 9, 180.75, 'https://mortisdraco.com/wp-content/uploads/2019/10/987030-Nomadenbogen-mit-Sehne-klein.jpg', 2);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Arco del Alba Dorada', 'Un arco dorado que brilla con la primera luz del amanecer, otorgando esperanza a quienes lo empuñan.', 12, 240.60, 'https://mortisdraco.com/wp-content/uploads/2019/10/Koppany-Reiterbogen.jpg', 2);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Arco de la Niebla Matinal', 'Un arco envuelto en la neblina de la mañana, que parece desvanecerse en el aire al ser disparado.', 3, 200.25, 'https://mortisdraco.com/wp-content/uploads/2019/10/HU703407.jpg', 2);
INSERT INTO Producto (nombre, descripcion, stock, precio, imagen, categoria_id) VALUES ('Arco del Halcón Veloz', 'Un arco diseñado para la velocidad, que permite disparar múltiples flechas con una rapidez asombrosa.', 11, 280.80, 'https://mortisdraco.com/wp-content/uploads/2019/10/HU703405BL.jpg', 2);


INSERT INTO Usuario (username, nombre, apellidos, email, password, direccion, tipo) VALUES ('admin', 'Daniel', 'Martinez León', 'danimairena@hotmail.com', '{bcrypt}$2a$10$RlcLSXIvm8VDjEBq19oB7OFEB3sJnxvJETStFrBeHwU1pYc0EGTTa', 'Calle Falsa 123', 'ADMIN');
INSERT INTO Usuario (username, nombre, apellidos, email, password, direccion, tipo) VALUES ('user', 'Luismi', 'Lopez', 'luismi.lopez@triana.salesianos.edu', '{bcrypt}$2a$10$ujGoDBbum85IdrR8Uloix.x7K0MzX2k5/47Ejig8LzH8S7UFGPSvO', 'Calle Falsa 434', 'USER');