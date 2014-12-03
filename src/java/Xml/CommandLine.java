//package java;
//
//
//import java.data.Storage;
//import java.data.XmlData;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//import java.util.regex.Pattern;
//
///**
// * Created by Хасан on 16.11.2014.
// */
//public class CommandLine {
//
//    private static Scanner scan = new Scanner(System.in);
//    private static Storage st = new Storage();
//    private static boolean finished;
//
//    public static void main(String[] args) {
//
//        finished = false;
//
//        while (finished == false) {
//
//            System.out.println("Instructions to work with program " + "\n"
//                    + "if you want to load xml file type load(\"file.xml\")" + "\n"
//                    + "if you want to add person type add" + "\n"
//                    + "if you want to remove type remove(id of person)" + "\n"
//                    + "if you want to review persons type list" + "\n"
//                    + "if you want to save xml file type save(\"saved.xml\")"
//                    + "if you want to finish working type finish"
//            );
//
//            String currentCommand = scan.nextLine();
//            String currentNameOfCommand;
//            String currentValue;
//
//            int begin = 0;
//            int end = 0;
//
//            for (int i = 0; i < currentCommand.length(); i++) {
//                if (currentCommand.substring(i, i + 1).equals("(")) {
//                    begin = i;
//                }
//                if (currentCommand.substring(i, i + 1).equals(")")) {
//                    end = i;
//                }
//            }
//            if (begin > 0) {
//                currentNameOfCommand = currentCommand.substring(0, begin);
//                currentValue = currentCommand.substring(begin + 1, end);
//            } else {
//                currentNameOfCommand = currentCommand;
//                currentValue = "value";
//            }
//
//            if (currentNameOfCommand.equals("load")) {
//                XmlData xmlData = new XmlData();
//                xmlData.load(currentValue.substring(1, currentValue.length() - 1));
//
//            } else if (currentNameOfCommand.equals("add")) {
//                st.add();
//                System.out.println("Человек удачно добавился");
//            } else if (currentNameOfCommand.equals("remove")) {
//                try {
//                    st.remove(Integer.parseInt(currentValue));
//                    System.out.println("Человек удачно удалился");
//                } catch (NumberFormatException e) {
//                    System.out.println("You entered not a number");
//                }
//            } else if (currentNameOfCommand.equals("list")) {
//                st.list();
//                System.out.println("Люди удачно просмотрены");
//            } else if (currentNameOfCommand.equals("save")) {
//                XmlData xmlData = new XmlData();
//                xmlData.save(currentValue.substring(1, currentValue.length() - 1));
//                System.out.println("Файл удачно сохранился");
//            } else if (currentNameOfCommand.equals("finish")) {
//                finished = true;
//                System.out.println("До свидания!");
//            } else {
//                System.out.println("Вы ошиблись при вводе. Попробуйте еще раз.");
//            }
//        }
//    }
//}
