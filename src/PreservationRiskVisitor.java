public class PreservationRiskVisitor implements ArchiveVisitor {

    @Override
    public void visitPhotograph(Photograph photograph) {
        double risk = photograph.getAge() * 0.4 +(100- photograph.getCondition()) * 0.6;
        System.out.println("Photograph: " + photograph.getTitle());
        System.out.println("Preservation risk: " + risk + "%\n");
    }

    @Override
    public void visitHistoricalDocument(HistoricalDocument document) {
        double risk = document.getAge() * 0.5 +(100- document.getCondition()) * 0.5;
        System.out.println("Historical document: " + document.getTitle());
        System.out.println("Preservation risk: " + risk + "%\n");
    }
    @Override
    public void visitAudioRecording(AudioRecording recording) {
        double risk = recording.getAge() * 0.3 + (100 - recording.getCondition()) * 0.7;
        System.out.println("Audio recording: " + recording.getTitle());
        System.out.println("Preservation risk: " + risk + "%\n");
    }
}
