package XtraOekter.Uke6;

public class Chapter {
    private String title;
    private int numPages;
    private int timeReading;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public int getTimeReading() {
        return timeReading;
    }

    public void setTimeReading(int timeReading) {
        this.timeReading = timeReading;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "title='" + this.title + '\'' +
                ", numberOfPages=" + this.numPages +
                ", readingTime=" + this.timeReading +
                '}';
    }
}
