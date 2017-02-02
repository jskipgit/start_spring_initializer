package com.example;

import com.example.data.Animal;
import com.example.data.Owner;
import com.example.data.OwnerWithManyAnimals;
import com.example.repository.AnimalRepo;
import com.example.repository.OwnerRepo;
import com.example.repository.OwnerWithManyRepe;
import org.hibernate.Hibernate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private AnimalRepo myAnimalRepo;

	@Autowired
	private OwnerRepo myOwnerRepo;

	@Autowired
	private OwnerWithManyRepe myManyOwnerRepo;
	@Test
	public void testOneToMany() {
		// create animal
		Animal monkey = new Animal();
		monkey.setName("Furry friend");
		monkey.setColor("purple");

		Animal dog = new Animal();
		dog.setName("Doggy");
		dog.setColor("purply");

		// create Owners
		OwnerWithManyAnimals anOwner = new OwnerWithManyAnimals();
		anOwner.setDisplayName("jason");
		anOwner.setUsername("jskipper");
		anOwner.setPassword("shhh");

		List<Animal> animalList = new ArrayList();
		animalList.add(monkey);
		animalList.add(dog);

		// set relations
		anOwner.setMyAnimals(animalList);

		// save child record first!
		myAnimalRepo.save(monkey);
		myAnimalRepo.save(dog);

		// now save parents
		myManyOwnerRepo.save(anOwner);

		// set reverse side of relationship
		monkey.setOwner(anOwner);
		dog.setOwner(anOwner);
		myAnimalRepo.save(monkey);
		myAnimalRepo.save(dog);

		Assert.assertNotNull(myAnimalRepo.findOne(monkey.getId()));
		Assert.assertNotNull(myManyOwnerRepo.findOne(anOwner.getId()));

		OwnerWithManyAnimals
		 jason = myManyOwnerRepo.findOne(anOwner.getId());

		for(Animal tmp: jason.getMyAnimals()){
			System.out.println("Animal!:"+tmp.getName() +" owned by:"+tmp.getOwner().getDisplayName());
		}
	}
	@Test
	public void testManyToOne() {
		// create animal
		Animal monkey = new Animal();
		monkey.setName("Furry friend");
		monkey.setColor("purple");
	//	myAnimalRepo.save(monkey);

		// create Owners
		Owner anOwner = new Owner();
		anOwner.setDisplayName("jason");
		anOwner.setUsername("jskipper");
		anOwner.setPassword("shhh");

		Owner anOwner2 = new Owner();
		anOwner2.setDisplayName("thief");
		anOwner2.setUsername("aBadGuy");
		anOwner2.setPassword("okpass");


		// set relations
		anOwner.setMyAnimal(monkey);
		anOwner2.setMyAnimal(monkey);

		// save child record first!
		myAnimalRepo.save(monkey);

		// now save parents
		myOwnerRepo.save(anOwner);
		myOwnerRepo.save(anOwner2);

		Assert.assertNotNull(myAnimalRepo.findOne(monkey.getId()));
		Assert.assertNotNull(myOwnerRepo.findOne(anOwner.getId()));
	}
	@Test
	public void testDelete() {
		// create animal
		Animal monkey = new Animal();
		monkey.setName("Furry friend");
		monkey.setColor("purple");

		// save child record first!
		myAnimalRepo.save(monkey);

		Assert.assertNotNull(myAnimalRepo.findOne(monkey.getId()));

		// now try delete
		myAnimalRepo.delete(monkey);

		Assert.assertNull(myAnimalRepo.findOne(monkey.getId()));
	}

	@Test
	public void testUpdate() {
		// create animal
		Animal monkey = new Animal();
		monkey.setName("Furry friend");
		monkey.setColor("purple");

		// save child record first!
		myAnimalRepo.save(monkey);

		Assert.assertNotNull(myAnimalRepo.findOne(monkey.getId()));

		monkey.setColor("Brown");
		// now try delete
		myAnimalRepo.save(monkey);

		Animal found = myAnimalRepo.findOne(monkey.getId());
		Assert.assertEquals("Brown", found.getColor());
	}
}
