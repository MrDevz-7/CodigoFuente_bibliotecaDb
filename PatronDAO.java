package com.ejemplo.biblioteca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatronDAO {

    private static final String SQL_INSERT =
            "INSERT INTO patrons (card_num, name, member_year, total_fine) VALUES (?, ?, ?, ?)";

    private static final String SQL_SELECT_ALL =
            "SELECT card_num, name, member_year, total_fine FROM patrons";

    private static final String SQL_SELECT_BY_ID =
            "SELECT card_num, name, member_year, total_fine FROM patrons WHERE card_num = ?";

    private static final String SQL_UPDATE =
            "UPDATE patrons SET name = ?, member_year = ?, total_fine = ? WHERE card_num = ?";

    private static final String SQL_DELETE =
            "DELETE FROM patrons WHERE card_num = ?";

    public int insertar(Patron patron) {
        int filas = 0;
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_INSERT)) {

            ps.setInt(1, patron.getCardNum());
            ps.setString(2, patron.getName());
            ps.setInt(3, patron.getMemberYear());
            ps.setDouble(4, patron.getTotalFine());

            filas = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filas;
    }

    public List<Patron> listarTodos() {
        List<Patron> lista = new ArrayList<>();

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Patron p = new Patron();
                p.setCardNum(rs.getInt("card_num"));
                p.setName(rs.getString("name"));
                p.setMemberYear(rs.getInt("member_year"));
                p.setTotalFine(rs.getDouble("total_fine"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Patron buscarPorId(int cardNum) {
        Patron patron = null;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_SELECT_BY_ID)) {

            ps.setInt(1, cardNum);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    patron = new Patron();
                    patron.setCardNum(rs.getInt("card_num"));
                    patron.setName(rs.getString("name"));
                    patron.setMemberYear(rs.getInt("member_year"));
                    patron.setTotalFine(rs.getDouble("total_fine"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patron;
    }

    public int actualizar(Patron patron) {
        int filas = 0;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

            ps.setString(1, patron.getName());
            ps.setInt(2, patron.getMemberYear());
            ps.setDouble(3, patron.getTotalFine());
            ps.setInt(4, patron.getCardNum());

            filas = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filas;
    }

    public int eliminar(int cardNum) {
        int filas = 0;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_DELETE)) {

            ps.setInt(1, cardNum);
            filas = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filas;
    }
}
