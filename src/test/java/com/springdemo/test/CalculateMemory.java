package com.springdemo.test;

public class CalculateMemory {
    public static void main(String[] args) {
        String str = "struct{char short int struct{char double int}}";
        System.out.println(calculate(str)*4);
    }
    private static int calculate(String str) {
        str = str.replace("char", "C").replace("short", "S").replace("int", "I").replace("double", "D")
            .replace("struct", "A").replace(" ", "");
        str = str.substring(str.indexOf("{") + 1, str.lastIndexOf("}"));
        int cnt = cal(str);

        return cnt;
    }

    private static int cal(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); ++i) {
            switch (str.charAt(i)) {
                case 'D':
                    cnt += 2;
                    break;
                case 'I':
                    cnt += 1;
                    break;
                case 'C':
                    cnt += 1;
                    if (i + 1 < str.length()) {
                        if (str.charAt(i + 1) == 'I' || str.charAt(i + 1) == 'D' || str.charAt(i + 1) == 'A')
                            continue;
                        i += 1;
                        if (str.charAt(i) == 'S') {
                            if (i + 1 < str.length() && str.charAt(i + 1) == 'C') {
                                i += 1;
                            }
                        } else {
                            if (i + 1 < str.length()) {
                                if (str.charAt(i + 1) == 'S') {
                                    i += 1;
                                } else if (str.charAt(i + 1) == 'C') {
                                    i += 1;
                                    if (i + 1 < str.length() && str.charAt(i + 1) == 'C') {
                                        i += 1;
                                    }
                                }
                            }
                        }

                    }
                    break;
                case 'S':
                    cnt += 1;
                    if (i + 1 < str.length()) {
                        if (str.charAt(i + 1) == 'I' || str.charAt(i + 1) == 'D' || str.charAt(i + 1) == 'A')
                            continue;
                        i += 1;
                        if (str.charAt(i) == 'S') {
                            i += 1;
                        } else {
                            if (i + 1 < str.length()) {
                                if (str.charAt(i + 1) == 'C') {
                                    i += 1;
                                }
                            }
                        }
                    }
                    break;
                case 'A':
                    cnt += cal(str.substring(str.indexOf("{") + 1, str.lastIndexOf("}")));
                    i = str.lastIndexOf("}");
                    break;
                default:
                    break;
            }

        }
        return cnt;
    }
}
