import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Photo extends TagsContainer {
    private long index;
    private Orientation orientation;
    private boolean isUsed = false;

    public Photo() {
        this.tags = new ArrayList<>();
    }

    public Photo(Orientation orientation, List<String> tags) {
        this.orientation = orientation;
        this.tags = tags;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return index == photo.index &&
                orientation == photo.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, orientation);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "index=" + index +
                ", orientation=" + orientation +
                ", tags=" + tags +
                '}';
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
