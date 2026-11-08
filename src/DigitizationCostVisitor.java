public class DigitizationCostVisitor implements ArchiveVisitor {

    @Override
    public void visitPhotograph(Photograph photograph) {
        double cost = 500 + (100- photograph.getCondition()) * 20;
        System.out.println("Photograph: " + photograph.getTitle());
        System.out.println("Digitization cost: " + cost + "KZT\n");
    }

    @Override
    public void visitHistoricalDocument(HistoricalDocument document) {
        double cost = 2000 + document.getPages() * 80;
        System.out.println("Historical document: " + document.getTitle());
        System.out.println("Digitization cost: " + cost + "KZT\n");
    }

    @Override
    public void visitAudioRecording(AudioRecording recording) {
        double cost = 1000 + recording.getDuration() * 120;
        System.out.println("Audio recording: " + recording.getTitle());
        System.out.println("Digitization cost: " + cost + "KZT\n");
    }

}

