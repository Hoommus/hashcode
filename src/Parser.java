import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<Photo> photoList;

    public Parser() {
        this.photoList = new ArrayList<>();
    }

    public List<Photo> getPhotoList(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;
        while ((line = reader.readLine()) != null) {
            Photo photo = new Photo();
            String[] tokens = line.split(" ");
            if (tokens[0].equals("H"))
                photo.setOrientation(Orientation.HORIZONTAl);
            else
                photo.setOrientation(Orientation.VERTICAL);

        }
    }
}
