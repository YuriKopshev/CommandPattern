package ru.netology;

public class FrogCommands implements FrogCommand {
    public static FrogCommands jumpRightCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        if (frog.jump(steps)) {
            final int i = frog.position + steps;
            frog.position = i;
        }
        return new FrogCommands();
    }

    public static FrogCommands jumpLeftCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        if (frog.jump(steps)) {
            final int i = frog.position - steps;
            frog.position = i;
        }
        return new FrogCommands();
    }


    @Override
    public boolean doIt() {
        return true;
    }

    @Override
    public boolean undo() {
        return false;
    }
}

