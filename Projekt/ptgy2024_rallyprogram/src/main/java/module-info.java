module com.progtech.ptgy2024_rallyprogram {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.progtech.ptgy2024_rallyprogram to javafx.fxml;
    exports com.progtech.ptgy2024_rallyprogram;
}