
import java.util.Scanner;
import java.lang.String;

public class Calc_String {



    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    String[] operator = {" + ", " - ", " / ", " * "};
    String[] tokens = input.split(" \\- | \\+ | \\* | \\/ ");
    String a = tokens[0];
    String b = tokens[1];


    public String chekLenght(String e)throws Exception{

        char[] a1 = e.toCharArray();

        char[] res = new char[a1.length - 2];
        int l = 0;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] == '"') {
                continue;
            }
            try {
                res[l] = a1[i];
            } catch (ArrayIndexOutOfBoundsException s) {
            }
            l++;
        }
        String e1 = String.valueOf(res);
        if (a1.length > 12 | a1[0] != '"' | a1[a1.length - 1] != '"') {
            throw new MyExeption("Не верно введена переменная");
        }

        return e1;

    }

    public String chekOperator(String s) {

        for (int i = 0; i < operator.length; i++) {
            if (input.contains(operator[i])) {
                s=operator[i];
            }
        }
        return s;
    }
    public static String intAuthentificator (String input)throws Exception {
        String symb = input;
        int a1=0;
        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(input);
            a1=a;
            symb = String.valueOf(a);
        }
        if(a1>10|a1<1){
            throw new MyExeption("Не допустимая переменная");
        }

        return symb;


    }
    public static String result1(String s){
        System.out.println("Ответ: "+'"'+s+'"');
        return s;
    }

}
class Calc_StrPlusStr extends Calc_String {
    public static void main(String[] args) throws Exception{
        System.out.println("Введите арифметическое выражение используя " + '"' + " для строк");
        Calc_String i1 = new Calc_String();
        String a1 = i1.chekLenght(i1.a);
        String op = i1.chekOperator(i1.a);


        if (op==" + "){
            String b2 = i1.chekLenght(i1.b);
            String res = a1+b2;
            result1(res);

        }
        if (op==" - "){
            String b3 = i1.chekLenght(i1.b);
            String res = a1.replace(b3,"");
            result1(res);
        }
        if (op==" * "){
            i1.intAuthentificator(i1.b);
            String res =a1.repeat(Integer.parseInt(i1.b));
            if (res.length()>40) {
                String s1 = res.substring(0,40)+"...";
                res=s1;
            }
            result1(res);

        }
        if (op==" / "){
            intAuthentificator(i1.b);
            int b2 = Integer.parseInt(i1.b);
            int opi = a1.length()/b2;
            String res = a1.substring(0,opi);
            result1(res);

        }
    }}