INSERT INTO book (title, author, description, copies, copies_available, category, img) VALUES 
	('Java Programming (MindTap Course List)', 'Joyce Farrell', 'There are many variations of passages of Lorem Ipsum available but the majority have suffered alteration in some form by injected humour or randomised words which dont look even slightly believable.', 5, 5, 'BE', 'https://m.media-amazon.com/images/I/51yZK3eogtL._SX504_BO1,204,203,200_.jpg'),
	('Mastering Node.js - Second Edition: Build robust and scalable real-time server-side web applications efficiently', ' Sandro Pasquali', 'There are many variations of passages of Lorem Ipsum available but the majority have suffered alteration in some form by injected humour or randomised words which dont look even slightly believable.', 4, 1, 'BE', 'https://m.media-amazon.com/images/I/51v-TjQGaCL._SX404_BO1,204,203,200_.jpg'),
    	('Mastering PostgreSQL 13 - Fourth Edition: Build, administer, and maintain database applications efficiently with PostgreSQL 13', 'Schonig, Hans-Jurgen', 'There are many variations of passages of Lorem Ipsum available but the majority have suffered alteration in some form by injected humour or randomised words which dont look even slightly believable.', 7, 3, 'Data', 'https://pictures.abebooks.com/isbn/9781800567498-us.jpg'),
	('Effective DevOps: Building a Culture of Collaboration, Affinity, and Tooling at Scale', 'Jennifer Davis', 'There are many variations of passages of Lorem Ipsum available but the majority have suffered alteration in some form by injected humour or randomised words which dont look even slightly believable.', 9, 5, 'DevOps', 'https://m.media-amazon.com/images/I/51Waf77LlaL._SX379_BO1,204,203,200_.jpg'),
    	('The Road to React: Your journey to master plain yet pragmatic React.js', 'Robin Wieruch', 'There are many variations of passages of Lorem Ipsum available but the majority have suffered alteration in some form by injected humour or randomised words which dont look even slightly believable.', 7, 3, 'FE', 'https://m.media-amazon.com/images/I/41+B0usacbL._SX384_BO1,204,203,200_.jpg'),
	('Angular Projects: Build modern web apps by exploring Angular 12 with 10 different projects and cutting-edge technologies, 2nd Edition', 'Aristeidis Bampakos', 'There are many variations of passages of Lorem Ipsum available but the majority have suffered alteration in some form by injected humour or randomised words which dont look even slightly believable.', 9, 5, 'FE', 'https://m.media-amazon.com/images/I/41wehY+ColS._SX404_BO1,204,203,200_.jpg'),
	('Vue.js 3 By Example: Blueprints to learn Vue web development, full-stack development, and cross-platform development quickly', ' John Au-Yeung ', 'There are many variations of passages of Lorem Ipsum available but the majority have suffered alteration in some form by injected humour or randomised words which dont look even slightly believable.', 3, 2, 'FE', 'https://m.media-amazon.com/images/I/41Hdn2F6B8S._SX404_BO1,204,203,200_.jpg');


INSERT INTO review (user_email, date, rating, book_id, review_description) VALUES 
	('example1user@email.com', NOW(), 4, 1, 'First book is pretty good book overall'),
	('example1user@email.com', NOW(), 4, 2, 'First book is pretty good book overall'),
	('example1user@email.com', NOW(), 4, 3, 'First book is pretty good book overall'),
	('example1user@email.com', NOW(), 4, 4, 'First book is pretty good book overall'),
	('example1user@email.com', NOW(), 4, 5, 'First book is pretty good book overall'),
	('example1user@email.com', NOW(), 4, 6, 'First book is pretty good book overall'),
	('example1user@email.com', NOW(), 4, 7, 'First book is pretty good book overall'),
	('example2user@email.com', NOW(), 4.5, 1, 'Second books is pretty good book overall'),
	('example2user@email.com', NOW(), 4.5, 2, 'Second books is pretty good book overall'),
	('example2user@email.com', NOW(), 4.5, 3, 'Second books is pretty good book overall'),
	('example2user@email.com', NOW(), 4.5, 4, 'Second books is pretty good book overall'),
	('example2user@email.com', NOW(), 4.5, 5, 'Second books is pretty good book overall'),
	('example2user@email.com', NOW(), 4.5, 6, 'Second books is pretty good book overall'),
	('example2user@email.com', NOW(), 4.5, 7, 'Second books is pretty good book overall');