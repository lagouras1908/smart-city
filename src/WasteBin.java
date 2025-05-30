public class WasteBin {
    private String category;
    private String area;
    private String info;

    public WasteBin(String category, String area, String info) {
        this.category = category;
        this.area = area;
        this.info = info;
    }

    public String getCategory() { return category; }
    public String getArea() { return area; }
    public String getInfo() { return info; }

    @Override
    public String toString() {
        return "Κατηγορία: " + category + "\n" + " Περιοχή: " + area + "\n" + " Πληροφορίες: " + info;
    }
}
