package uitilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerCofig {
private Locale locale = new Locale("en");
private Faker faker = new Faker(locale);

public static FakerCofig getData() {
	return new FakerCofig();
}

public String getFirstName() {
	return faker.address().firstName();
}

public String getLastName() {
	return faker.address().lastName();
}

public String getCompanyName() {
	return faker.address().firstName();
}

public String getAddress() {
	return faker.address().streetAddress();
}

public String getFullName() {
	return faker.name().fullName();
}

public String getEmail() {
	return faker.internet().emailAddress();
}

public String getPassword() {
	return faker.internet().password();
}

public String getPhone() {
	return faker.phoneNumber().phoneNumber();
}

public String getCity() {
	return faker.address().city();
}

public String getCityName() {
	return faker.address().cityName();
}

}
