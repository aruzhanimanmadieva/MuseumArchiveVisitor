public class Photograph implements ArchiveItem {
    private String title;
    private int age;
    private int condition;

    public Photograph(String title, int age, int condition) {
        this.title = title;
        this.age = age;
        this.condition = condition;
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

    @Override
    public void accept(ArchiveVisitor visitor) {
        visitor.visitPhotograph(this);
    }
}

