public class Main {
    public static void main(String[] args) {
        useString();
        useStringBuffer();

        String parag = "Python. No need to talk much about Python. Python is very much of Python. "
                        + "Python is widely use in various fields of science! What more? Python "
                        + "can perform superb in AI era! That's impressive, isn't it?";
        contentAnalysis(parag);
    }

    // 1st and 2nd function
    public static void useString() {
        String fmt = "";

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) fmt+="Hello";
        long end = System.currentTimeMillis();

        long time = end - start;
        System.out.println("[!] useString: " + time + " (ms)");
    }
    public static void useStringBuffer() {
        StringBuffer fmt = new StringBuffer();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) fmt.append("Hello");
        long end = System.currentTimeMillis();
        
        long time = end - start;
        System.out.println("[!] useStringBuffer: " + time + " (ms)");
    }

    // 3rd function
    public static int countChar(String parag, Character c) {
        int count = 0;
        int id = parag.indexOf(c);
        while (id != -1) {
            count += 1;
            id = parag.indexOf(c, id + 1);
        }
        return count;
    }
    public static String findAndReplace(String parag, String reg, String rep) {
        int oldLen = reg.length();
        int newLen = rep.length();
        StringBuffer sub = new StringBuffer(parag);

        int id = sub.indexOf(reg);
        while (id != -1) {
            sub.delete(id, id + oldLen);
            sub.insert(id, rep);
            id = sub.indexOf(reg, id + newLen);
        }
        return sub.toString();
    }
    public static void contentAnalysis(String parag) {
        int dot = countChar(parag, '.');
        int que = countChar(parag, '?');
        int exc = countChar(parag, '!');
        int sens = dot + que + exc;
        System.out.println(" - Paragraph has " + sens + " sentence(s)");

        System.out.println(" - New paragraph after replace 'Python' to 'Java':");
        System.out.println(findAndReplace(parag, "Python", "Java"));
    }
}
