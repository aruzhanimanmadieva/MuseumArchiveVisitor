public interface ArchiveVisitor {

    void visitPhotograph(Photograph photograph);

    void visitHistoricalDocument(HistoricalDocument document);

    void visitAudioRecording(AudioRecording recording);
}
