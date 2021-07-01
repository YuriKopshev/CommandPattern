package ru.netology;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Frog frog = new Frog();
        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;
        while (true) {
            //считываем ввод и конструируем комманду, если
            //пользователь не хотел выйти
            char command;
            Scanner scanner = new Scanner(System.in);
            command = scanner.next().charAt(0);

            if (command == '0') {
                break;
            }
            /*пользователь хочет отменить действие*/
            if (command == '<') {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
                /*пользователь хочет повторить действие*/
            } else if (command == '>') {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего повторять!");
                } else {
                    curCommand++;
                    commands.get(curCommand).doIt();
                }
            }
            //пользователь ввёл новое движение для лягушки
            else if (command == '+') {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Введите колличесвто шагов для прыжка:");
                int stepsCount = scanner1.nextInt();

                if (curCommand != commands.size() - 1) {
                    //удаляем все команды которые были отменены
                }
                FrogCommand cmd = FrogCommands.jumpRightCommand(frog, stepsCount);
                curCommand++;
                commands.add(cmd);
                cmd.doIt();
            } else if (command == '-') {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Введите колличесвто шагов для прыжка:");
                int stepsCount = scanner1.nextInt();
                if (curCommand != commands.size() - 1) {
                    //удаляем все команды которые были отменены
                }
                FrogCommand cmd = FrogCommands.jumpLeftCommand(frog, stepsCount);
                curCommand++;
                commands.add(cmd);
                cmd.doIt();
            }
            System.out.println(frog.position);
        }
    }
}
