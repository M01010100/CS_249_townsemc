package edu.townsemc.exercises13;

public class ChapterChooser {

    public enum Chapter {
        ULTRAMARINES,
        SALAMANDERS,
        SPACE_WOLVES,
        BLOOD_ANGELS,
        ANGELS_ENCARMINE;
    }
        public static void main(String [] args) {
            Chapter choice = Chapter.ANGELS_ENCARMINE;
            int volume = 10;

            String slogan = switch(choice) {
                case ULTRAMARINES -> "Courage and Honour!";
                case SALAMANDERS -> "Into the fires of battle, unto the Anvil of War!";
                case BLOOD_ANGELS, ANGELS_ENCARMINE -> "For the Emperor and Sanguinius! Death! DEATH!";
                case SPACE_WOLVES -> {
                    volume++;
                    yield "For Russ and the Allfather!";
                }
                default -> "FOR THE EMPEROR!";
            };

            System.out.println(slogan);
            System.out.println("(Volume: " + volume + ")");
        }
    }

