package dk.springboot.springbootapp;

public record CustomerRequest(Long id, int age, String name, String email) {
}
