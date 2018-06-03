CREATE TABLE category(
	categoryId IDENTITY,
	categoryName VARCHAR(50),
	imagePath VARCHAR(50),
	active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY(categoryId)
);