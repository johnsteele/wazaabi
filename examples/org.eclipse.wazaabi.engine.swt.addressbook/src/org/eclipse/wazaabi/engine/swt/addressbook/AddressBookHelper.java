package org.eclipse.wazaabi.engine.swt.addressbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.wazaabi.engine.swt.model.addressbook.Address;
import org.eclipse.wazaabi.engine.swt.model.addressbook.AddressBook;
import org.eclipse.wazaabi.engine.swt.model.addressbook.AddressbookFactory;
import org.eclipse.wazaabi.engine.swt.model.addressbook.Person;

public class AddressBookHelper {

	public static AddressBook createAddressBook() {
		AddressBook book = AddressbookFactory.eINSTANCE.createAddressBook();
		book.setName("My addresses");
		
		book.getPersons().add(
				createPerson("Jean", "Dupont", new Date(1974,4,11),
				createAddress("Avenue des Bergers", 89, "3369", "Bled", "Belgium")));
		book.getPersons().add(
				createPerson("Gregoire", "de Hemptinne", new Date(1984,1,11),
				createAddress("Drève des sapins", 89, "9966", "Bruli", "Belgium")));
		book.getPersons().add(
				createPerson("Olivier", "Moises", new Date(1922,2,29),
				createAddress("Rue de la moutarde", 21, "1025", "Lille", "France")));
		book.getPersons().add(
				createPerson("Sylvain", "Du Doigt", new Date(2004,11,11),
				createAddress("Rue de l'Hospice", 69, "5416", "San-Francisco", "United-States")));
		
		book.getPersons().get(0).getChildren().add(
				createPerson("Toto", "Dupont", new Date(2000,8,31),
				createAddress("Avenue des Bergers", 89, "3369", "Bled", "Belgium")));
		book.getPersons().get(1).getAddresses().add(createAddress("Avenue de Bruxelles", 54, "1022", "Mons", "Belgique"));
		return book;
	}
	
	public static Person createPerson(String firstName, String lastName, Date birthDate, Address addr) {
		ArrayList<Address> addressList = new ArrayList<Address>();
		addressList.add(addr);
		return createPerson(firstName, lastName, birthDate, addressList);
	}
	
	public static Person createPerson(String firstName, String lastName, Date birthDate, List<Address> addrs) {
		Person person = AddressbookFactory.eINSTANCE.createPerson();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setBirthDate(birthDate);
		person.getAddresses().addAll(addrs);
		return person;
	}
	
	public static Address createAddress(String street, int number, String cp, String city, String country) {
		Address addr = AddressbookFactory.eINSTANCE.createAddress();
		addr.setStreet(street);
		addr.setNumber(number);
		addr.setPostalCode(cp);
		addr.setCity(city);
		addr.setCountry(country);
		return addr;
	}
}
