package lesson1_2;

public class Main {
    public static void main(String[] args) {

        Participant[] participants = {new Human(), new Cat(), new Robot()};
        Wall wall = new Wall();
        Treadmill treadmill = new Treadmill();
        Barrier[] barriers = {wall, treadmill};

        for (int i = 0; i < participants.length; i++) {
            participants[i].run(treadmill);
            if (participants[i].isInGame(treadmill)) {
                participants[i].jump(wall);
            }
        }
    }
}
