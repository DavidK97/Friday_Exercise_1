package app;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Task task1 = new Task("Gå med katten", "Tag lillemis en tur rundt om blokken", LocalDate.of(2025, 8, 22));
        Task task2 = new Task("Vand blomsterne", "Giv potteplanterne lidt kærlighed", LocalDate.of(2025, 8, 20));
        Task task3 = new Task("Køb kattemad", "Tjek at det er med kylling og ikke tun", LocalDate.of(2025, 8, 24));
        Task task4 = new Task("Rengør kattebakken", "Det lugter – gør noget ved det!", LocalDate.of(2025, 8, 18));
        Task task5 = new Task("Legetid med katten", "Brug laserpointeren – stor succes sidst", LocalDate.of(2025, 8, 23));

        Task task6 = new GardenTask("Ukrudt", "Hiv skvadderkål op", LocalDate.of(2025, 8, 22), "Forhaven");
        Task task7 = new GardenTask("Vand drivhuset", "Sørg for at tomaterne får nok vand", LocalDate.of(2025, 8, 20), "Drivhuset");
        Task task8 = new GardenTask("Klip hækken", "Form den som en kat igen – naboerne elsker det", LocalDate.of(2025, 8, 24), "Baghaven");

        TaskList<Task> taskListManager= new TaskList<>();
        taskListManager.addTask(task1);
        taskListManager.addTask(task2);
        taskListManager.addTask(task3);
        taskListManager.addTask(task4);
        taskListManager.addTask(task5);
        taskListManager.addTask(task6);
        taskListManager.addTask(task7);
        taskListManager.addTask(task8);


        //1.
        System.out.println("Task 1: task search-function ");
        List<Task> result1 = taskListManager.filterTasksByKeyword("kat");
        taskListManager.print(result1);

        //2.
        System.out.println("Task 2: Tasks sorted by duedate ");
        List<Task> result2 = taskListManager.sortByDuedate();
        taskListManager.print(result2);

        //3.
        System.out.println("Task 3: Tasks due today ");
        List<Task> result3 = taskListManager.tasksDueToday();
        taskListManager.print(result3);

        //4.
        System.out.println("Task 4: Overdue tasks ");
        List<Task> result4 = taskListManager.tasksOverdue();
        taskListManager.print(result4);

    }
}