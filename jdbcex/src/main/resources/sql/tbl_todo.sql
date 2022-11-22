CREATE TABLE tbl_todo (
                          tno int auto_increment primary key ,
                          title varchar(100) NOT NULL,
                          dueDate date not null,
                          finished tinyint default 0
)

    INSERT into tbl_todo (title, dueDate, finished) VALUES ('Test...', '2022-12-31', 1);

SELECT * FROM tbl_todo;

SELECT * FROM tbl_todo WHERE tno=1;

SELECT * FROM tbl_todo WHERE tno<10;

UPDATE tbl_todo SET finished=0, title='Not Yet...' WHERE tno=3;

DELETE from tbl_todo WHERE tno>4;