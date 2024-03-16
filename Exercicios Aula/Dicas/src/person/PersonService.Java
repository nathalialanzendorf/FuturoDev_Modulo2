public class PersonService {
    Person person = Person.builder()
        .name("John")
        .email("John@test.com")
        .phone("123456789")
        .build();

    Person person2 = new Person();
    person2.setName("John");

    Conta myConta2 = Conta.builder()
    .agencia(123)
    .numero(01)
    .saldo(1000)
    .build();
}
