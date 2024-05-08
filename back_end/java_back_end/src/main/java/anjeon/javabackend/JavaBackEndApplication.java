package anjeon.javabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaBackEndApplication {

  public static void main(String[] args) {
    try {
      SpringApplication.run(JavaBackEndApplication.class, args);
      System.out.println("Anjeon On!");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
