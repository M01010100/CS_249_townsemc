package edu.realemj.assign06;
//NOTE: CHANGE realemj to YOUR SITNETID!!!
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.*;
import java.util.*;

public class Test_GameState {
    private String SITNETID = Test_GameState.class.getCanonicalName().split("\\.")[1];

    private String dataDir = "data/";
    private String [] allFiles = {        
        "Level_1.txt",
        "Level_2.txt",
        "Level_3.txt",
        "Level_4.txt",
        "BadTome.txt",
        "BadCreature.txt",
        "BadItem.txt"
    };

    private String [] allOutputs = {                
                """
                MAP:
                ..............................
                ..............................
                ..............................
                ..S...........................
                ..............................
                ..............................
                ............R.................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                
                CREATURES:
                * Skeleton at 3,2
                * Rat at 6,12
                INVENTORY:  
                """,  

                """
                MAP:
                ..............................
                ..............................
                ..............................
                ..............................
                ..S...........................
                ..............................
                ..............................
                ...............R..............
                ..............................
                ...R..........................
                ....S.........................
                ..............................
                
                CREATURES:
                * Skeleton at 4,2
                * Rat at 7,15
                * Rat at 9,3
                * Skeleton at 10,4
                INVENTORY:
                """,  

                """
                MAP:
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                
                CREATURES:
                INVENTORY:
                * CUP with value 5
                * TOME_OF_MAGIC with value 120, enhances sorcery
                * FORK with value 7    
                """,   

                """
                MAP:
                ..............................
                ..............................
                ..............................
                .......S......................
                ..............................
                ..............................
                ..............................
                .........R....................
                ..............................
                ..............................
                ............R.................
                ..S...........................
                
                CREATURES:
                * Rat at 10,12
                * Skeleton at 3,7
                * Rat at 7,9
                * Skeleton at 11,2
                INVENTORY:
                * GROGNAK_COMIC with value 170, enhances courage
                * SPOON with value 2
                * TAO_OF_PROGRAMMING with value 25, enhances wisdom
                """,  

                """                
                MAP:
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ............R.................
                ..............................
                
                CREATURES:
                * Rat at 10,12
                INVENTORY:
                """,  

                """                
                MAP:
                ..............................
                ..............................
                ..............................
                .......S......................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ............R.................
                ..............................
                
                CREATURES:
                * Rat at 10,12
                * Skeleton at 3,7
                INVENTORY:
                * GROGNAK_COMIC with value 170, enhances courage
                """,  

                """                
                MAP:
                ..............................
                ..............................
                ..............................
                .......S......................
                ..............................
                ..............................
                ..............................
                .........R....................
                ..............................
                ..............................
                ............R.................
                ..............................
                
                CREATURES:
                * Rat at 10,12
                * Skeleton at 3,7
                * Rat at 7,9
                INVENTORY:
                * GROGNAK_COMIC with value 170, enhances courage 
                """};

    private String [] allErrors = {        
        "",
        "",
        "",
        "",
        "Error loading Tome",
        "Error loading Creature",
        "Error loading Item"
    };

    @Test()
    public void test_createLoadable() {
        // Create test item
        GameState state = new GameState();
        Loadable m = null;

        // Test correct
        try {
            m = state.createLoadable("Skeleton");
            Assert.assertTrue(m instanceof Skeleton);

            m = state.createLoadable("Rat");
            Assert.assertTrue(m instanceof Rat);

            m = state.createLoadable("Item");
            Assert.assertTrue(m instanceof Item);

            m = state.createLoadable("Tome");
            Assert.assertTrue(m instanceof Tome);
        }
        catch(GameFileException e) {
            throw new AssertionError("Should NOT throw exception!", e);
        }

        // Test bad
        boolean threwException = false;
        try {
            state.createLoadable("Barnacles");
        }
        catch(GameFileException e) {
            Assert.assertEquals(e.getMessage(), "Unknown type: Barnacles");
            threwException = true;
        }
        Assert.assertTrue(threwException, "Must throw GameFileException on bad loadable type!");
    }

    @Test()
    public void test_implements_loadable() {
        GameState state = new GameState();
        Assert.assertTrue(state instanceof Loadable);
    }

    @Test()
    public void test_constructor_and_toString() {
        GameState state = new GameState();        
        Assert.assertEquals(state.toString(), 
            """
            MAP:
            ..............................
            ..............................
            ..............................
            ..............................
            ..............................
            ..............................
            ..............................
            ..............................
            ..............................
            ..............................
            ..............................
            ..............................
            
            CREATURES:
            INVENTORY:       
            """);
    }
    
    @Test()
    public void test_load_and_toString() {
        GameState state = new GameState();

        // Try each one
        for(int i = 0; i < allFiles.length; i++) {
            boolean threwException = false;
            try (
                Scanner fileInput = new Scanner(new File(dataDir + allFiles[i]));
            ) {
                state.load(fileInput);
            }
            catch(GameFileException e) {                
                Assert.assertNotEquals(allErrors[i], "", "Should NOT throw GameFileException on input " + i
                        + ": got message: " + e.getMessage());
                // If we are here, check error message
                Assert.assertEquals(e.getMessage(), allErrors[i]);
                // Note we threw an exception
                threwException = true;
            }
            catch(FileNotFoundException e) {
                throw new AssertionError("Could not find file: " + dataDir + allFiles[i], e);
            }
            
            // If we got here, we should NOT have gotten an error
            if(!threwException) {
                Assert.assertEquals(allErrors[i], "", "Should have thrown GameFileException with message: " + allErrors[i]);
            }

            // Check toString output
            Assert.assertEquals(state.toString(), allOutputs[i]);        
        }
    }

    @Test() 
    public void test_save() {
        GameState state = new GameState();

        // Try each one
        for(int i = 0; i < allFiles.length; i++) {            
            try (
                Scanner fileInput = new Scanner(new File(dataDir + allFiles[i]));
            ) {
                state.load(fileInput);
            }
            catch(GameFileException e) {                
                Assert.assertNotEquals(allErrors[i], "", "Should NOT throw GameFileException on input " + i
                        + ": got message: " + e.getMessage());                 
            }
            catch(FileNotFoundException e) {
                throw new AssertionError("Could not find file: " + dataDir + allFiles[i], e);
            }

            // Try to save whatever we have
            String saveFilename = dataDir + SITNETID + "_" + allFiles[i];
            try {
                state.save(saveFilename);

            }
            catch(Exception e) {
                throw new AssertionError("Should NOT throw exception!", e);
            }

            // Load and check contents of file
            try (
                    Scanner input = new Scanner(new File(saveFilename));
            ){
                String data = "";
                while(input.hasNextLine()) {
                    data += input.nextLine() + "\n";
                }

                Assert.assertEquals(data, state.toString());
            }
            catch(Exception e) {
                throw new AssertionError("Should NOT throw exception!", e);
            }
        } 
        
        // Test as bad save
        boolean throwsException = false;
        try {
            state.save("");            
        }
        catch(GameFileException e) {
            throwsException = true;
        Assert.assertEquals(e.getMessage(), "Failed to save file!");
            Assert.assertNotNull(e.getCause());
        }

        Assert.assertTrue(throwsException, "Should throw GameFileException on bad file!");
    }
}
