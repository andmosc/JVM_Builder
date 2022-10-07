public class Main {
    public static void main(String[] args) {

        Person mom = new Person.PersonBuilder()
                .setName("Сергей")
                .setSurname("Иванов")
                .setAge(21)
                .setCity("Москва")
                .build();

        Person son = mom.newChildBuilder().setName("Антон").build();
        System.out.println(son);

    }
}
