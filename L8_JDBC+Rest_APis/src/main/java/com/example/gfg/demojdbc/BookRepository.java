package com.example.gfg.demojdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private Connection connection;

    private static Logger logger = LoggerFactory.getLogger(BookRepository.class);

    public BookRepository(@Value("${db.url}") String url,
                          @Value("${db.user}") String user,
                          @Value("${db.password}") String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        createTable();
    }

    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        int noOfRowsUpdated = statement.executeUpdate("create table if not exists book(id int auto_increment primary key, name varchar(30), " +
                "author varchar(50), cost int)");

        logger.info("No of rows updated - {}", noOfRowsUpdated);

    }

    public void insertBook(Book book) throws SQLException {


        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into book(name, author, cost) VALUES(?, ?, ?)"
        );
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setInt(3, book.getCost());

        int noOfRowsUpdated = preparedStatement.executeUpdate();
        logger.info("no of rows added - {}", noOfRowsUpdated);
    }

    public List<Book> findAllBooks() throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from book");

        List<Book> books = new ArrayList<>();
        while(resultSet.next()){

            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String author = resultSet.getString(3);
            int cost = resultSet.getInt(4);

            Book book = Book.builder()
                    .name(name)
                    .id(id)
                    .author(author)
                    .cost(cost)
                    .build();

            books.add(book);
        }

        return books;
    }

    public Book findByBookId(int bookId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from book where id = " + bookId);

        while(resultSet.next()){

            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String author = resultSet.getString(3);
            int cost = resultSet.getInt(4);

            Book book = Book.builder()
                    .name(name)
                    .id(id)
                    .author(author)
                    .cost(cost)
                    .build();

            return book;
        }

        return null;
    }
}
