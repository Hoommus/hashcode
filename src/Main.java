import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        for (String arg : args) {
            Parser parser = new Parser();

            List<Photo> photoList = null;
            //photoList = parser.getPhotoList("a_example.txt");
            photoList = parser.getPhotoList(arg);

            List<Slide> horizontals = photoList.stream().filter(photo -> photo.getOrientation() == Orientation.HORIZONTAL).map(Slide::new).collect(Collectors.toList());
            List<Slide> verticals = groupVerticals(photoList.stream().filter(photo -> photo.getOrientation() == Orientation.VERTICAL).collect(Collectors.toList()));
            List<Slide> slides = new ArrayList<>();
            slides.addAll(horizontals);
            slides.addAll(verticals);

            Slideshow slideshow = new Slideshow();
            slideshow.addSlide(slides.stream().min(Main::getInterestFactor).get());
            slides.remove(slideshow.getLast());
            while (slides.size() > 0) {
                int interest = Integer.MIN_VALUE;
                Slide mostInteresting = null;
                Slide last = slideshow.getLast();
                for (Slide candidate : slides) {
                    int tmp = getInterestFactor(last, candidate);
                    if (tmp > interest && !slideshow.getSlides().contains(candidate)) {
                        interest = tmp;
                        mostInteresting = candidate;
                    }
                }
                slideshow.addSlide(mostInteresting);
                slides.remove(mostInteresting);
            }
            slideshow.writeToFile("solution_" + arg);
        }
    }

    public static int getInterestFactor(TagsContainer first, TagsContainer second) {
        List<String> commonTags = new ArrayList<>(first.getTags());
        commonTags.retainAll(second.getTags());
        int common = commonTags.size();
        int firstNotSecond = first.tags.size() - commonTags.size();
        int secondNotFirst = second.tags.size() - commonTags.size();

        return Math.min(Math.min(common, firstNotSecond), secondNotFirst);
    }

    public static List<Slide> groupVerticals(List<Photo> verticals)  {
        List<Slide> slides = new ArrayList<>();

        for (Photo first : verticals) {
            long interestFactor = Long.MAX_VALUE;
            Photo mostDistinct = null;
            for (Photo second : verticals) {
                if (!second.equals(first) && !second.isUsed() && !first.isUsed()) {
                    long tmp = getInterestFactor(first, second);
                    if (tmp < interestFactor) {
                        interestFactor = tmp;
                        mostDistinct = second;
                    }
                }
            }
            if (mostDistinct == null)
                return slides;
            slides.add(new Slide(first, mostDistinct));
            first.setUsed(true);
            mostDistinct.setUsed(true);
        }

        return slides;
    }
}
