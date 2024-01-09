module howdyfx {   
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    requires howdy;    
    
    opens edu.realemj.howdyfx to javafx.fxml;    
    exports edu.realemj.howdyfx;      
}
