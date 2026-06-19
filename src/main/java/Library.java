/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DENZEL
 */
import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    private final ArrayList<Book> books;
    private final ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public Book searchBook(String title) {

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    public void lendBook(String isbn, String memberId) {

        Book foundBook = null;
        Member foundMember = null;

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                foundBook = book;
            }
        }

        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                foundMember = member;
            }
        }

        if (foundBook == null || foundMember == null) {
            System.out.println("Book or Member not found.");
            return;
        }

        if (!foundBook.isAvailable()) {
            System.out.println("Loan rejected! Book already on loan.");
            return;
        }

        Loan loan = new Loan(
                foundMember,
                foundBook,
                LocalDate.now(),
                LocalDate.now().plusDays(14));

        foundMember.addLoan(loan);
        foundBook.setAvailable(false);

        System.out.println("Book successfully borrowed.");
    }

    public void returnBook(String isbn) {

        for (Member member : members) {

            ArrayList<Loan> loans = member.getLoans();

            for (Loan loan : new ArrayList<>(loans)) {

                if (loan.getBook().getIsbn().equals(isbn)) {

                    loan.getBook().setAvailable(true);
                    member.removeLoan(loan);

                    System.out.println("Book returned successfully.");
                    return;
                }
            }
        }

        System.out.println("Book was not on loan.");
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("\n------ BOOKS ------\n");

        for (Book book : books) {
            sb.append(book).append("\n");
        }

        sb.append("\n------ MEMBERS ------\n");

        for (Member member : members) {
            sb.append(member).append("\n");
        }

        return sb.toString();
        
    
    }
}
