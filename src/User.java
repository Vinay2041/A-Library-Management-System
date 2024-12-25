import java.util.ArrayList;

public class User {
    private String id;
    private String name;
    private ArrayList<Books> borrowedBooks;

    public User(String id,String name){
        this.id=id;
        this.name=name;
        this.borrowedBooks=new ArrayList<>();
    }
    public void borrowBook(Books book){
        borrowedBooks.add(book);
    }
    public void returnbook(Books book){
        borrowedBooks.remove(book);
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public ArrayList<Books> booksArrayList(){
        return borrowedBooks;
    }
}
