import org.example.Person;
import org.example.PersonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPersonBuilder {


    @Test
    public void testSum() {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        String result = "У " + mom + " есть сын, " + son;

        Assertions.assertEquals("У Person{имя = 'Анна', фамилия = 'Вольф', возраст = 31, " +
                "город проживания = 'Сидней'} есть сын, Person{имя = 'Антошка', фамилия = 'Вольф', возраст = 0, " +
                "город проживания = 'Сидней'}", result);
    }
}
