

public class Books{
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;

    /**
     *
     * @param id id is used for the identification of the boook
     * @param title book title
     * @param author book author
     */
    public Books(String id,String title,String author){
        this.id=id;
        this.title=title;
        this.author=author;
        this.isAvailable=true;
    }

    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public boolean isAvailable(){
        return isAvailable;
    }

    /**
     *
     * @param available to set the status of the book
     */
    public void setAvailable(boolean available){
        isAvailable=available;
    }
    public String tostring(){
        return "Book[ID :"+id +" ,Title :"+title +" ,Author :"+author+",Available :"+isAvailable+" ]";
    }
}
