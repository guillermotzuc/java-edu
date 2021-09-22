package designpatterns.builder.faceted;

public class PersonAddressBuilder extends PersonBuilder {

	public PersonAddressBuilder( Person person) {
		this.person = person;
	}
	
	public PersonAddressBuilder setAddress(String address) {
		this.person.streetAddress = address;
		return this;
	}
	
	public PersonAddressBuilder setCity(String city) {
		this.person.city = city;
		return this;
	}
	
	public PersonAddressBuilder setPostCode(String postCode) {
		this.person.postCode = postCode;
		return this;
	}
}
