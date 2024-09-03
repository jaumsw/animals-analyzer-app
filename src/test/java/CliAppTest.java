/*
import animal_analyzer.CLIApp;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CliAppTest {

    @Test
    public void testMainWithLions() {
        String[] args = {"analyze", "--depth", "2", "Leões", "--verbose"};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CLIApp.main(args);

        String output = outContent.toString();
        assertTrue(output.contains("Felinos = 1"));
    }

    */
/*@Test
    public void testMainWithValidInput() {
        String[] args = {"analyze", "--depth", "2", "Eu tenho preferência por animais carnívoros", "--verbose"};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CLIApp.main(args);

        String output = outContent.toString();
        assertTrue(output.contains("0"));
    }*//*


    @Test
    public void testMainWithLongText() {
        String longText = "a".repeat(5001);
        String[] args = {"analyze", "--depth", "5", longText, "--verbose"};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CLIApp.main(args);

        String output = outContent.toString();
        assertTrue(output.contains("0"));
    }

    @Test
    public void testExample1() {
        String[] args = {"analyze", "--depth", "2", "Eu amo papagaios", "--verbose"};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CLIApp.main(args);

        String output = outContent.toString();
        assertTrue(output.contains("Pássaros = 1"));
        assertTrue(output.contains("Tempo de carregamento dos parâmetros"));
        assertTrue(output.contains("Tempo de verificação da frase"));
    }

    */
/*@Test
    public void testExample2() {
        String[] args = {"analyze", "--depth", "3", "Eu vi gorilas e papagaios"};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CLIApp.main(args);

        String output = outContent.toString();
        assertTrue(output.contains("Pássaros = 1"));
        assertTrue(output.contains("Primatas = 1"));
    }*//*


    @Test
    public void testExample3() {
        String[] args = {"analyze", "--depth", "5", "Eu tenho preferência por animais carnívoros"};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CLIApp.main(args);

        String output = outContent.toString();
        assertTrue(output.contains("0"));
    }
}*/
