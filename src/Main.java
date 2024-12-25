import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scan = new Scanner(System.in);
        System.out.println("===  Library Management System  ===");
        System.out.println("1. Add Book \n2. Search Book \n3.Add User \n4.Book Records \n5. Borrow Book \n6.Return Book \n7.Borrow Records \n8. Exit");
        while (true) {
            System.out.print("Enter your Choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    String id = scan.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scan.nextLine();
                    System.out.print("Enter Author of the Book : ");
                    String author = scan.nextLine();
                    library.addBook(new Books(id, title, author));
                }
                case 2 -> {
                    System.out.print("Enter the keywoard to search :");
                    String key = scan.nextLine();
                    ArrayList<Books> results = library.searchBook(key);
                    if (results.isEmpty()) {
                        System.out.println("No book found.");
                    } else {
                        System.out.println("Books Found : ");
                        for (Books book : results) {
                            System.out.println(book.tostring());
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter User ID: ");
                    String id = scan.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = scan.nextLine();
                    library.adduser(new User(id, name));
                }
                case 4 -> library.BookRecords();
                case 7 -> library.viewBorrowRecords();
                case 5 -> {
                    System.out.print("Enter User Id : ");
                    String userid = scan.nextLine();
                    User borrower = library.finduser(userid);
                    if (borrower == null) {
                        System.out.println("User not found.Please Add User First.");
                    } else {
                        System.out.print("Enter Book Id to borrow : ");
                        String borrowBookId = scan.nextLine();
                        library.borrowbook(borrower, borrowBookId);
                    }
                }
                case 6 -> {
                    System.out.print("Enter User Id : ");
                    String userid = scan.nextLine();
                    User returner = library.finduser(userid);
                    if (returner == null) {
                        System.out.println("User not found.");
                    } else {
                        System.out.print("Enter Book Id to return : ");
                        String returnBookId = scan.nextLine();
                        library.returnbook(returner, returnBookId);
                    }
                }
                case 8-> {
                    System.out.println("Exiting...........");
                    return;
                }
                default -> System.out.println("Enter the correct choice :");
            }
        }
    }
}