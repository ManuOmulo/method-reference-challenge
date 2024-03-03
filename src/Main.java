import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {
  static Random random = new Random();

  public static void main(String[] args) {
    String[] firstNames = {"Anna", "Bob", "charles", "michael", "David", "Mercy", "don"};

    List<UnaryOperator<String>> functions = new ArrayList<>();
    functions.add(String::toUpperCase);

    functions.add(s -> {
      String lastName = "%c.".formatted(random.nextInt(65, 91));
      return "%s %s".formatted(s, lastName);
    });

    functions.add(s -> {
      String[] names = s.split(" ");
      StringBuilder myString = new StringBuilder(names[0]);
      myString.reverse();
      return "%s %s".formatted(s, myString);
    });

    execute(firstNames, functions);

  }

  public static void execute(String[] names, List<UnaryOperator<String>> functions) {
    List<String> newList = Arrays.asList(names);

    for (var function : functions) {
      newList.replaceAll(name -> name.transform(function));
    }

    System.out.println(newList);
  }
}
