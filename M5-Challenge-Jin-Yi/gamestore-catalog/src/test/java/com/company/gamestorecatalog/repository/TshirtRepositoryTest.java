package com.company.gamestorecatalog.repository;

import com.company.gamestorecatalog.model.Tshirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TshirtRepositoryTest {
    @Autowired
    TshirtRepository tShirtRepository;

    @Before
    public void setUp() throws Exception {
        tShirtRepository.deleteAll();
    }

    @Test
    public void shouldAddFindDeleteTshirt() {

        //Arrange
        Tshirt newTshirt = new Tshirt();
        newTshirt.setQuantity(1);
        newTshirt.setPrice(10.05);
        newTshirt.setDescription("Everybody Knows Your Name");
        newTshirt.setColor("SkyBlue");
        newTshirt.setSize("M");

        //Act
        newTshirt = tShirtRepository.save(newTshirt);
        Tshirt savedTshirt = tShirtRepository.save(newTshirt);

        //Assert
        assertEquals(newTshirt, savedTshirt);

        //Arrange
        newTshirt.setQuantity(5);
        newTshirt.setDescription("Aint nobody got time for that!");

        //Act
        tShirtRepository.save(newTshirt);
        savedTshirt = tShirtRepository.save(newTshirt);

        //Assert
        assertEquals(newTshirt, savedTshirt);

        //Act
        tShirtRepository.deleteById(newTshirt.getId());
        Optional<Tshirt> foundTshirt = tShirtRepository.findById(newTshirt.getId());

        //Assert
        assertFalse(foundTshirt.isPresent());
    }

    @Test
    public void shouldFindAllTshirt(){
        //Arrange
        Tshirt newTshirt1 = new Tshirt();
        newTshirt1.setQuantity(1);
        newTshirt1.setPrice( 10.05);
        newTshirt1.setDescription("Everybody Knows Your Name");
        newTshirt1.setColor("SkyBlue");
        newTshirt1.setSize("M");

        Tshirt newTshirt2 = new Tshirt();
        newTshirt2.setQuantity(11);
        newTshirt2.setPrice(15.00);
        newTshirt2.setDescription("I am not always right...");
        newTshirt2.setColor("Pink");
        newTshirt2.setSize("S");

        //Act
        newTshirt1 = tShirtRepository.save(newTshirt1);
        newTshirt2 = tShirtRepository.save(newTshirt2);
        List<Tshirt> allTshirt = new ArrayList();
        allTshirt.add(newTshirt1);
        allTshirt.add(newTshirt2);

        //Act
        List<Tshirt> foundAllTshirt = tShirtRepository.findAll();

        //Assert
        assertEquals(allTshirt.size(),foundAllTshirt.size());
    }

    @Test
    public void shouldFindTshirtByColor(){
        //Arrange
        Tshirt newTshirt1 = new Tshirt();
        newTshirt1.setQuantity(1);
        newTshirt1.setPrice( 10.05);
        newTshirt1.setDescription("Everybody Knows Your Name");
        newTshirt1.setColor("SkyBlue");
        newTshirt1.setSize("M");

        Tshirt newTshirt2 = new Tshirt();
        newTshirt2.setQuantity(11);
        newTshirt2.setPrice(15.00);
        newTshirt2.setDescription("I am not always right...");
        newTshirt2.setColor("Pink");
        newTshirt2.setSize("S");

        Tshirt newTshirt3 = new Tshirt();
        newTshirt3.setQuantity(9);
        newTshirt3.setPrice(19.00);
        newTshirt3.setDescription("Trust me I am a Pro...crastinator");
        newTshirt3.setColor("Pink");
        newTshirt3.setSize("L");

        //Act
        newTshirt1 = tShirtRepository.save(newTshirt1);
        newTshirt2 = tShirtRepository.save(newTshirt2);
        newTshirt3 = tShirtRepository.save(newTshirt3);

        //Act
        List<Tshirt> foundNoTshirt = tShirtRepository.findTShirtByColor("InvalidValue");

        List<Tshirt> foundOneTshirt = tShirtRepository.findTShirtByColor("SkyBlue");

        List<Tshirt> foundTwoTshirt = tShirtRepository.findTShirtByColor("Pink");

        //Assert
        assertEquals(foundNoTshirt.size(),0);
        assertEquals(foundOneTshirt.size(),1);
        assertEquals(foundTwoTshirt.size(),2);

    }
    @Test
    public void shouldFindTshirtBySize(){
        //Arrange
        Tshirt newTshirt1 = new Tshirt();
        newTshirt1.setQuantity(1);
        newTshirt1.setPrice(10.05);
        newTshirt1.setDescription("Everybody Knows Your Name");
        newTshirt1.setColor("SkyBlue");
        newTshirt1.setSize("L");

        Tshirt newTshirt2 = new Tshirt();
        newTshirt2.setQuantity(11);
        newTshirt2.setPrice(15.00);
        newTshirt2.setDescription("I am not always right...");
        newTshirt2.setColor("Pink");
        newTshirt2.setSize("S");

        Tshirt newTshirt3 = new Tshirt();
        newTshirt3.setQuantity(9);
        newTshirt3.setPrice(19.00);
        newTshirt3.setDescription("Trust me I am a Pro...crastinator");
        newTshirt3.setColor("Pink");
        newTshirt3.setSize("L");

        //Act
        newTshirt1 = tShirtRepository.save(newTshirt1);
        newTshirt2 = tShirtRepository.save(newTshirt2);
        newTshirt3 = tShirtRepository.save(newTshirt3);

        //Act
        List<Tshirt> foundNoTshirt = tShirtRepository.findTShirtBySize("InvalidValue");

        List<Tshirt> foundOneTshirt = tShirtRepository.findTShirtBySize("S");

        List<Tshirt> foundTwoTshirt = tShirtRepository.findTShirtBySize("L");

        //Assert
        assertEquals(foundNoTshirt.size(),0);
        assertEquals(foundOneTshirt.size(),1);
        assertEquals(foundTwoTshirt.size(),2);
    }

}