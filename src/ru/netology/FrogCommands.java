package ru.netology;

public class FrogCommands {
    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
//        if (frog.jump(steps)) {
//            frog.position = frog.getPosition() + steps;
//        }
        return new FrogCommand() {
            @Override
            public boolean doIt() {
                if (frog.jump(steps)) {
                    frog.position = frog.getPosition() + steps;
                }
                return true;
            }

            @Override
            public boolean undo() {
                if (frog.jump(steps)) {
                    frog.position = frog.getPosition() - steps;
                }
                return false;
            }
        };
    }

    public static FrogCommand jumpLeftCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        return new FrogCommand() {
            @Override
            public boolean doIt() {
                if (frog.getPosition() - steps > Frog.MIN_POSITION) {
                    frog.position = frog.getPosition() - steps;
                }
                return true;
            }

            @Override
            public boolean undo() {
                if (frog.jump(steps)) {
                    frog.position = frog.getPosition() + steps;
                }
                return false;
            }
        };
    }

}

