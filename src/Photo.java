import java.util.ArrayList;
import java.util.List;

public class Photo {
    private Orientation orientation;
    private List<String> tags;

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
}
