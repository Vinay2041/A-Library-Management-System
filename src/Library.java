import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Books> books;
    private HashMap<User,ArrayList<Books>> borrowRecords;
    private ArrayList<User> users=new ArrayList<>();
    public Library(){
        this.books=new ArrayList<>();
        this.borrowRecords=new HashMap<>();
    }

    public void addBook(Books book){
        books.add(book);
        System.out.println("Book added: "+book.getId());
    }
    public void borrowbook(User user,String bookId){
        for(Books book: books){
            if(book.getId().equals(bookId) && book.isAvailable()){
                book.setAvailable(false);
                user.borrowBook(book);
                borrowRecords.computeIfAbsent(user,k->new ArrayList<>()).add(book);
                System.out.println("Book borrowed: "+ book.getId());
                return;
            }
        }
        System.out.println("Book is Not Available");
    }
    public void returnbook(User user,String bookId){
        for (Books book:user.booksArrayList()){
            if (book.getId().equals(bookId)){
                book.setAvailable(true);
                user.returnbook(book);
                borrowRecords.get(user).remove(book);
                System.out.println("Book returned"+ book.getId());
                return ;
            }
        }
        System.out.println("No book is found in the records for the user");
    }
    public ArrayList<Books> searchBook(String keyword){
        ArrayList<Books> result=new ArrayList<>();
        for(Books book:books){
            if (book.getId().contains(keyword)||book.getTitle().toLowerCase().contains(keyword)||book.getAuthor().toLowerCase().contains(keyword)){
                result.add(book);
            }
        }
        return result;
    }
    public void viewBorrowRecords() {
        for (User user : borrowRecords.keySet()) {
            System.out.print(user.getName() + " has borrowed :");
            for (Books book:borrowRecords.get(user)){
                System.out.print(book.getId()+" ");
            }
            System.out.println();

        }
    }
    public void BookRecords(){
        System.out.println("Book Records in Library");
        for (Books book : books) {
            System.out.println(book.tostring());
        }
    }
    public void adduser(User user){
        users.add(user);
        System.out.println("User Added "+user.getId());
    }
    public User finduser(String userId){
        for (User user:users){
            if(user.getId().equals(userId)){
                return user;
            }
        }
        return null;
    }
}

