import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList()
                .addPrimary("Primary task 1")
                .addPrimary("Primary task 2")
                .addSecondary("Secondary task 1")
                .addSecondary("Secondary task 2")
                .addSecondary("Secondary task 2");

//        for (var task : toDoList) {          // Вариант с форич
//            System.out.println(task);
//        }

        Iterator<String> iterator = toDoList.iterator();    // Вариант без форич

        while (iterator.hasNext()) {
            String task = iterator.next();
            System.out.println(task);
        }
    }
}
