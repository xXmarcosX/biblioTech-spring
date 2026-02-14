ALTER TABLE tbl_books
ADD COLUMN category_id INT;

ALTER TABLE tbl_books
ADD CONSTRAINT fk_book_category
FOREIGN KEY (category_id) REFERENCES tbl_categories(id);