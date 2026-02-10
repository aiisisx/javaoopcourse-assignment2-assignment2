public class Library {
    private Book[] books;
    private int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count =0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
            System.out.println("Book added successfully");
        } else {
            System.out.println("Library is full");
        }
    }

    public void displayBooks() {
        if (count == 0) {
            System.out.println("No books in the library");
            return;
        }

        for (int i=0; i < count; i++) {
            System.out.println(books[i]);
        }
    }

    public Book searchByTitle(String title) {
        for (int i=0; i<count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public void borrowBook(String title) {
        Book book = searchByTitle(title);
        if (book != null && book.isAvailable()) {
            book.borrowBook();
            System.out.println("Book borrowed!");
        } else {
            System.out.println("Book not available or not found.");
        }
    }

    public void returnBook(String title) {
        Book book = searchByTitle(title);
        if (book != null) {
            book.returnBook();
            System.out.println("Book returned!");
        } else {
            System.out.println("Book not found.");
        }
    }
}
