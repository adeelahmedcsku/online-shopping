CREATE TABLE category(
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(500),
	image_url VARCHAR(200),
	is_active BOOLEAN,
	CONSTRAINT	pk_category_id PRIMARY KEY (id)
);