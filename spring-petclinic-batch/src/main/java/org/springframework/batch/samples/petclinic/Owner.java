package org.springframework.batch.samples.petclinic;

public record Owner(int id, String firstname, String lastname, String address, String city, String telephone) {
}
