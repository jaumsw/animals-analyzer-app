package animal_analyzer;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AnimalTree {
    private Animal root;

    // Construtor que inicializa a árvore a partir de um arquivo JSON
    public AnimalTree(String jsonFile) throws IOException {
        Gson gson = new Gson();
        root = gson.fromJson(new FileReader(jsonFile), Animal.class);
    }

    public Animal getRoot() {
        return root;
    }

    // Método para obter os pais de um animal específico
    public List<Animal> getParents(Animal root, Animal child) {
        List<Animal> parents = new ArrayList<>();
        getParents(root, child, parents);
        return parents;
    }

    private void getParents(Animal root, Animal child, List<Animal> parents) {
        if (root.getChildren() != null) {
            for (Animal kid : root.getChildren()) {
                if (kid.equals(child)) {
                    parents.add(root);
                    return;
                }
                getParents(kid, child, parents);
            }
        }
    }

    // Método para obter animais em uma profundidade específica
    public List<Animal> getAnimalsAtDepth(int depth) {
        List<Animal> animals = new ArrayList<>();
        getAnimalsAtDepth(root, depth, 0, animals);
        return animals;
    }

    private void getAnimalsAtDepth(Animal animal, int depth, int currentDepth, List<Animal> animals) {
        if (currentDepth == depth) {
            animals.add(animal);
        } else {
            if (animal.getChildren() != null) {
                for (Animal child : animal.getChildren()) {
                    getAnimalsAtDepth(child, depth, currentDepth + 1, animals);
                }
            }
        }
    }

    // Método para encontrar um animal pelo nome
    private String removeAccents(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }

    public Animal findAnimal(Animal root, String word) {
        String normalizedRootName = removeAccents(root.getName()).replaceAll("[^a-zA-Z]", "").toLowerCase();
        String normalizedWord = removeAccents(word).replaceAll("[^a-zA-Z]", "").toLowerCase();
        if (normalizedRootName.equals(normalizedWord)) {
            return root;
        }
        if (root.getChildren() != null) {
            for (Animal child : root.getChildren()) {
                Animal found = findAnimal(child, word);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}