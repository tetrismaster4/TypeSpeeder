package se.ju23.typespeeder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements MenuService {
Scanner scanner = new Scanner(System.in);
    @Override
    public void displayMenu() {
        var options = getMenuOptions();
        for (String n:options){
            System.out.println(n);
        }


        /*int c = scanner.nextInt();
        switch (c){
            case 1:
                break;
            case 2:
                break;
            case 3:

                break;
            case 4:
                break;
            case 5:
                break;
        }*/
        temp();

    }

    private String readLine(){
        byte[] buffer = new byte[4096];
        int bytes = -1;
        try {
            bytes = System.in.read(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (bytes > 0) {
            char currentChar;
            int length = -1;
            do {
                currentChar = (char)buffer[++length];
            } while(currentChar != '\0' && currentChar != '\n' && length < bytes);
            return new String(buffer, 0, length);
        }
        return"";
    }
    private void temp(){
        System.out.println("Välj språk (svenska/engelska):");
        String user = readLine();
        if (user.equals("svenska")){
            System.out.println("Svenska valt.");
        } else if (user.equals("engelska")) {
            System.out.println("Engelska valt.");
        }else System.out.println("fel");

    }
    @Override
    public List<String> getMenuOptions() {
        List<String> menuOption = new ArrayList<>();
        menuOption.add("1. logga in");
        menuOption.add("2. registera");
        menuOption.add("3. börja spelet");
        menuOption.add("4. redigera profil");
        menuOption.add("5. visa topplista");
        return menuOption;
    }
}
