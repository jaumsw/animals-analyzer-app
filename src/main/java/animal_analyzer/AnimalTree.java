package animal_analyzer;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Classe que representa a árvore de animais.
 * A árvore é inicializada a partir de um arquivo JSON.
 */
public class AnimalTree {
    private Animal root;

    /**
     * Construtor que inicializa a árvore a partir de um arquivo JSON.
     *
     * @param jsonFile o caminho do arquivo JSON
     * @throws IOException se ocorrer um erro ao ler o arquivo
     */
    public AnimalTree(String jsonFile) throws IOException {
        Gson gson = new Gson();
        root = gson.fromJson(new FileReader(jsonFile), Animal.class);
    }

    /**
     * Obtém a raiz da árvore de animais.
     *
     * @return o animal raiz
     */
    public Animal getRoot() {
        return root;
    }

    /**
     * Obtém os pais de um animal específico até uma profundidade máxima.
     *
     * @param root o animal raiz
     * @param child o animal filho
     * @param maxDepth a profundidade máxima
     * @return a lista de pais do animal
     */
    public List<Animal> getParents(Animal root, Animal child, int maxDepth) {
        List<Animal> parents = new ArrayList<>();
        getParents(root, child, parents, 0, maxDepth);
        return parents;
    }

    /**
     * Método recursivo auxiliar para obter os pais de um animal até uma profundidade máxima.
     *
     * @param root o animal raiz
     * @param child o animal filho
     * @param parents a lista de pais a ser preenchida
     * @param currentDepth a profundidade atual
     * @param maxDepth a profundidade máxima
     * @return true se o filho for encontrado, false caso contrário
     */
    private boolean getParents(Animal root, Animal child, List<Animal> parents, int currentDepth, int maxDepth) {
        if (root.getChildren() != null) {
            for (Animal kid : root.getChildren()) {
                if (kid.equals(child)) {
                    if (currentDepth == maxDepth - 1) {
                        parents.add(root);
                    }
                    return true;
                }
                if (getParents(kid, child, parents, currentDepth + 1, maxDepth)) {
                    if (currentDepth == maxDepth - 1) {
                        parents.add(root);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Obtém os animais em uma profundidade específica.
     *
     * @param depth a profundidade desejada
     * @return a lista de animais na profundidade especificada
     */
    public List<Animal> getAnimalsAtDepth(int depth) {
        List<Animal> animals = new ArrayList<>();
        getAnimalsAtDepth(root, depth, 0, animals);
        return animals;
    }

    /**
     * Método recursivo auxiliar para obter os animais em uma profundidade específica.
     *
     * @param animal o animal atual
     * @param depth a profundidade desejada
     * @param currentDepth a profundidade atual
     * @param animals a lista de animais a ser preenchida
     */
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

    /**
     * Encontra um animal pelo nome.
     *
     * @param root o animal raiz
     * @param word o nome do animal a ser encontrado
     * @return o animal encontrado ou null se não for encontrado
     */
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

    /**
     * Remove acentos de uma string.
     *
     * @param text o texto a ser normalizado
     * @return o texto sem acentos
     */
    private String removeAccents(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }
}