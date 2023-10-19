package Stacks;

public class StacksMain {
    public static void main(String[] args) {
        var reverser = new StringReverser();

        System.out.println(reverser.reverse("My random string"));

        var expression = new ExpressionChecker();
        var balanced = "(([1] + <2>))[a]";
        var unbalanced = "((<1] + <2>))[a]";

        System.out.println(expression.IsBalanced(balanced));
        System.out.println(expression.IsBalanced(unbalanced));
    }
}
