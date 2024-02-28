import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {
  static Random random = new Random();

  public static void main(String[] args) {
    List<String> firstNames = new ArrayList<>(List.of("Anna", "Bob", "charles", "michael", "David", "Mercy", "don"));

    List<UnaryOperator<String>> functions = new ArrayList<>();
    functions.add(String::toUpperCase);
    functions.add(s -> {
      String lastName = "%s.".formatted(random.nextInt(65, 91));
      return "%s %s".formatted(s, lastName);
    });
    functions.add(s -> {
      StringBuilder myString = new StringBuilder(s);
      myString.reverse();
      return "%s".formatted(myString);
    });

    execute(firstNames, functions);

  }

  public static void execute(List<String> names, List<UnaryOperator<String>> functions) {
    for (var function : functions) {
      names.forEach(function::apply);
    }

    System.out.print(names);
  }
}
