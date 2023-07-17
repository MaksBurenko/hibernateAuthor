import entity.Author;
import java.util.List;

public class Main {

    AuthorHelper ah = new AuthorHelper();
    List<Author> authorList = ah.getAuthorList;

    for(Author author : authorList) {
        System.out.println(author.getId() + " " + author.getName());
    }
}
