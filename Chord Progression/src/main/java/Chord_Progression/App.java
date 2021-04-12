package Chord_Progression;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.sound.midi.*;

public final class App {

    static List<String> keys = Arrays.asList("C#", "F#", "B", "E", "A", "D", "G", "C", "F", "Bb", "Eb", "Ab", "Db",
            "Gb", "Cb", "A#m", "D#m", "G#m", "C#m", "F#m", "Bm", "Em", "Am", "Dm", "Gm", "Cm", "Fm", "Bbm", "Ebm",
            "Abm");
    static MidiChannel[] channels;
    static int INSTRUMENT = 0;
    static int VOLUME = 80;

    public static void main(String[] args) {
        JFrame f = new JFrame("Chord Progression");
        JLabel showChords = new JLabel("Enter a key & number of chords");
        JButton button = new JButton("Get Progression");
        JLabel keyLabel = new JLabel("Enter a key:");
        JLabel numberLabel = new JLabel("Number of chords:");
        JTextField keyText = new JTextField(15);
        JTextField numberText = new JTextField(15);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints right = new GridBagConstraints();
        right.anchor = GridBagConstraints.WEST;
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;

        right.weightx = (int) 2;
        right.fill = GridBagConstraints.REMAINDER;
        right.gridwidth = GridBagConstraints.REMAINDER;

        JPanel panel = new JPanel();
        panel.add(keyLabel, left);
        panel.add(keyText, right);
        panel.add(numberLabel, left);
        panel.add(numberText, right);
        panel.add(button);
        panel.add(showChords);
        f.add(panel);
        f.setSize(600, 300);
        f.setVisible(true);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String key = keyText.getText();
                int chordCount = Integer.parseInt(numberText.getText());
                showChords.setText(chords(chordCount, key).toString());
                Synthesizer synth;
                try {
                    synth = MidiSystem.getSynthesizer();
                    synth.open();
                    channels = synth.getChannels();
                    for (int j = 1; j < chordCount; j++) {
                        for (int k = 0; k < 3; k++) {
                            play(chordToNote(chords(chordCount, key).get(j)).get(k), 300);
                        }
                    }
                    synth.close();
                } catch (MidiUnavailableException | InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static List<String> chords(int chordCount, String key) {
        List<String> chordList = new ArrayList<String>();
        if (key.equalsIgnoreCase("C#")) {
            String[] cSharp = new String[] { "C#", "D#m", "E#m", "F#", "G#", "A#m" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(cSharp[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("F#")) {
            String[] fSharp = new String[] { "F#", "G#m", "A#m", "B", "C#", "D#m" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(fSharp[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("B")) {
            String[] b = new String[] { "B", "C#m", "D#m", "E", "F#", "G#m" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(b[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("E")) {
            String[] e = new String[] { "E", "F#m", "G#m", "A", "B", "C#m" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(e[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("A")) {
            String[] a = new String[] { "A", "Bm", "C#m", "D", "E", "F#m" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(a[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("D")) {
            String[] d = new String[] { "D", "Em", "F#m", "G", "A", "Bm" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(d[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("G")) {
            String[] g = new String[] { "G", "Am", "Bm", "C", "D", "Em" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(g[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("C")) {
            String[] c = new String[] { "C", "Dm", "Em", "F", "G", "Am" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(c[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("F")) {
            String[] f = new String[] { "F", "Gm", "Am", "Bb", "C", "Dm" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(f[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Bb")) {
            String[] bFlat = new String[] { "Bb", "Cm", "Dm", "Eb", "F", "Gm" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(bFlat[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Eb")) {
            String[] eFlat = new String[] { "Eb", "Fm", "Gm", "Ab", "Bb", "Cm" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(eFlat[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Ab")) {
            String[] c = new String[] { "Ab", "Bbm", "Cm", "Db", "Eb", "Fm" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(c[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Db")) {
            String[] dFlat = new String[] { "Db", "Ebm", "Fm", "Gb", "Ab", "Bbm" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(dFlat[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Cb")) {
            String[] cFlat = new String[] { "Cb", "Dbm", "Ebm", "Fb", "Gb", "Abm" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(cFlat[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Gb")) {
            String[] gFlat = new String[] { "Gb", "Abm", "Bbm", "Cb", "Db", "Ebm" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(gFlat[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("A#m")) {
            String[] aSharpMinor = new String[] { "A#m", "C#", "D#m", "E#m", "F#", "G#" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(aSharpMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("D#m")) {
            String[] dSharpMinor = new String[] { "D#m", "F#", "G#m", "A#m", "B", "C#" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(dSharpMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("G#m")) {
            String[] gSharpMinor = new String[] { "G#m", "B", "C#m", "D#m", "E", "F#" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(gSharpMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("C#m")) {
            String[] cSharpMinor = new String[] { "C#m", "E", "F#m", "G#m", "A", "B" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(cSharpMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("F#m")) {
            String[] fSharpMinor = new String[] { "F#m", "A", "Bm", "C#m", "D", "E" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(fSharpMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Bm")) {
            String[] bMinor = new String[] { "Bm", "D", "Em", "F#m", "G", "A" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(bMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Em")) {
            String[] eMinor = new String[] { "Em", "G", "Am", "Bm", "C", "D" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(eMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Am")) {
            String[] aMinor = new String[] { "Am", "C", "Dm", "Em", "F", "G" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(aMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Dm")) {
            String[] dMinor = new String[] { "Dm", "F", "Gm", "Am", "Bb", "C" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(dMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Gm")) {
            String[] gMinor = new String[] { "Gm", "Bb", "Cm", "Dm", "Eb", "F" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(gMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Cm")) {
            String[] cMinor = new String[] { "Cm", "Eb", "Fm", "Gm", "Ab", "Bb" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(cMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Fm")) {
            String[] fMinor = new String[] { "Fm", "Ab", "Bbm", "Cm", "Db", "Eb" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(fMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Bbm")) {
            String[] bFlatMinor = new String[] { "Bbm", "Db", "Ebm", "Fm", "Gb", "Ab" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(bFlatMinor[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Ebm")) {
            String[] gFlat = new String[] { "Ebm", "Gb", "Abm", "Bbm", "Cb", "Db" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(gFlat[random]);
            }
            return chordList;
        }
        if (key.equalsIgnoreCase("Abm")) {
            String[] aFlatMinor = new String[] { "Abm", "Cb", "Dbm", "Ebm", "Fb", "Gb" };
            for (int i = 0; i < chordCount; i++) {
                int random = new Random().nextInt(6);
                chordList.add(aFlatMinor[random]);
            }
            return chordList;
        } else
            return chordList;
    }

    private static void play(String note, int duration) throws InterruptedException {

        channels[INSTRUMENT].noteOn(id(note), VOLUME);

        Thread.sleep(duration);

        channels[INSTRUMENT].noteOff(id(note));
    }

    private static void rest(int duration) throws InterruptedException {
        Thread.sleep(duration);
    }

    private static int id(String note) {
        int octave = Integer.parseInt(note.substring(0, 1));
        return keys.indexOf(note.substring(1)) + 12 * octave + 12;
    }

    static List<String> chordToNote(String chord) {

        List<String> notes = new ArrayList<String>();
        if (chord.equalsIgnoreCase("C")) {
            notes.add("6C");
            notes.add("6E");
            notes.add("6G");
            return notes;
        }
        if (chord.equalsIgnoreCase("Dm")) {
            notes.add("6D");
            notes.add("6F");
            notes.add("6A");
            return notes;
        }
        if (chord.equalsIgnoreCase("Em")) {
            notes.add("6E");
            notes.add("6G");
            notes.add("6B");
            return notes;
        }
        if (chord.equalsIgnoreCase("F")) {
            notes.add("6F");
            notes.add("6A");
            notes.add("6G");
            return notes;
        }
        if (chord.equalsIgnoreCase("G")) {
            notes.add("6G");
            notes.add("6B");
            notes.add("6D");
            return notes;
        }
        if (chord.equalsIgnoreCase("Am")) {
            notes.add("6A");
            notes.add("6C");
            notes.add("6E");
            return notes;
        } else
            return notes;
    }
}
