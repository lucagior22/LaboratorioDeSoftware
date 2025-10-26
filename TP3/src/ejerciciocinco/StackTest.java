package ejerciciocinco;

public class StackTest {

    public static void main(String[] args) {

        Stack stack = new Stack();
        String item1 = "Soy item 1";
        String item2 = "Soy item 2";
        String item3 = "Soy item 3";

        stack.push(item1);
        stack.push(item2);
        stack.push(item3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}
