package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        Groups groups = app.db().groups();
        File photo = new File("src/test/resources/stru.png");
        ContactData newContact = new ContactData().withFirstname("test_name").withLastname("test_surname").withPhoto(photo)
                .inGroup(groups.iterator().next());
        app.goTo().goToHomePage();
        app.getContactHelper().initContactCreation();

        app.getContactHelper().fillContactForm(newContact,true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }

}
