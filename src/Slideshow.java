import com.sun.istack.internal.Nullable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Slideshow {
    private List<Slide> slides = new ArrayList<>();

    public Slideshow() {}

    void writeToFile(@Nullable String filename) throws IOException {
        if (filename == null)
            filename = "output.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        writer.write("" + slides.size());
        writer.newLine();
        for (Slide s : slides) {
            List<Photo> photos = s.getPhotos();
            writer.write("" + photos.get(0).getIndex());
            if (photos.size() == 2 && photos.get(1) != null)
                writer.write(" " + photos.get(1).getIndex());
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    public Slideshow(List<Slide> slides) {
        this.slides = slides;
    }

    public void addSlide(Slide slide) {
        slides.add(slide);
    }

    public List<Slide> getSlides() {
        return slides;
    }

    public Slide getLast() {
        return slides.get(slides.size() - 1);
    }

    public void setSlides(List<Slide> slides) {
        this.slides = slides;
    }
}
