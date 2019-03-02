import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private List<Photo> photoList;

    public Parser() {
        this.photoList = new ArrayList<>();
    }

    public List<Photo> getPhotoList(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        long entries = Long.parseLong(reader.readLine());

        long i = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            Photo photo = new Photo();
            List<String> tokens = Arrays.asList(line.split(" "));
            if (tokens.get(0).equals("H"))
                photo.setOrientation(Orientation.HORIZONTAL);
            else
                photo.setOrientation(Orientation.VERTICAL);
            photo.setTags(tokens.subList(2, tokens.size()));
            photo.setIndex(i++);
            photoList.add(photo);
        }
        return photoList;
    }
}
