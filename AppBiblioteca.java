package com.ejemplo.biblioteca;

import java.util.List;
import java.util.Scanner;

public class AppBiblioteca {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatronDAO patronDAO = new PatronDAO();
        BookDAO bookDAO = new BookDAO();

        int opcion;

        do {
            System.out.println("=========== MENÚ BIBLIOTECA (JDBC) ===========");
            System.out.println("1. Listar usuarios (patrons)");
            System.out.println("2. Insertar usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Listar libros");
            System.out.println("6. Insertar libro");
            System.out.println("7. Actualizar libro");
            System.out.println("8. Eliminar libro");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            String linea = sc.nextLine();
            if (linea.isEmpty()) {
                opcion = -1;
            } else {
                opcion = Integer.parseInt(linea);
            }

            switch (opcion) {
                case 1:
                    List<Patron> patrons = patronDAO.listarTodos();
                    System.out.println("---- LISTA DE USUARIOS ----");
                    for (Patron p : patrons) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Número de carné (card_num): ");
                    int cardNum = Integer.parseInt(sc.nextLine());
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Año de ingreso (member_year): ");
                    int year = Integer.parseInt(sc.nextLine());
                    System.out.print("Multa total (total_fine): ");
                    double multa = Double.parseDouble(sc.nextLine());

                    Patron nuevo = new Patron(cardNum, nombre, year, multa);
                    System.out.println("Filas insertadas: " + patronDAO.insertar(nuevo));
                    break;

                case 3:
                    System.out.print("card_num del usuario a actualizar: ");
                    int cardUpdate = Integer.parseInt(sc.nextLine());
                    Patron pExistente = patronDAO.buscarPorId(cardUpdate);
                    if (pExistente == null) {
                        System.out.println("No existe un usuario con ese card_num.");
                        break;
                    }

                    System.out.print("Nuevo nombre (" + pExistente.getName() + "): ");
                    String nNombre = sc.nextLine();
                    if (!nNombre.isEmpty()) pExistente.setName(nNombre);

                    System.out.print("Nuevo member_year (" + pExistente.getMemberYear() + "): ");
                    String nYearStr = sc.nextLine();
                    if (!nYearStr.isEmpty())
                        pExistente.setMemberYear(Integer.parseInt(nYearStr));

                    System.out.print("Nueva multa total (" + pExistente.getTotalFine() + "): ");
                    String nMultaStr = sc.nextLine();
                    if (!nMultaStr.isEmpty())
                        pExistente.setTotalFine(Double.parseDouble(nMultaStr));

                    System.out.println("Filas actualizadas: " + patronDAO.actualizar(pExistente));
                    break;

                case 4:
                    System.out.print("card_num del usuario a eliminar: ");
                    int cardDel = Integer.parseInt(sc.nextLine());
                    System.out.println("Filas eliminadas: " + patronDAO.eliminar(cardDel));
                    break;

                case 5:
                    List<Book> books = bookDAO.listarTodos();
                    System.out.println("---- LISTA DE LIBROS ----");
                    for (Book b : books) {
                        System.out.println(b);
                    }
                    break;

                case 6:
                    System.out.print("ID del libro (book_id): ");
                    int bookId = Integer.parseInt(sc.nextLine());
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Año de publicación: ");
                    int anioPub = Integer.parseInt(sc.nextLine());
                    System.out.print("Género: ");
                    String genero = sc.nextLine();

                    Book nuevoLibro = new Book(bookId, titulo, autor, anioPub, genero);
                    System.out.println("Filas insertadas: " + bookDAO.insertar(nuevoLibro));
                    break;

                case 7:
                    System.out.print("book_id del libro a actualizar: ");
                    int bookUpdate = Integer.parseInt(sc.nextLine());
                    Book bExistente = bookDAO.buscarPorId(bookUpdate);
                    if (bExistente == null) {
                        System.out.println("No existe un libro con ese ID.");
                        break;
                    }

                    System.out.print("Nuevo título (" + bExistente.getTitle() + "): ");
                    String nTitulo = sc.nextLine();
                    if (!nTitulo.isEmpty()) bExistente.setTitle(nTitulo);

                    System.out.print("Nuevo autor (" + bExistente.getAuthor() + "): ");
                    String nAutor = sc.nextLine();
                    if (!nAutor.isEmpty()) bExistente.setAuthor(nAutor);

                    System.out.print("Nuevo año (" + bExistente.getPublishedYear() + "): ");
                    String nAnioStr = sc.nextLine();
                    if (!nAnioStr.isEmpty())
                        bExistente.setPublishedYear(Integer.parseInt(nAnioStr));

                    System.out.print("Nuevo género (" + bExistente.getGenre() + "): ");
                    String nGenero = sc.nextLine();
                    if (!nGenero.isEmpty()) bExistente.setGenre(nGenero);

                    System.out.println("Filas actualizadas: " + bookDAO.actualizar(bExistente));
                    break;

                case 8:
                    System.out.print("book_id del libro a eliminar: ");
                    int bookDel = Integer.parseInt(sc.nextLine());
                    System.out.println("Filas eliminadas: " + bookDAO.eliminar(bookDel));
                    break;

                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println();

        } while (opcion != 0);

        sc.close();
    }
}
