package Oving4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

//5-2 page 109
public class Stack<Brackets>{
    static class Brackets{
        char aChar;

        public Brackets(char aChar) {
            this.aChar = aChar;
        }

        @Override
        public String toString() {
            return "" + aChar;
        }
    }

    private LinkedList<Brackets> stack = new LinkedList<>();

    public Stack() {
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public Brackets peeklast(){
        return stack.peekLast();
    }

    public void push(Brackets b){
        stack.addLast(b);
        System.out.println(b.toString() + " added to stack");
    }

    public void pop(){
        if (!stack.isEmpty()) {
            System.out.println(stack.peekLast() + " removed from stack");
            stack.removeLast();
        }
    }

    public void checkToPop(Stack<Stack.Brackets> stack, char aChar){
        char check = stack.peeklast().aChar;
        if (aChar == '}' && check == '{'){
            System.out.println("Siste verdi i stacken " + check + " er lik motsatte av inputverdien " + aChar);
            stack.pop();
            return;
        }
        if (aChar == ']' && check == '['){
            System.out.println("Siste verdi i stacken " + check + " er lik motsatte av inputverdien " + aChar);
            stack.pop();
            return;
        }
        if (aChar == ')' && check == '('){
            System.out.println("Siste verdi i stacken " + check + " er lik motsatte av inputverdien " + aChar);
            stack.pop();
        } else {

            System.out.println("Siste verdi i stacken " + check + " er ikke lik motsatte av inputverdien " + aChar);
        }
    }

    public boolean isReversed(Stack.Brackets bracket){//tenkte jeg bare skulle skjekke om char var omvendt men den kunne
                                                    //vært omvendt for feil parantes.
        if (bracket.aChar == ']' || bracket.aChar == ')' || bracket.aChar == '}') {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Stack: " + stack ;
    }

    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("./Oving4_2.java");
            BufferedReader br = new BufferedReader(reader);
            String line;
            Stack<Stack.Brackets> stack = new Stack<>();
            while ((line = br.readLine()) != null){
                for (char aChar : line.toCharArray()){
                    if (aChar == '(' || aChar == '[' || aChar == '{'){
                        stack.push(new Stack.Brackets(aChar));
                        System.out.println(stack.toString());
                    }
                    if (aChar == '}' || aChar == ']' || aChar == ')'){
                        System.out.println("Sammenligner " + aChar + " med siste parantes i stacken.");
                        if (stack.isEmpty()){
                            System.out.println("Stacken er tom, sammenligning failer programmet er ikke fullstendig.");
                            System.out.println(stack.toString());
                            System.exit(0);
                        }
                        stack.checkToPop(stack, aChar);
                        System.out.println(stack.toString());
                    }
                }
            }
            if (!stack.isEmpty()){
                System.out.println("Stacken er ikke tom programmet er ikke fullstendig.");
                System.out.println(stack.toString());
                System.exit(0);
            }
            System.out.println(stack.toString());
            br.close();
        } catch (IOException f){
            System.out.println(f.getMessage());
        }
    }
}