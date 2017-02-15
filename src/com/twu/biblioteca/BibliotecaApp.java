package com.twu.biblioteca;

import com.twu.biblioteca.controller.BaseController;
import com.twu.biblioteca.controller.UndefinedInputException;
import com.twu.biblioteca.controller.WelcomeController;

import java.util.Scanner;
import java.util.Stack;

public class BibliotecaApp {

    public static void main(String[] args) {

        WelcomeController welcomeController = new WelcomeController();

        Stack<BaseController> controllerStack = new Stack<>();

        controllerStack.push(welcomeController);

        Scanner scanner = new Scanner(System.in);

        while (!controllerStack.isEmpty()){

            BaseController presentController = controllerStack.peek();

            presentController.index();

            String input = scanner.next();

            if(input.equals("q")){
                controllerStack.pop();
                continue;
            }else if(input.equals("quit")){

                break;
            }

            try {
                BaseController nextAction = presentController.action(input);
                controllerStack.push(nextAction);
            } catch (UndefinedInputException e) {
                System.out.println("Unsupported command,please re-enter it!");
            }

        }

        System.out.println("Bye!");
    }
}
