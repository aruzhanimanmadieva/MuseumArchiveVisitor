public class HistoricalDocument implements ArchiveItem {
    private String title;
    private int age;
    private int condition;
    private int pages;

    public HistoricalDocument(String title, int age, int condition, int pages) {
        this.title = title;
        this.age = age;
        this.condition = condition;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public int getAge() {
        return age;
    }

    public int getCondition() {
        return condition;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public void accept(ArchiveVisitor visitor) {
        visitor.visitHistoricalDocument(this);
    }
}

