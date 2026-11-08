public class Main {

    public static void main (String [] args) {

        ArchiveItem photograph = new Photograph("Old City Photo",80,75);
        ArchiveItem document = new HistoricalDocument("Historical Argeement",120,60,25);
        ArchiveItem recording = new AudioRecording("Traditional music",50,85,30);

        ArchiveItem[] archive = {photograph, document , recording};

        ArchiveVisitor riskVisitor = new PreservationRiskVisitor();
        System.out.println("\n===== PRESERVATION RISK REPORT =====");
        for (ArchiveItem item : archive) {
            item.accept(riskVisitor);
        }

        ArchiveVisitor costVisitor = new DigitizationCostVisitor();
        System.out.println("\n===== DIGITIZATION COST REPORT =====");
        for (ArchiveItem item : archive) {
            item.accept(costVisitor);
        }
    }
}
