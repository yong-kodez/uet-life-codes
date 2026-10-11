public class ImgConfig implements Prototype {
    private String filter;
    private int contrast;
    private Pair size;

    public ImgConfig(String filter, int contrast, Pair size) {
        this.filter = filter;
        this.contrast = contrast;
        this.size = new Pair(size);
    }

    public ImgConfig(ImgConfig o) {
        this(o.getFilter(), o.getContrast(), o.getSize());
    }

    public String getFilter() { return this.filter; }
    public int getContrast() { return this.contrast; }
    public Pair getSize() { return this.size; }

    public void setFilter(String filter) { this.filter = filter; }
    public void setSize(int x, int y) {
        this.size.setX(x);
        this.size.setY(y);
    }

    @Override
    public ImgConfig clone() {
        return new ImgConfig(this);
    }

    @Override
    public String toString() {
        return "filter=" + filter + " - contrast=" + contrast +
               " - resolution=" + size.getX() + "x" + size.getY(); 
    }
}
