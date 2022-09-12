package annotations;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Tester.start(main.getClass());
    }

    @TestAnn (priority = 10)
    public static void printTen(){
        System.out.println("ten");
    }

    @AfterSuit
    public static void printGoodBye(){
        System.out.println("goodbye");
    }

    @BeforeSuit
    public static void printHello(){
        System.out.println("Hello");
    }

    @TestAnn (priority = 5)
    public static void printFive(){
        System.out.println("five");
    }

    @TestAnn (priority = 1)
    public static void printOne(){
        System.out.println("one");
    }

    //если раскомментировать выбросит исключение по заданию
//    @BeforeSuit
//    public static void printOk(){
//        System.out.println("Ok");
//    }
}
