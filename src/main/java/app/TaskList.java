package app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;





@Getter
@ToString
//Klassen bruger en type (T), som skal være (sub)klasse af Task
public class TaskList<T extends Task> implements Iterable<T> { //"extends Task" gør klassen generic, hvor <T> er en Task eller en subklasse af denne
    //Det gør at vi i klassen kan have forskellige typer af Tasks
    private List<T> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void addTask (T task) {
        taskList.add(task);
    }

    public List<T> filterTasksByKeyword (String keyWord) {
        return taskList.stream()
                .filter(task -> task.getDescription().contains(keyWord) || task.getTitle().contains(keyWord))
                .collect(Collectors.toList());
    }

    public List<T> sortByDuedate () {
        List<T> tasks = taskList.stream()
                .sorted(Comparator.comparing(task -> task.getDuedate())) //"Comparator.comparing" sorterer i stigende rækkefølge
                .collect(Collectors.toList());

                return tasks;
    }

    public List<T> tasksDueToday () {
        LocalDate dateToday = LocalDate.now();

        List<T> tasks = taskList.stream()
                .filter(task -> task.getDuedate().equals(dateToday)) //.equals for at kigge på objekternes indhold og ikke placering i hukommelsen som "=="
                .collect(Collectors.toList());
        return tasks;
    }

    public List<T> tasksOverdue () {
        LocalDate dateToday = LocalDate.now();

        List<T> tasks = taskList.stream()
                .filter(task -> task.getDuedate().isBefore(dateToday))
                .collect(Collectors.toList());

        return tasks;
    }

    public void print (List<T> tasks) {
        tasks.forEach(System.out::println);
        System.out.println("------------------------------------------------------");
    }




    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
