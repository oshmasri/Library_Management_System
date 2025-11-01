import java.util.Scanner;

class LibraryBook {
    // Data Members
    private int bookID;
    private String title;
    private String author;
    private boolean isIssued;
    private static int totalIssued = 0;

    // Constructor
    public LibraryBook(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    // Issue a book
    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            totalIssued++;
            System.out.println("Book \"" + title + "\" issued successfully.");
        } else {
            System.out.println("Book \"" + title + "\" is already issued.");
        }
    }

    // Return a book
    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            totalIssued--;
            System.out.println("Book \"" + title + "\" returned successfully.");
        } else {
            System.out.println("Book \"" + title + "\" was not issued.");
        }
    }

    // Display book details
    public void displayBookInfo() {
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (isIssued ? "Issued" : "Available"));
        System.out.println("-----------------------------");
    }

    // Display total issued books
    public static void displayTotalIssued() {
        System.out.println("Total books currently issued: " + totalIssued);
    }

    // Getter for bookID
    public int getBookID() {
        return bookID;
    }

    // Getter for isIssued (fix)
    public boolean getIsIssued() {
        return isIssued;
    }
}

public class LibraryManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create at least two books
        LibraryBook book1 = new LibraryBook(101, "Java Programming", "James Gosling");
        LibraryBook book2 = new LibraryBook(102, "Python Basics", "Guido van Rossum");
        LibraryBook book3 = new LibraryBook(103, "C++ Fundamentals", "Bjarne Stroustrup");

        // Store books in an array
        LibraryBook[] books = {book1, book2, book3};

        int choice;
        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Issue a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. Display Book Details");
            System.out.println("4. View Total Issued Books");
            System.out.println("5. Search Book by ID");
            System.out.println("6. List All Available Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID to issue: ");
                    int issueID = sc.nextInt();
                    LibraryBook issueBook = findBookByID(books, issueID);
                    if (issueBook != null) issueBook.issueBook();
                    else System.out.println("Book not found.");
                    break;

                case 2:
                    System.out.print("Enter Book ID to return: ");
                    int returnID = sc.nextInt();
                    LibraryBook returnBook = findBookByID(books, returnID);
                    if (returnBook != null) returnBook.returnBook();
                    else System.out.println("Book not found.");
                    break;

                case 3:
                    System.out.print("Enter Book ID to display details: ");
                    int detailID = sc.nextInt();
                    LibraryBook detailBook = findBookByID(books, detailID);
                    if (detailBook != null) detailBook.displayBookInfo();
                    else System.out.println("Book not found.");
                    break;

                case 4:
                    LibraryBook.displayTotalIssued();
                    break;

                case 5:
                    System.out.print("Enter Book ID to search: ");
                    int searchID = sc.nextInt();
                    LibraryBook searchBook = findBookByID(books, searchID);
                    if (searchBook != null) searchBook.displayBookInfo();
                    else System.out.println("Book not found.");
                    break;

                case 6:
                    System.out.println("\nAvailable Books:");
                    for (LibraryBook b : books) {
                        if (!b.getIsIssued()) { 
                            b.displayBookInfo();
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        sc.close();
    }

    private static LibraryBook findBookByID(LibraryBook[] books, int bookID) {
        for (LibraryBook b : books) {
            if (b.getBookID() == bookID) {
                return b;
            }
        }
        return null;
    }
}

