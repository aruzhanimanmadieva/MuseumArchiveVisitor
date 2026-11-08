public class AudioRecording implements ArchiveItem {
    private String title;
    private int age;
    private int condition;
    private int duration;

    public AudioRecording(String title, int age, int condition, int duration) {
        this.title = title;
        this.age = age;
        this.condition = condition;
        this.duration = duration;
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

    public int getDuration() {
        return duration;
    }

    @Override
    public void accept(ArchiveVisitor visitor) {
        visitor.visitAudioRecording(this);
    }
}


