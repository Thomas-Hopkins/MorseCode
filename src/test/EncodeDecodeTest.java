package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import MorseTree.MorseCodeTree;

public class EncodeDecodeTest {
    
    @Test
    public void encodeDecodeTest() throws IOException {
        MorseCodeTree morseCodeTree = MorseCodeTree.buildFromFile("input.txt");
        
        // hello
        // .... . .-.. .-.. ---
        assertEquals("", ".... . .-.. .-.. ---", morseCodeTree.encodeMessage("hello"));
        assertEquals("", "hello", morseCodeTree.decodeMessage(".... . .-.. .-.. ---"));
        // antidisestablishmentarianism 
        // .- -. - .. -.. .. ... . ... - .- -... .-.. .. ... .... -- . -. - .- .-. .. .- -. .. ... --
        assertEquals("", ".- -. - .. -.. .. ... . ... - .- -... .-.. .. ... .... -- . -. - .- .-. .. .- -. .. ... --", morseCodeTree.encodeMessage("antidisestablishmentarianism"));
        assertEquals("", "antidisestablishmentarianism", morseCodeTree.decodeMessage(".- -. - .. -.. .. ... . ... - .- -... .-.. .. ... .... -- . -. - .- .-. .. .- -. .. ... --"));
        // hippopotomonstrosesquippedaliophobia
        // .... .. .--. .--. --- .--. --- - --- -- --- -. ... - .-. --- ... . ... --.- ..- .. .--. .--. . -.. .- .-.. .. --- .--. .... --- -... .. .-
        assertEquals("", ".... .. .--. .--. --- .--. --- - --- -- --- -. ... - .-. --- ... . ... --.- ..- .. .--. .--. . -.. .- .-.. .. --- .--. .... --- -... .. .-", morseCodeTree.encodeMessage("hippopotomonstrosesquippedaliophobia"));
        assertEquals("", "hippopotomonstrosesquippedaliophobia", morseCodeTree.decodeMessage(".... .. .--. .--. --- .--. --- - --- -- --- -. ... - .-. --- ... . ... --.- ..- .. .--. .--. . -.. .- .-.. .. --- .--. .... --- -... .. .-"));
        // fancy
        // ..-. .- -. -.-. -.--
        assertEquals("", "..-. .- -. -.-. -.--", morseCodeTree.encodeMessage("fancy"));
        assertEquals("", "fancy", morseCodeTree.decodeMessage("..-. .- -. -.-. -.--"));
        // sailor
        // ... .- .. .-.. --- .-.
        assertEquals("", "... .- .. .-.. --- .-.", morseCodeTree.encodeMessage("sailor"));
        assertEquals("", "sailor", morseCodeTree.decodeMessage("... .- .. .-.. --- .-."));
        // extraordinary
        // . -..- - .-. .- --- .-. -.. .. -. .- .-. -.--
        assertEquals("", ". -..- - .-. .- --- .-. -.. .. -. .- .-. -.--", morseCodeTree.encodeMessage("extraordinary"));
        assertEquals("", "extraordinary", morseCodeTree.decodeMessage(". -..- - .-. .- --- .-. -.. .. -. .- .-. -.--"));
        // binary
        // -... .. -. .- .-. -.--
        assertEquals("", "-... .. -. .- .-. -.--", morseCodeTree.encodeMessage("binary"));
        assertEquals("", "binary", morseCodeTree.decodeMessage("-... .. -. .- .-. -.--"));
        // cpu
        // -.-. .--. ..-
        assertEquals("", "-.-. .--. ..-", morseCodeTree.encodeMessage("cpu"));
        assertEquals("", "cpu", morseCodeTree.decodeMessage("-.-. .--. ..-"));
        // ram
        // .-. .- --
        assertEquals("", ".-. .- --", morseCodeTree.encodeMessage("ram"));
        assertEquals("", "ram", morseCodeTree.decodeMessage(".-. .- --"));
        // motherboard
        // -- --- - .... . .-. -... --- .- .-. -..
        assertEquals("", "-- --- - .... . .-. -... --- .- .-. -..", morseCodeTree.encodeMessage("motherboard"));
        assertEquals("", "motherboard", morseCodeTree.decodeMessage("-- --- - .... . .-. -... --- .- .-. -.."));
        // nvidia
        // -. ...- .. -.. .. .-
        assertEquals("", "-. ...- .. -.. .. .-", morseCodeTree.encodeMessage("nvidia"));
        assertEquals("", "nvidia", morseCodeTree.decodeMessage("-. ...- .. -.. .. .-"));
        // intel
        // .. -. - . .-..
        assertEquals("", ".. -. - . .-..", morseCodeTree.encodeMessage("intel"));
        assertEquals("", "intel", morseCodeTree.decodeMessage(".. -. - . .-.."));
    }
}
