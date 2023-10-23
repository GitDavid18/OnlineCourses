package Stacks;

public class StacksMain {
    public static void main(String[] args) {
        TestTwoStacks();
        var reverser = new StringReverser();

        System.out.println(reverser.reverse("My random string"));

        var expression = new ExpressionChecker();
        var balanced = "(([1] + <2>))[a]";
        var unbalanced = "((<1] + <2>))[a]";

        System.out.println(expression.IsBalanced(balanced));
        System.out.println(expression.IsBalanced(unbalanced));
    }

    private static void TestTwoStacks(){
        var stacks = new TwoStacks(5);

        stacks.push1(1);
        stacks.push1(2);
        stacks.push1(3);
        stacks.push1(4);
        System.out.println(stacks.toString());
        stacks.pop1();

        stacks.push2(88);
        System.out.println(stacks.toString());

    }
}
