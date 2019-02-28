import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();

        List<Photo> photoList = null;
        //photoList = parser.getPhotoList("a_example.txt");
        photoList = parser.getPhotoList("b_lovely_landscapes.txt");

        for (Photo photo : photoList) {
            System.out.println(photo);
        }

        for (Photo photo : photoList) {

        }
    }
}
