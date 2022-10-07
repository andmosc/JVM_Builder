import java.util.Objects;

public class Person {

    private String name;
    private String surname;
    private int age;
    private String city;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.city = builder.city;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public boolean hasAge() {
        return age != 0;
    }

    public boolean hasCity() {
        return !city.isEmpty();
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name)
                && Objects.equals(surname, person.surname) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }


    public static class PersonBuilder {

        private String name;
        private String surname;
        private int age;
        private String city;

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder setAge(int age) {
            if (age < 0)
                throw new IllegalArgumentException("возраст не может быть отрицательным");
            this.age = age;
            return this;
        }

        public PersonBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public Person build() {
            if (name == null || name.equals(""))
                throw new IllegalArgumentException("Имя не указано");
            if (surname == null || surname.equals(""))
                throw new IllegalArgumentException("Фамилия не указана");
            return new Person(this);
        }
    }

    public PersonBuilder newChildBuilder() {
        int age = 1;
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(age)
                .setCity(city);
    }
}
