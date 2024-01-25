module exercisesmod {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens edu.realemj.exercises00 to javafx.fxml;

    exports  edu.realemj.exercises00;
    exports edu.townsemc.exercises02;
    exports edu.townsemc.exercises03;
}
