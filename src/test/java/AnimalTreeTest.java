/*
import animal_analyzer.Animal;
import animal_analyzer.AnimalTree;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class AnimalTreeTest {
    private AnimalTree tree;

    @Before
    public void setUp() throws IOException {
        tree = new AnimalTree("src/main/dicts/animals.json");
    }

    @Test
    public void testGetAnimalsAtDepth() {
        List<Animal> animals = tree.getAnimalsAtDepth(2);
        assertNotNull(animals);
        assertFalse(animals.isEmpty());
    }

    @Test
    public void testFindAnimal() {
        Animal animal = tree.findAnimal(tree.getRoot(), "Papagaios");
        assertNotNull(animal);
        assertEquals("Papagaios", animal.getName());
    }

    @Test
    public void testGetParents() {
        Animal animal = tree.findAnimal(tree.getRoot(), "Papagaios");
        List<Animal> parents = tree.getParents(tree.getRoot(), animal);
        assertNotNull(parents);
        assertFalse(parents.isEmpty());
    }
}*/
