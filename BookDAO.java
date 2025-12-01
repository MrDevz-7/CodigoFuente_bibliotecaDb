package com.ejemplo.biblioteca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private static final String SQL_INSERT =
            "INSERT INTO books (book_id, title, author, published_year, genre) VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_SELECT_ALL =
            "SELECT book_id, title, author, published_year, genre FROM books";

    private static final String SQL_SELECT_BY_ID =
            "SELECT book_id, title, author, published_year, genre FROM books WHERE book_id = ?";

    private static final String SQL_UPDATE =
            "UPDATE books SET title = ?, author = ?, published_year = ?, genre = ? WHERE book_id = ?";

    private static final String SQL_DELETE =
            "DELETE FROM books WHERE book_id = ?";

    public int insertar(Book book) {
        int filas = 0;
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_INSERT)) {

            ps.setInt(1, book.getBookId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getPublishedYear());
            ps.setString(5, book.getGenre());

            filas = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filas;
    }

    public List<Book> listarTodos() {
        List<Book> lista = new ArrayList<>();

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Book b = new Book();
                b.setBookId(rs.getInt("book_id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setPublishedYear(rs.getInt("published_year"));
                b.setGenre(rs.getString("genre"));
                lista.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Book buscarPorId(int bookId) {
        Book book = null;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_SELECT_BY_ID)) {

            ps.setInt(1, bookId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    book = new Book();
                    book.setBookId(rs.getInt("book_id"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setPublishedYear(rs.getInt("published_year"));
                    book.setGenre(rs.getString("genre"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public int actualizar(Book book) {
        int filas = 0;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPublishedYear());
            ps.setString(4, book.getGenre());
            ps.setInt(5, book.getBookId());

            filas = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filas;
    }

    public int eliminar(int bookId) {
        int filas = 0;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_DELETE)) {

            ps.setInt(1, bookId);
            filas = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filas;
    }
}
