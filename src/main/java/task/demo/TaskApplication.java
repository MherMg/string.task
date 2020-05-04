package task.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication implements CommandLineRunner {

    private final SortingService sortingService;

    @Autowired
    public TaskApplication(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        String strFull = sortingService.sortStr("сапог сарай арбуз болт бокс биржа");
        System.out.println(strFull);
        String strMoreOneElement = sortingService.getContainingMoreThanOneElement();
        System.out.println(strMoreOneElement);
    }
}
