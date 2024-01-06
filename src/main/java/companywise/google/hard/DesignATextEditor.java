package src.main.java.companywise.google.hard;

public class DesignATextEditor {

    private int cursor;

    StringBuilder stringBuilder;

    public DesignATextEditor() {
        stringBuilder = new StringBuilder();
    }

    public void addText(String text) {
        stringBuilder.insert(cursor, text);
        cursor = cursor + text.length();
    }

    public int deleteText(int k) {
        if (cursor - k < 0) {
            stringBuilder.delete(0, cursor);
            int res = cursor;
            cursor = 0;
            return res;
        } else {
            stringBuilder.delete(cursor - k, cursor);
            cursor = cursor - k;
            return k;
        }
    }

    public String cursorLeft(int k) {
        int len = stringBuilder.length();
        if (cursor - k < 0) {
            cursor = 0;
            return "";
        } else {
            cursor = cursor - k;
            if (cursor - 10 < 0) {
                return stringBuilder.substring(0, cursor);
            } else {
                return stringBuilder.substring(cursor - 10 < 0 ? 0 : cursor - 10, cursor);
            }

        }
    }

    public String cursorRight(int k) {
        int len = stringBuilder.length();
        if (cursor + k > len) {
            cursor = len;
            return stringBuilder.substring(len - 10, len);
        } else {
            cursor = cursor + k;
            if (cursor - 10 < 0) {
                return stringBuilder.substring(0, cursor);
            } else {
                return stringBuilder.substring(cursor - 10 < 0 ? 0 : cursor - 10, cursor);
            }
        }
    }

    public static void main(String[] args) {
        DesignATextEditor obj = new DesignATextEditor();
        String cursorLeft = obj.cursorLeft(14);
        System.out.println(obj.stringBuilder.toString() + " cursor at = " + obj.cursor + " cursorLeft = " + cursorLeft );
        obj.addText("soxqep");
        cursorLeft = obj.cursorLeft(7);
        System.out.println(obj.stringBuilder.toString() + " cursor at = " + obj.cursor + " cursorLeft = " + cursorLeft );
        obj.addText("rfdrotsyeoy");
        String cursorRight = obj.cursorRight(19);
        System.out.println(obj.stringBuilder.toString() + " cursor at = " + obj.cursor + " cursorRight = " + cursorRight );
    }
}
