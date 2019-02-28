import java.util.List;

public class Slide extends TagsContainer {
    private List<Photo> photos;
    private Orientation photosOrientations;

    public Slide(Photo vertical1, Photo vertical2) {
        if (vertical1.getOrientation() != Orientation.VERTICAL || vertical2.getOrientation() != Orientation.VERTICAL)
            throw new IllegalArgumentException("arguments need to be both vertical");
        photos.add(vertical1);
        photos.add(vertical2);
        photosOrientations = Orientation.VERTICAL;
    }

    public Slide(Photo horizontal) {
        photos.add(horizontal);
        photosOrientations = Orientation.HORIZONTAl;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public Orientation getPhotosOrientations() {
        return photosOrientations;
    }

    public void setPhotosOrientations(Orientation photosOrientations) {
        this.photosOrientations = photosOrientations;
    }
}
