package interfaces;

public class Link {
    public final String href;
    public final boolean templated;

    public Link(String href, boolean templated) {
        this.href = href;
        this.templated = templated;
    }
}
