package debug;

import utils.MacConverterLogic;

// debug and demo functions
public class Test {
    public static void main(String[] args) {
        TestA();
    }

    public static void TestA() {
        String[] input = {
            "00:B0:D0:63:C2:26",
            "AB:01:XX:DV:00:13",
            "00:00:00:00:00:00",
            "FF:FF:FF:FF:FF:FF",
            "FFFFFFFFFFFF",
            "dont be an idiot",
            "1238455we8dndssZxd",
            "99:99:99:99:999"
        };

        System.out.println("test mac-address stripping/formatting");

        for (int i = 0; i < input.length; i++) {
            String current = input[i];
            String stripped = MacConverterLogic.stripHex(current);
            String dotted =  MacConverterLogic.MacToDot(stripped);
            System.out.println("input: " + current + "\t stripped: " + stripped + "\t dotted: " + dotted);
        }
    }
}
