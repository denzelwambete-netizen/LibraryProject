/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DENZEL
 */
public class LibraryDemo {
     public static void main(String[] args) {

        Library library = new Library();

        // Create Books
        Book book1 = new Book("B001", "Java Programming", "James Gosling");
        Book book2 = new Book("B002", "Data Structures", "Mark Allen");
        Book book3 = new Book("B003", "Database Systems", "Elmasri");

        // Add Books to Library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Create Members
        Member member1 = new Member("M001", "John");
        Member member2 = new Member("M002", "Sarah");

        // Register Members
        library.registerMember(member1);
        library.registerMember(member2);

        // Display Initial State
        System.out.println("========== INITIAL LIBRARY ==========");
        System.out.println(library);

        // Borrow Books
        library.lendBook("B001", "M001");
        library.lendBook("B002", "M002");

        // This should be rejected
        library.lendBook("B001", "M002");

        // Return Book
        library.returnBook("B001");

        // Borrow Again
        library.lendBook("B001", "M002");

        // Display Final State
        System.out.println("\n========== FINAL LIBRARY ==========");
        System.out.println(library);
    }
}
