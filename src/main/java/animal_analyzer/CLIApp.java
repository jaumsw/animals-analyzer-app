package animal_analyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe principal do aplicativo CLI para análise de animais.
 * O aplicativo aceita argumentos para definir a profundidade da árvore,
 * a frase a ser analisada e um modo verbose para exibir tempos de execução.
 */
public class CLIApp {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Uso: java -jar cli.jar analyze --depth <n> \"<frase>\" --verbose");
            return;
        }

        int depth = Integer.parseInt(args[2]);

        boolean verbose = false;
        if (args.length > 4 && args[4].equals("--verbose")) {
            verbose = true;
        }

        String phrase = args[3];

        long startTime = System.currentTimeMillis();
        AnimalTree tree;
        try {
            tree = new AnimalTree("src/main/dicts/animals.json");
        } catch (IOException e) {
            System.out.println("Erro ao carregar a árvore de animais");
            return;
        }
        long endTime = System.currentTimeMillis();

        if (verbose) {
            System.out.println("Tempo de carregamento dos parâmetros: " + (endTime - startTime) + "ms");
        }

        List<Animal> animals = tree.getAnimalsAtDepth(depth);

        if (animals.isEmpty()) {
            System.out.println("0");
            return;
        }

        startTime = System.currentTimeMillis();
        Map<String, Integer> counts = new HashMap<>();
        for (String word : phrase.split("\\s+")) {
            Animal found = tree.findAnimal(tree.getRoot(), word);
            if (found != null) {
                List<Animal> parents = tree.getParents(tree.getRoot(), found, depth);
                for (int i = 0; i < depth ; i++) {
                    if (parents.size() > i) {
                        counts.put(parents.get(i).getName(), counts.getOrDefault(parents.get(i).getName(), 0) + 1);
                    }
                }
            }
        }
        endTime = System.currentTimeMillis();

        if (verbose) {
            System.out.println("Tempo de verificação da frase: " + (endTime - startTime) + "ms");
        }

        if (counts.isEmpty()) {
            System.out.println("0");
        } else {
            for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }
}