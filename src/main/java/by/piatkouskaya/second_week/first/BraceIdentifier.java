package by.piatkouskaya.second_week.first;

import java.util.ArrayDeque;
import java.util.Deque;

public class BraceIdentifier {

    private static final String RIGHT_BRACKET = "(){}[]<>";
    private static final String OPEN_BRACKET = "{[(<";
    private static final String CLOSE_BRACKET = "}])>";

    private Deque<Character> openedBraces = new ArrayDeque<>();
    private Deque<Character> closedBrackets = new ArrayDeque<>();

    public boolean isCorrect(String stringLine) {
        stringLine.chars()
                .mapToObj(it -> (char) it)
                .forEach(this::writeToOpenedBracketCollection);

        stringLine.chars()
                .mapToObj(it -> (char) it)
                .forEach(this::writeToClosedBracketCollection);

        if (openedBraces.size() != closedBrackets.size()) {
            return false;
        }
        while (!openedBraces.isEmpty()) {
            char[] rightBracket = RIGHT_BRACKET.toCharArray();
            for (int i = 0; i < rightBracket.length; i++) {
                char open = rightBracket[i];
                if (open == openedBraces.getLast()) {
                    char close = rightBracket[i + 1];
                    if (close == closedBrackets.getFirst()) {
                        openedBraces.pollLast();
                        closedBrackets.pollFirst();
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void writeToOpenedBracketCollection(char ch) {
        OPEN_BRACKET.chars()
                .mapToObj(it -> (char) it)
                .filter(it -> it.equals(ch))
                .forEach(it -> openedBraces.add(it));
    }

    private void writeToClosedBracketCollection(char ch) {
        CLOSE_BRACKET.chars()
                .mapToObj(it -> (char) it)
                .filter(it -> it.equals(ch))
                .forEach(it -> closedBrackets.add(it));
    }
}