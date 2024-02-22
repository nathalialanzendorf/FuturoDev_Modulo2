package extras.person;

public class PersonService {
    Person person = Person.builder()
        .name("John")
        .email("John@test.com")
        .phone("123456789")
        .build();

    Person person2 = new Person();
    person2.setName("John");
}
