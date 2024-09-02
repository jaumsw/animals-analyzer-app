package animal_analyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um animal na árvore de animais.
 * Cada animal possui um nome e uma lista de filhos.
 */
public class Animal {
    private String name;
    private List<Animal> children;

    /**
     * Construtor que inicializa um animal com um nome.
     *
     * @param name o nome do animal
     */
    public Animal(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    /**
     * Obtém o nome do animal.
     *
     * @return o nome do animal
     */
    public String getName() {
        return name;
    }

    /**
     * Obtém a lista de filhos do animal.
     *
     * @return a lista de filhos
     */
    public List<Animal> getChildren() {
        return children;
    }

    /**
     * Adiciona um filho à lista de filhos do animal.
     *
     * @param child o animal filho a ser adicionado
     */
    public void addChild(Animal child) {
        children.add(child);
    }
}